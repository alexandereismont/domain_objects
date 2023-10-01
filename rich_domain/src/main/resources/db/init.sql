CREATE TABLE IF NOT EXISTS shop (
    ID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100),
    location VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS product (
    ID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100),
    labels VARCHAR(200)
);


CREATE TABLE IF NOT EXISTS inventory (
    ID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    shop_id INTEGER,
    product_id INTEGER,
    quantity INTEGER,
    created_at DATE,
    updated_at DATE,
    CONSTRAINT fk_shop
        FOREIGN KEY(shop_id)
            REFERENCES shop(id),
    CONSTRAINT fk_product
        FOREIGN KEY(product_id)
            REFERENCES product(id)
);
