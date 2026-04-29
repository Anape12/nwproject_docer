CREATE TABLE users_info (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(20),
  password VARCHAR(30),
  birthday DATE,
  permission VARCHAR(5),
  delete_flg VARCHAR(5)
);

INSERT INTO users_info (name, password, birthday, permission, delete_flg)
VALUES ('a0001', 'k1226', '1993-12-26', '1', '0'),
       ('a0002', 'm0526', '1956-05-26', '2', '0');