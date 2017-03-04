package model;

import java.time.LocalDate;

public class Gun {
//    id            VARCHAR(50) PRIMARY KEY,
    private String id;

//    model_id      INT  NOT NULL,
    private GunModel model;

//    dob           DATE NOT NULL,
    private LocalDate dob;

//    is_used       BOOL DEFAULT FALSE,
    private boolean used;

//    delivery_date DATE NOT NULL,
    private LocalDate deliveryDate;

//    buyer_id      INT  NULL
    private User buyer;
}
