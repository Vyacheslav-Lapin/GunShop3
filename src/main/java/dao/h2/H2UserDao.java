package dao.h2;

import dao.UserDao;
import lombok.SneakyThrows;
import model.Address;
import model.License;
import model.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class H2UserDao implements UserDao {

    public static final String SELECT_ALL_SQL =
            "SELECT id, first_name, last_name, pathronimic, nickname, dob, address_id, a.city, a.flat, a.house, " +
                    "a.street, license_id, telephone, email, password " +
                    "FROM User u, Address a " +
                    "WHERE u.address_id = a.id";

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    @Override
    @SneakyThrows
    public int create(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO User (first_name, last_name, pathronimic, nickname, dob, address_id, license_id, telephone, email, password) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, user.getFirstName());
            preparedStatement.setObject(2, user.getLastName());
            preparedStatement.setObject(3, user.getPathronimic());
            preparedStatement.setObject(4, user.getNickname());
            preparedStatement.setObject(5, user.getDob());
            preparedStatement.setObject(6, user.getAddress().getId());
            preparedStatement.setObject(7, user.getLicense().ordinal() + 1); // TODO: 04/03/2017 переделать на спец. поле
            preparedStatement.setObject(8, user.getTelephone());
            preparedStatement.setObject(9, user.getEmail());
            preparedStatement.setObject(10, user.getPasswordHash());

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next())
                    user.setId(generatedKeys.getInt(1));
            }
        }

        return user.getId();
    }

    @Override
    public void remove(User user) {

    }

    @Override
    @SneakyThrows
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
            while (resultSet.next())
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("pathronimic"),
                        resultSet.getString("nickname"),
                        resultSet.getDate("dob").toLocalDate(),
                        new Address(
                                resultSet.getInt("address_id"),
                                resultSet.getString("street"),
                                resultSet.getString("city"),
                                resultSet.getString("house"),
                                resultSet.getInt("flat")),
                        License.valueOf(
                                resultSet.getInt("license_id") - 1)
                                .orElseThrow(() -> new RuntimeException("нет такой лицензии!")),
                        resultSet.getString("telephone"),
                        resultSet.getString("email"),
                        resultSet.getString("password") // TODO: 04/03/2017 подумать!
                ));
        }
        return users;
    }
}
