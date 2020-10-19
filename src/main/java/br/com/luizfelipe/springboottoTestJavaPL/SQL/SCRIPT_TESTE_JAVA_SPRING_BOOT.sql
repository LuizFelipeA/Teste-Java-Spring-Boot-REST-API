CREATE TABLE user (
        Id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
        Name VARCHAR(200),
        Email VARCHAR(200),
        Birthdate DATE,
        CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
        UpdatedAt DATETIME ON UPDATE CURRENT_TIMESTAMP,
        Enable BOOLEAN NOT NULL DEFAULT 1
)

CREATE TABLE product (
        Id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
        Description VARCHAR(200),
        price DECIMAL,
        CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
        UpdatedAt DATETIME ON UPDATE CURRENT_TIMESTAMP
)

CREATE TABLE orders (
        Id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
        Id_User INT NOT NULL,
        Id_Product INT NOT NULL,
        status VARCHAR(200),
        Price DOUBLE,
        CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
        UpdatedAt DATETIME ON UPDATE CURRENT_TIMESTAMP,
        CONSTRAINT FK_UserOrders FOREIGN KEY (Id_User) REFERENCES user (Id),
        CONSTRAINT FK_ProductOrders FOREIGN KEY (Id_Product) REFERENCES product (Id)
)

INSERT INTO user VALUES (1, 'Luiz felipe', 'test@test.com','2020-12-12', now(), now(), true)

INSERT INTO product VALUES(1, "Tenis Nike", 10.98, NOW(), NOW())
INSERT INTO product VALUES(2, "Camiseta", 342.32, NOW(), NOW())
INSERT INTO product VALUES(3, "Notebook Dell", 190.69, NOW(), NOW())
INSERT INTO product VALUES(4, "Smartphone", 265.56, NOW(), NOW())