CREATE TABLE user_tbl
(
  id       INTEGER PRIMARY KEY NOT NULL,
  name     VARCHAR(20)         NOT NULL,
  password VARCHAR(20)         NOT NULL
);
CREATE UNIQUE INDEX user_tbl_name_uindex
  ON user_tbl (id);
INSERT INTO user_tbl (name, password, dept_id) VALUES ('su', '123', 1);
INSERT INTO user_tbl (name, password, dept_id) VALUES ('zhangsan', '123', 2);

CREATE TABLE user_role_map
(
  id      INTEGER PRIMARY KEY NOT NULL,
  user_id INTEGER,
  role_id INTEGER
);
CREATE UNIQUE INDEX user_role_map_id_uindex
  ON user_role_map (id);
INSERT INTO user_role_map (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role_map (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role_map (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role_map (user_id, role_id) VALUES (2, 2);

CREATE TABLE role_tbl
(
  id   INTEGER PRIMARY KEY NOT NULL,
  name VARCHAR(20)
);
CREATE UNIQUE INDEX role_tbl_id_uindex
  ON role_tbl (id);
INSERT INTO role_tbl (id, name) VALUES (1, 'admin');
INSERT INTO role_tbl (id, name) VALUES (2, 'user');

CREATE TABLE dept_tbl
(
  id   INTEGER PRIMARY KEY NOT NULL,
  name VARCHAR(20)
);
CREATE UNIQUE INDEX dept_tbl_id_uindex
  ON dept_tbl (id);
INSERT INTO dept_tbl (id, name) VALUES (1, '研发部');
INSERT INTO dept_tbl (id, name) VALUES (2, '人事部');