INSERT INTO Address (street, city, house, flat) VALUES (
  'testStreet',
  'TestCity',
  '21b',
  15);

INSERT INTO LicenseLevel (name, description) VALUES ('NONE', '');
INSERT INTO LicenseLevel (name, description) VALUES ('TRAUMATIC', '');
INSERT INTO LicenseLevel (name, description) VALUES ('HUNTER', '');
INSERT INTO LicenseLevel (name, description) VALUES ('POLICE', '');
INSERT INTO LicenseLevel (name, description) VALUES ('MILITARY', '');

INSERT INTO User (first_name, last_name, nickname, dob, address_id, license_id, telephone, email, password)
VALUES ('Вася',
        'Пупкин',
        'VasyaPupkin',
        1989 - 03 - 04,
        1,
        2,
        '222-33-22',
        'VasyaPupkin@mail.ru',
        'qwerty');

INSERT INTO GunModel (name, license_level, caliber, length, is_rifled, capacity)
VALUES ('Парабеллум', 4, 9, 102, TRUE, 8);

INSERT INTO Gun (id, model_id, dob, delivery_date) VALUES (
  '987345083249872456',
  1,
  1889 - 03 - 04,
  2017 - 03 - 04);

INSERT INTO Gun (id, model_id, dob, delivery_date) VALUES (
  '732645879263452564',
  1,
  1889 - 03 - 04,
  2017 - 03 - 04);

INSERT INTO Gun (id, model_id, dob, delivery_date) VALUES (
  '387653415876345983',
  1,
  1889 - 03 - 04,
  2017 - 03 - 04);