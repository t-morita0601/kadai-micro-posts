CREATE TABLE user_follows (
  id        SERIAL,
  user_id   BIGINT        NOT NULL REFERENCES users(id),
  follow_id BIGINT        NOT NULL REFERENCES users(id),
  create_at TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_at TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(id),
  UNIQUE(user_id, follow_id)
)
