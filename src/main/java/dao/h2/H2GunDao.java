package dao.h2;

import dao.GunDao;
import javaslang.Function1;
import lombok.SneakyThrows;
import model.Gun;
import model.GunModel;
import model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class H2GunDao implements GunDao {

    public static final String SELECT_ALL_SQL =
            "SELECT id, model_id, dob, is_used, delivery_date, buyer_id FROM Gun";

    private DataSource dataSource;

    Function1<Integer, User> getUserById;
    Function1<Integer, GunModel> getGunModelById;

    public H2GunDao(DataSource dataSource,
            Function1<Integer, User> getUserById,
            Function1<Integer, GunModel> getGunModelById) {
        this.dataSource = dataSource;
        this.getUserById = getUserById;
        this.getGunModelById = getGunModelById;
    }

    @Override
    public String save() {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    @SneakyThrows
    public Collection<Gun> getAll() {
        List<Gun> users = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
            while (resultSet.next())
                users.add(new Gun(
                        resultSet.getString("id"),
                        getGunModelById.apply(resultSet.getInt("model_id")),
                        resultSet.getDate("dob").toLocalDate(),
                        resultSet.getBoolean("is_used"),
                        resultSet.getDate("delivery_date").toLocalDate(),
                        getUserById.apply(resultSet.getInt("buyer_id"))
                ));
        }
        return users;
    }
}
