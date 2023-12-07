CREATE TABLE IF NOT EXISTS transactions (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    account_id BIGINT NOT NULL,
    type VARCHAR(255) NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(id)

);