INSERT INTO categories (name)
VALUES ('Fruits'),
       ('Vegetables'),
       ('Dairy'),
       ('Beverages'),
       ('Snacks');
INSERT INTO products (name, price, description, category_id)
VALUES ('Apple', 0.99, 'Fresh red apples, sold per pound.', 1),
       ('Banana', 0.59, 'Ripe yellow bananas, sold per pound.', 1),
       ('Carrot', 1.29, 'Organic carrots, sold in bunches.', 2),
       ('Broccoli', 2.49, 'Fresh green broccoli heads.', 2),
       ('Milk', 3.99, 'Whole milk, 1 gallon.', 3),
       ('Cheese', 4.99, 'Cheddar cheese block, 8 oz.', 3),
       ('Orange Juice', 2.99, 'Fresh squeezed orange juice, 64 oz.', 4),
       ('Soda', 1.49, 'Cola soda, 2 liter bottle.', 4),
       ('Potato Chips', 2.79, 'Classic salted potato chips, 8 oz bag.', 5),
       ('Chocolate Bar', 1.99, 'Milk chocolate bar, 3.5 oz.', 5);