DROP TABLE IF EXISTS user_order;
DROP TABLE IF EXISTS line_item;

CREATE TABLE user_order (
  id VARCHAR(64) NOT NULL,
  name VARCHAR(50) NULL,
  PRIMARY KEY (id)
);
CREATE TABLE line_item (
  id VARCHAR(64) NOT NULL,
  user_order_id VARCHAR(64) NOT NULL,
  name VARCHAR(50),
  quantity INT,
  unit_price DECIMAL(10,2),
  PRIMARY KEY (id)
);
