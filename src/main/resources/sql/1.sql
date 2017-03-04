CREATE TABLE Address (
  id     INT AUTO_INCREMENT PRIMARY KEY,
  street VARCHAR(255) NOT NULL,
  city   VARCHAR(100) NOT NULL,
  house  VARCHAR(20)  NOT NULL,
  flat   INT
);

CREATE TABLE LicenseLevel (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(100) NOT NULL,
  description VARCHAR(1000)
);

CREATE TABLE User (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  first_name  VARCHAR(50)  NOT NULL,
  last_name   VARCHAR(50)  NOT NULL,
  pathronimic VARCHAR(255),
  nickname    VARCHAR(50)  NOT NULL,
  dob         DATE,
  address_id  INT,
  license_id  INT,
  telephone   VARCHAR(100) NOT NULL,
  email       VARCHAR(100) NOT NULL,
  password    VARCHAR(255) NOT NULL,

  FOREIGN KEY (address_id) REFERENCES Address (id),
  FOREIGN KEY (license_id) REFERENCES LicenseLevel (id),
  UNIQUE (nickname),
  UNIQUE (email)
);

CREATE TABLE GunModel (
  id            INT AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(255) NOT NULL,
  license_level INT          NOT NULL,
  caliber       FLOAT        NOT NULL,
  length        FLOAT        NOT NULL,
  is_rifled     BOOL         NOT NULL,
  capacity      INT          NOT NULL,

  FOREIGN KEY (license_level) REFERENCES LicenseLevel (id)
);

CREATE TABLE Gun (
  id            VARCHAR(50) PRIMARY KEY,
  model_id      INT  NOT NULL,
  dob           DATE NOT NULL,
  is_used       BOOL DEFAULT FALSE,
  delivery_date DATE NOT NULL,
  buyer_id      INT  NULL,

  FOREIGN KEY (model_id) REFERENCES GunModel (id),
  FOREIGN KEY (buyer_id) REFERENCES User (id)
);