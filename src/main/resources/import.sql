CREATE TABLE article_tag_map
(
  id         INTEGER NOT NULL,
  article_id INTEGER,
  tag_id     INTEGER
);

CREATE UNIQUE INDEX article_tag_map_id_uindex
  ON article_tag_map (id);

CREATE TABLE article_tbl
(
  id          INTEGER,
  title       VARCHAR(100) NOT NULL,
  content     CLOB,
  author      INTEGER,
  update_time DATE DEFAULT datetime('now', 'localtime')
);

CREATE UNIQUE INDEX article_tbl_id_uindex
  ON article_tbl (id);

CREATE TABLE dept_tbl
(
  id   INTEGER     NOT NULL,
  name VARCHAR(20) NOT NULL
);

CREATE UNIQUE INDEX dept_tbl_name_uindex
  ON dept_tbl (id);

CREATE TABLE role_tbl
(
  id   INTEGER NOT NULL,
  name VARCHAR(20)
);

CREATE UNIQUE INDEX role_tbl_id_uindex
  ON role_tbl (id);

CREATE TABLE tag_tbl
(
  id   INTEGER     NOT NULL,
  name VARCHAR(20) NOT NULL,
  type VARCHAR(20)
);

CREATE UNIQUE INDEX tag_tbl_id_uindex
  ON tag_tbl (id);

CREATE TABLE user_role_map
(
  id      INTEGER NOT NULL,
  user_id INTEGER,
  role_id INTEGER
);

CREATE UNIQUE INDEX user_role_map_id_uindex
  ON user_role_map (id);

CREATE TABLE user_tbl
(
  id       INTEGER     NOT NULL
    PRIMARY KEY,
  name     VARCHAR(20) NOT NULL,
  dept_id  INTEGER,
  password VARCHAR(50)
);

CREATE UNIQUE INDEX user_tbl_name_uindex
  ON user_tbl (name);

INSERT INTO user_role_map (id, user_id, role_id) VALUES (1, 1, 1);
INSERT INTO user_tbl (id, name, dept_id, password) VALUES (1, 'admin', 1, '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO role_tbl (id, name) VALUES (1, 'admin');