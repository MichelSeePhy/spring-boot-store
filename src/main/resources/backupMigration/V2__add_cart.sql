CREATE TABLE Cart
(
    id          BINARY(16) NOT NULL DEFAULT (uuid_to_bin(uuid())),
    dateCreated VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

