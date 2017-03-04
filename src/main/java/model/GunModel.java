package model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data // TODO: 04/03/2017 make Value and check DAO layer
@Accessors(chain = true)
public class GunModel {
    //    id            INT AUTO_INCREMENT PRIMARY KEY,
    private int id;

//    name          VARCHAR(255) NOT NULL,
    private String name;

//    license_level INT          NOT NULL,
    private License license;

//    caliber       FLOAT        NOT NULL,
    private double caliber;

//    length        FLOAT        NOT NULL,
    private double length;

//    is_rifled     BOOL         NOT NULL,
    private boolean rifled;

//    capacity      INT          NOT NULL,
    private int capacity;
}
