INSERT INTO t_user (name, password)
VALUES ('dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu'),
       ('dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu');

INSERT INTO t_role (name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER');

INSERT INTO t_user_role (user_id, role_id)
VALUES (
           (SELECT id FROM t_user WHERE name = 'dbuser1'),
           (SELECT id FROM t_role WHERE name = 'ROLE_USER')
),
(
           (SELECT id FROM t_user WHERE name = 'dbadmin1'),
           (SELECT id FROM t_role WHERE name = 'ROLE_ADMIN')
),
(
           (SELECT id FROM t_user WHERE name = 'dbadmin1'),
           (SELECT id FROM t_role WHERE name = 'ROLE_USER')
);

