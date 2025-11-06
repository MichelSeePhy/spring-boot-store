CREATE TABLE CartItem
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    cart     BINARY(16) NOT NULL,
    product  BIGINT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (cart) REFERENCES Cart(id),
    FOREIGN KEY (product) REFERENCES Products(id)
);