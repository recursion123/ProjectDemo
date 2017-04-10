CREATE TABLE user_tbl
(
  id       INTEGER PRIMARY KEY NOT NULL,
  name     VARCHAR(20)         NOT NULL,
  password VARCHAR(20)         NOT NULL
);
CREATE UNIQUE INDEX user_tbl_name_uindex
  ON user_tbl (name);
INSERT INTO user_tbl (name, password, id) VALUES ('su', '123', 13);
INSERT INTO user_tbl (name, password, id) VALUES ('zhang', '123', 14);
INSERT INTO user_tbl (name, password, id) VALUES ('lisi', '123456789', 33);

CREATE TABLE user_role_map
(
  id      INTEGER PRIMARY KEY NOT NULL,
  user_id INTEGER,
  role_id INTEGER
);
CREATE UNIQUE INDEX user_role_map_id_uindex
  ON user_role_map (id);
INSERT INTO user_role_map (user_id, role_id, id) VALUES (13, 1, 0);
INSERT INTO user_role_map (user_id, role_id, id) VALUES (13, 2, 1);
INSERT INTO user_role_map (user_id, role_id, id) VALUES (33, 1, 6);
INSERT INTO user_role_map (user_id, role_id, id) VALUES (33, 2, 7);

CREATE TABLE role_tbl
(
  id   INTEGER PRIMARY KEY NOT NULL,
  name VARCHAR(20)
);
CREATE UNIQUE INDEX role_tbl_id_uindex
  ON role_tbl (id);
INSERT INTO role_tbl (id, name) VALUES (1, 'admin');
INSERT INTO role_tbl (id, name) VALUES (2, 'user');