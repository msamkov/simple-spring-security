CREATE TABLE s_membership.t_user
(
  id         serial,
  login      text NOT NULL,
  password   text NOT NULL,
  enabled    boolean NOT NULL,
  CONSTRAINT "t_user_pkey" PRIMARY KEY (id)
) ;

COMMENT ON TABLE  s_membership.t_user IS 'Пользователи';
COMMENT ON COLUMN s_membership.t_user.id IS 'Идентификатор';
COMMENT ON COLUMN s_membership.t_user.login IS 'Логин';
COMMENT ON COLUMN s_membership.t_user.password IS 'Пароль';
COMMENT ON COLUMN s_membership.t_user.enabled IS 'Вкл/выкл учёт.запись';