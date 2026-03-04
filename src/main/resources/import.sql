
-- 1. Автосалоны
INSERT INTO dealer_ship (city, full_address, phone, email, name) VALUES
                                                                     ('Москва', 'ул. Ленина, д. 1', '+7 (495) 123-45-67', 'moscow@auto.ru', 'АвтоДом Москва'),
                                                                     ('СПб', 'пр. Невский, д. 100', '+7 (812) 234-56-78', 'spb@auto.ru', 'АвтоДом СПб');

-- 2. Покупатели
INSERT INTO customer (first_name, last_name, phone, email) VALUES
                                                               ('Иван', 'Петров', '+7 (999) 111-22-33', 'ivan@mail.ru'),
                                                               ('Мария', 'Иванова', '+7 (999) 222-33-44', 'maria@mail.ru');

-- 3. Машины на продаже
INSERT INTO sale_car (mark, model, year_born, amount, dealer_ship_id, seller_id_old, status) VALUES
                                                                                                 ('Toyota', 'Camry', '2023', 2500000, 1, 1, 'available'),
                                                                                                 ('BMW', 'X5', '2022', 5500000, 2, 2, 'available');

-- 4. Заявки
INSERT INTO sale_task (mark, model, year_born, amount, dealer_ship_id, seller_id, status, comment) VALUES
    ('Lada', 'Vesta', '2024', 1200000, 1, 1, 'PENDING', 'Хотят тест-драйв');

-- 5. Проданные
INSERT INTO sold_car (mark, model, year_born, amount, dealer_ship_id, seller_id_old, seller_id_new, status, date_sold) VALUES
    ('Kia', 'Rio', '2023', 1800000, 2, 1, 2, 'SOLD', NOW());