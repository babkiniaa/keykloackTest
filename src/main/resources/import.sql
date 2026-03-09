-- =====================================================
-- 1. АВТОСАЛОНЫ (ID будут 1, 2)
-- =====================================================
INSERT INTO dealer_ship (city, full_address, phone, email, name, is_active) VALUES
                                                                                ('Москва', 'ул. Ленина, д. 1', '+7 (495) 123-45-67', 'moscow@auto.ru', 'АвтоДом Москва', 1),
                                                                                ('СПб', 'пр. Невский, д. 100', '+7 (812) 234-56-78', 'spb@auto.ru', 'АвтоДом СПб', 1);

-- =====================================================
-- 2. ПОКУПАТЕЛИ (ID будут 1, 2)
-- =====================================================
INSERT INTO customer (first_name, last_name, phone, email) VALUES
                                                               ('Иван', 'Петров', '+7 (999) 111-22-33', 'ivan@mail.ru'),
                                                               ('Мария', 'Иванова', '+7 (999) 222-33-44', 'maria@mail.ru');

-- =====================================================
-- 3. БАЗОВАЯ ТАБЛИЦА CAR (ID будут 1, 2, 3, 4)
-- =====================================================
INSERT INTO Car (description, mark, model, year_born, url_photo, mileage, amount, dealer_ship_id, date_publication) VALUES
                                                                                                                        ('Отличное состояние', 'Toyota', 'Camry', '2023', 'toyota.jpg', 15000, 2500000, 1, NOW()),
                                                                                                                        ('Полный привод', 'BMW', 'X5', '2022', 'bmw.jpg', 25000, 5500000, 2, NOW()),
                                                                                                                        ('Новая', 'Lada', 'Vesta', '2024', 'lada.jpg', 0, 1200000, 1, NOW()),
                                                                                                                        ('Быстрая продажа', 'Kia', 'Rio', '2023', 'kia.jpg', 10000, 1800000, 2, NOW());

-- =====================================================
-- 4. ДОЧЕРНИЕ ТАБЛИЦЫ (используем те же ID)
-- =====================================================

-- Машины на продаже (ID 1 и 2 - Toyota и BMW)
INSERT INTO sale_car (id, seller_id_old) VALUES
                                             (1, 1),  -- Toyota Camry, продавец Иван (ID=1)
                                             (2, 2);  -- BMW X5, продавец Мария (ID=2)

-- Заявка на продажу (ID 3 - Lada)
INSERT INTO sale_task (id, seller_id, status, comment, request_date) VALUES
    (3, 1, 'PENDING', 'Хотят тест-драйв', NOW());

-- Проданные машины (ID 4 - Kia)
INSERT INTO sold_car (id, seller_id_old, seller_id_new, status, date_sold) VALUES
    (4, 1, 2, 'SOLD', NOW());