package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public static String FIRST_NAME_KEY = "firstName";

//    id            INT AUTO_INCREMENT PRIMARY KEY,
    private int id;

//    first_name    VARCHAR(50)  NOT NULL,
    private String firstName;

//    last_name     VARCHAR(50)  NOT NULL,
    private String lastName;

//    pathronimic   VARCHAR(255),
    private String pathronimic;

//    nickname      VARCHAR(50)  NOT NULL,
    private String nickname;

//    dob           DATE,
    private LocalDate dob;

//    address_id    INT,
    private Address address;

//    license_level INT,
    private License license;

//    telephone     VARCHAR(100) NOT NULL,
    private String telephone;

//    email         VARCHAR(100) NOT NULL,
    private String email;

//    password      VARCHAR(255) NOT NULL,
    private String passwordHash;
}
