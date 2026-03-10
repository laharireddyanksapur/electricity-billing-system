CREATE TABLE users (
  id INT PRIMARY KEY,
  name VARCHAR(100),
  address VARCHAR(255)
);

CREATE TABLE bills (
  id INT PRIMARY KEY,
  user_id INT,
  amount DECIMAL(10,2),
  billing_date DATE
);
