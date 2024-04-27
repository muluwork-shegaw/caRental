INSERT INTO address (street_address, city, state, postal_code, created_at, updated_at)
VALUES ('1 Infinite Loop', 'Cyberville', 'XY', '99999', NOW(), NOW()),
       ('2 Neverland Dr', 'Fairytale Land', 'ZZ', '88888', NOW(), NOW()),
       ('3 Utopia Ave', 'Perfectville', 'WW', '77777', NOW(), NOW()),
       ('4 Atlantis St', 'Oceania', 'OO', '66666', NOW(), NOW()),
       ('5 Shangri-La Ln', 'Paradise', 'PP', '55555', NOW(), NOW()),
       ('6 Narnia Rd', 'Chronicles', 'CN', '44444', NOW(), NOW()),
       ('7 El Dorado Blvd', 'Mythica', 'MY', '33333', NOW(), NOW()),
       ('8 Xanadu Way', 'Dreamland', 'DR', '22222', NOW(), NOW()),
       ('9 Wonderland Park', 'Fantasia', 'FA', '11111', NOW(), NOW()),
       ('10 Elysium Fields', 'Utopia', 'UT', '00000', NOW(), NOW());
INSERT INTO Badge (badge_name, created_at, updated_at)
VALUES ('bronze', NOW(), NOW()),
       ('silver', NOW(), NOW()),
       ('platinum', NOW(), NOW());

INSERT INTO permission (deleted, created_at, updated_at, name)
VALUES (0, NOW(), NOW(), 'all'),
       (0, NOW(), NOW(), 'canReadVehicle'),
       (0, NOW(), NOW(), 'canUpdateVehicle'),
       (0, NOW(), NOW(), 'canDeleteVehicle'),
       (0, NOW(), NOW(), 'canCreateReservation'),
       (0, NOW(), NOW(), 'canReadReservation'),
       (0, NOW(), NOW(), 'canUpdateReservation'),
       (0, NOW(), NOW(), 'canDeleteReservation'),
       (0, NOW(), NOW(), 'canManageBranch'),
       (0, NOW(), NOW(), 'canManageRentalAgent'),
       (0, NOW(), NOW(), 'canManageCustomer'),
       (0, NOW(), NOW(), 'canManageBilling'),
       (0, NOW(), NOW(), 'canViewReports'),
       (0, NOW(), NOW(), 'canManageRoles'),
       (0, NOW(), NOW(), 'canViewDashboard'),
       (0, NOW(), NOW(), 'canManageReviews');


INSERT INTO role (name, created_at, updated_at)
VALUES ('admin', NOW(), NOW()),
       ('rental_agent', NOW(), NOW()),
       ('customer', NOW(), NOW());


-- For the 'admin' role
INSERT INTO role_permission (role_id, permission_id)
VALUES
    -- Admin Permissions
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'all')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canReadVehicle')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canUpdateVehicle')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canDeleteVehicle')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canCreateReservation')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canReadReservation')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canUpdateReservation')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canDeleteReservation')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canManageBranch')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canManageRentalAgent')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canManageCustomer')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canManageBilling')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canViewReports')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canManageRoles')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canViewDashboard')),
    ((SELECT id FROM role WHERE name = 'admin'), (SELECT id FROM permission WHERE name = 'canManageReviews'));

-- For the 'rental_agent' role
INSERT INTO role_permission (role_id, permission_id)
VALUES
    -- Rental Agent Permissions
    ((SELECT id FROM role WHERE name = 'rental_agent'), (SELECT id FROM permission WHERE name = 'canReadVehicle')),
    ((SELECT id FROM role WHERE name = 'rental_agent'),
     (SELECT id FROM permission WHERE name = 'canCreateReservation')),
    ((SELECT id FROM role WHERE name = 'rental_agent'), (SELECT id FROM permission WHERE name = 'canReadReservation')),
    ((SELECT id FROM role WHERE name = 'rental_agent'),
     (SELECT id FROM permission WHERE name = 'canUpdateReservation')),
    ((SELECT id FROM role WHERE name = 'rental_agent'), (SELECT id FROM permission WHERE name = 'canManageCustomer')),
    ((SELECT id FROM role WHERE name = 'rental_agent'), (SELECT id FROM permission WHERE name = 'canViewDashboard'));

-- For the 'customer' role
INSERT INTO role_permission (role_id, permission_id)
VALUES
    -- Customer Permissions
    ((SELECT id FROM role WHERE name = 'customer'), (SELECT id FROM permission WHERE name = 'canReadVehicle')),
    ((SELECT id FROM role WHERE name = 'customer'), (SELECT id FROM permission WHERE name = 'canCreateReservation')),
    ((SELECT id FROM role WHERE name = 'customer'), (SELECT id FROM permission WHERE name = 'canReadReservation')),
    ((SELECT id FROM role WHERE name = 'customer'), (SELECT id FROM permission WHERE name = 'canUpdateReservation')),
    ((SELECT id FROM role WHERE name = 'customer'), (SELECT id FROM permission WHERE name = 'canDeleteReservation')),
    ((SELECT id FROM role WHERE name = 'customer'), (SELECT id FROM permission WHERE name = 'canViewDashboard'));
-- Insert 5 dummy branches
INSERT INTO branch (branch_name, branch_licence, address_address_id, created_at, updated_at)
VALUES ('Downtown Branch', 'DL-001', 1, NOW(), NOW()),
       ('Northside Branch', 'DL-002', 2, NOW(), NOW()),
       ('Eastside Branch', 'DL-003', 3, NOW(), NOW()),
       ('Westside Branch', 'DL-004', 4, NOW(), NOW()),
       ('Southside Branch', 'DL-005', 5, NOW(), NOW());
-- Insert 10 dummy customers
INSERT INTO user (f_name, l_name, phone_number, address_address_id, email, password, created_at, updated_at, deleted)
VALUES ('John', 'Doe', '1234567890', 1, 'john.doe@example.com',
        '$2a$10$5SqQl/ryv0cliS7RUB1Wy.GIJSLbKoSIaH4Kbhpddh54ARIhUOtde', NOW(), NOW(), false),
       ('Alice', 'Smith', '9876543210', 2, 'alice.smith@example.com',
        '$2a$10$sNEm0ZW6xJT/LoSn5w1PVu9x/Hz9vdfl/y461sH29RAMALuMkZAa2', NOW(), NOW(), false),
       ('Bob', 'Johnson', '5551234567', 3, 'bob.johnson@example.com',
        '$2a$10$NXdYSBv41R8OpDM4USc6Wu9/dKlKtEy/awucEe3mRMG854IfjR0KO', NOW(), NOW(), false),
       ('Emily', 'Davis', '4449998888', 4, 'emily.davis@example.com',
        '$2a$10$sNEm0ZW6xJT/LoSn5w1PVu9x/Hz9vdfl/y461sH29RAMALuMkZAa2', NOW(), NOW(), false),
       ('Michael', 'Brown', '7771112222', 5, 'michael.brown@example.com',
        '$2a$10$NXdYSBv41R8OpDM4USc6Wu9/dKlKtEy/awucEe3mRMG854IfjR0KO', NOW(), NOW(), false),
       ('Sophia', 'Wilson', '3334445555', 6, 'sophia.wilson@example.com',
        '$2a$10$sNEm0ZW6xJT/LoSn5w1PVu9x/Hz9vdfl/y461sH29RAMALuMkZAa2', NOW(), NOW(), false),
       ('David', 'Lee', '6667778888', 7, 'david.lee@example.com',
        '$2a$10$NXdYSBv41R8OpDM4USc6Wu9/dKlKtEy/awucEe3mRMG854IfjR0KO', NOW(), NOW(), false),
       ('Emma', 'Clark', '2223334444', 8, 'emma.clark@example.com',
        '$2a$10$sNEm0ZW6xJT/LoSn5w1PVu9x/Hz9vdfl/y461sH29RAMALuMkZAa2', NOW(), NOW(), false),
       ('Olivia', 'Anderson', '9998887777', 9, 'olivia.anderson@example.com',
        '$2a$10$NXdYSBv41R8OpDM4USc6Wu9/dKlKtEy/awucEe3mRMG854IfjR0KO', NOW(), NOW(), false),
       ('James', 'Moore', '1112223333', 10, 'james.moore@example.com',
        '$2a$10$sNEm0ZW6xJT/LoSn5w1PVu9x/Hz9vdfl/y461sH29RAMALuMkZAa2', NOW(), NOW(), false);

-- Insert 10 customers with additional details
INSERT INTO customer (id, dob, driver_licence_id, badge_id)
VALUES (1, '1990-05-15', 'DL123456', 1),
       (2, '1985-10-20', 'DL987654', 2),
       (3, '1995-03-25', 'DL555555', 3),
       (4, '1988-12-08', 'DL444444', 1),
       (5, '1992-07-31', 'DL777777', 2),
       (6, '1987-02-14', 'DL333333', 3),
       (7, '1993-09-18', 'DL666666', 1),
       (8, '1996-04-22', 'DL222222', 1),
       (9, '1994-11-11', 'DL999999', 1),
       (10, '1989-06-05', 'DL111111', 1);
-- Insert 10 dummy rental agents
INSERT INTO user (f_name, l_name, phone_number, address_address_id, email, password, created_at, updated_at, deleted)
VALUES ('Ryan', 'Taylor', '1234567890', 1, 'ryan.taylor@example.com', 'agentpass', NOW(), NOW(), false),
       ('Ella', 'Martinez', '9876543210', 2, 'ella.martinez@example.com', 'agent123', NOW(), NOW(), false),
       ('Jacob', 'Garcia', '5551234567', 3, 'jacob.garcia@example.com', 'agentpwd', NOW(), NOW(), false),
       ('Ava', 'Robinson', '4449998888', 4, 'ava.robinson@example.com', 'agentpass123', NOW(), NOW(), false),
       ('William', 'Harris', '7771112222', 5, 'william.harris@example.com', 'agent1234', NOW(), NOW(), false),
       ('Mia', 'King', '3334445555', 6, 'mia.king@example.com', 'agent567', NOW(), NOW(), false),
       ('Ethan', 'Wright', '6667778888', 7, 'ethan.wright@example.com', 'wrightpwd', NOW(), NOW(), false),
       ('Isabella', 'Lopez', '2223334444', 8, 'isabella.lopez@example.com', 'isabellapwd', NOW(), NOW(), false),
       ('Alexander', 'Young', '9998887777', 9, 'alexander.young@example.com', 'youngagent', NOW(), NOW(), false),
       ('Chloe', 'Allen', '1112223333', 10, 'chloe.allen@example.com', 'allen123', NOW(), NOW(), false);

-- Insert 10 rental agents with additional details
INSERT INTO rental_agent (id, branch_id)
VALUES (11, 1),
       (12, 2),
       (13, 3),
       (14, 1),
       (15, 2),
       (16, 3),
       (17, 1),
       (18, 2),
       (19, 3),
       (20, 1);
-- Insert 10 dummy vehicles
INSERT INTO vehicle (make, model, picture, vehicle_type, seat_num, created_at, updated_at)
VALUES ('Toyota', 'Camry', 'toyota_camry.jpg', 'SEDAN', 5, NOW(), NOW()),
       ('Honda', 'Civic', 'honda_civic.jpg', 'SEDAN', 5, NOW(), NOW()),
       ('Ford', 'F-150', 'ford_f150.jpg', 'MINIVAN', 3, NOW(), NOW()),
       ('Chevrolet', 'Silverado', 'chevrolet_silverado.jpg', 'MINIVAN', 3, NOW(), NOW()),
       ('Jeep', 'Wrangler', 'jeep_wrangler.jpg', 'SUV', 4, NOW(), NOW()),
       ('Subaru', 'Outback', 'subaru_outback.jpg', 'SUV', 5, NOW(), NOW()),
       ('BMW', 'X5', 'bmw_x5.jpg', 'SUV', 5, NOW(), NOW()),
       ('Audi', 'A4', 'audi_a4.jpg', 'SEDAN', 5, NOW(), NOW()),
       ('Mercedes-Benz', 'GLE', 'mercedes_gle.jpg', 'SUV', 5, NOW(), NOW()),
       ('Tesla', 'Model 3', 'tesla_model3.jpg', 'SEDAN', 5, NOW(), NOW());

INSERT INTO service (service_type, description, price, created_at, updated_at)
VALUES ('VIP Reservation', 'Exclusive VIP reservation service', 200.0, NOW(), NOW()),
       ('Regular Reservation', 'Standard reservation service', 100.0, NOW(), NOW()),
       ('Economy Reservation', 'Economical reservation option', 50.0, NOW(), NOW());
INSERT INTO car (year, license_plate, rental_rate, availability_status, start_price, registration_id,
                 insurance_exp_date, car_type_of_vehicle_id, branch_id)
VALUES (2019, 'ABC123', 80.0, 'AVAILABLE', 400.0, 'REG123', NOW() + INTERVAL 1 YEAR, 1, 1),
       (2020, 'XYZ456', 90.0, 'AVAILABLE', 450.0, 'REG456', NOW() + INTERVAL 1 YEAR, 2, 2),
       (2018, 'DEF789', 70.0, 'RENTED', 300.0, 'REG789', NOW() + INTERVAL 6 MONTH, 1, 3),
       (2017, 'GHI123', 60.0, 'AVAILABLE', 350.0, 'REG345', NOW() + INTERVAL 1 YEAR, 3, 4),
       (2019, 'JKL678', 85.0, 'AVAILABLE', 420.0, 'REG678', NOW() + INTERVAL 1 YEAR, 2, 5),
       (2021, 'MNO910', 95.0, 'AVAILABLE', 480.0, 'REG910', NOW() + INTERVAL 1 YEAR, 1, 1),
       (2016, 'PQR111', 65.0, 'RENTED', 250.0, 'REG111', NOW() + INTERVAL 6 MONTH, 1, 2),
       (2018, 'STU222', 75.0, 'AVAILABLE', 420.0, 'REG222', NOW() + INTERVAL 1 YEAR, 3, 3),
       (2020, 'VWX333', 88.0, 'AVAILABLE', 440.0, 'REG333', NOW() + INTERVAL 1 YEAR, 2, 4),
       (2019, 'YZA444', 82.0, 'AVAILABLE', 410.0, 'REG444', NOW() + INTERVAL 1 YEAR, 1, 5),
       (2017, 'BCD555', 68.0, 'RENTED', 280.0, 'REG555', NOW() + INTERVAL 6 MONTH, 2, 1),
       (2018, 'EFG666', 72.0, 'AVAILABLE', 320.0, 'REG666', NOW() + INTERVAL 1 YEAR, 3, 2),
       (2021, 'HIJ777', 97.0, 'AVAILABLE', 490.0, 'REG777', NOW() + INTERVAL 1 YEAR, 2, 3),
       (2016, 'KLM888', 63.0, 'RENTED', 230.0, 'REG888', NOW() + INTERVAL 6 MONTH, 1, 4),
       (2019, 'NOP999', 84.0, 'AVAILABLE', 430.0, 'REG999', NOW() + INTERVAL 1 YEAR, 1, 5),
       (2018, 'QRS000', 73.0, 'AVAILABLE', 350.0, 'REG000', NOW() + INTERVAL 1 YEAR, 3, 1),
       (2020, 'TUV111', 89.0, 'AVAILABLE', 460.0, 'REG111', NOW() + INTERVAL 1 YEAR, 2, 2),
       (2017, 'WXY222', 67.0, 'RENTED', 290.0, 'REG222', NOW() + INTERVAL 6 MONTH, 1, 3),
       (2018, 'ZAB333', 74.0, 'AVAILABLE', 360.0, 'REG333', NOW() + INTERVAL 1 YEAR, 3, 4),
       (2019, 'CDE444', 81.0, 'AVAILABLE', 400.0, 'REG444', NOW() + INTERVAL 1 YEAR, 2, 5),
       (2017, 'FGH555', 66.0, 'RENTED', 280.0, 'REG555', NOW() + INTERVAL 6 MONTH, 1, 1),
       (2018, 'IJK666', 71.0, 'AVAILABLE', 320.0, 'REG666', NOW() + INTERVAL 1 YEAR, 3, 2),
       (2020, 'LMN777', 92.0, 'AVAILABLE', 480.0, 'REG777', NOW() + INTERVAL 1 YEAR, 2, 3),
       (2016, 'OPQ888', 62.0, 'RENTED', 230.0, 'REG888', NOW() + INTERVAL 6 MONTH, 1, 4),
       (2019, 'RST999', 83.0, 'AVAILABLE', 420.0, 'REG999', NOW() + INTERVAL 1 YEAR, 1, 5),
       (2018, 'UVW000', 76.0, 'AVAILABLE', 350.0, 'REG000', NOW() + INTERVAL 1 YEAR, 3, 1),
       (2020, 'XYZ111', 90.0, 'AVAILABLE', 460.0, 'REG111', NOW() + INTERVAL 1 YEAR, 2, 2),
       (2017, 'ABC222', 65.0, 'RENTED', 290.0, 'REG222', NOW() + INTERVAL 6 MONTH, 1, 3),
       (2018, 'DEF333', 78.0, 'AVAILABLE', 360.0, 'REG333', NOW() + INTERVAL 1 YEAR, 3, 4),
       (2019, 'GHI444', 80.0, 'AVAILABLE', 400.0, 'REG444', NOW() + INTERVAL 1 YEAR, 2, 5);
-- Insert 10 dummy card details for customers
INSERT INTO card (card_type, card_number, cvv, expiration_date, customer_id, created_at, updated_at)
VALUES ('Visa', '1111222233334444', 123, '2024-04-01', 1, NOW(), NOW()),
       ('Mastercard', '5555666677778888', 456, '2023-12-01', 2, NOW(), NOW()),
       ('American Express', '9999000011112222', 789, '2023-10-01', 3, NOW(), NOW()),
       ('Discover', '1234123412341234', 321, '2024-06-01', 4, NOW(), NOW()),
       ('Visa', '9876987698769876', 654, '2023-09-01', 5, NOW(), NOW()),
       ('Mastercard', '4567456745674567', 987, '2024-01-01', 6, NOW(), NOW()),
       ('American Express', '7890789078907890', 654, '2023-11-01', 7, NOW(), NOW()),
       ('Discover', '3210321032103210', 321, '2024-05-01', 8, NOW(), NOW()),
       ('Visa', '1111000011110000', 123, '2023-08-01', 9, NOW(), NOW()),
       ('Mastercard', '5555444433332222', 456, '2024-02-01', 10, NOW(), NOW()),
       ('American Express', '9999888877776666', 789, '2024-04-01', 1, NOW(), NOW()),
       ('Discover', '1234323456541234', 321, '2023-12-01', 2, NOW(), NOW()),
       ('Visa', '9876123456789876', 654, '2024-03-01', 3, NOW(), NOW()),
       ('Mastercard', '4567567878654567', 987, '2023-10-01', 4, NOW(), NOW()),
       ('American Express', '7890123456789012', 654, '2024-01-01', 5, NOW(), NOW());
-- Insert 60 reservations
INSERT INTO reservation (price, date_time_start, date_time_end, reservation_status, pickup_location_id,
                         drop_off_location_id, car_id, service_id, customer_id, created_at, updated_at)
SELECT ROUND(RAND() * 500 + 50, 2)                 as price,
       NOW() + INTERVAL FLOOR(RAND() * 30) DAY     as dateTimeStart,
       NOW() + INTERVAL FLOOR(RAND() * 30 + 1) DAY as dateTimeEnd,
       CASE
           WHEN RAND() < 0.33 THEN 'CONFIRMED'
           WHEN RAND() >= 0.33 AND RAND() < 0.66 THEN 'CANCELLED'
           ELSE 'PENDING'
           END                                     as reservationStatus,
       FLOOR(RAND() * 5) + 1                       as pickupLocation_id,
       FLOOR(RAND() * 5) + 1                       as dropOffLocation_id,
       FLOOR(RAND() * 30) + 1                      as car_id,
       CASE WHEN RAND() < 0.5 THEN 1 ELSE 2 END    as service_id,
       FLOOR(RAND() * 10) + 1                      as customer_id,
       NOW()                                       as created_at,
       NOW()                                       as updated_at
FROM information_schema.tables
LIMIT 60;
-- Insert an Agreement for each reservation
INSERT INTO agreement (description, policy, customer_id, rental_agent_id, reservation_id, created_at, updated_at)
SELECT CONCAT('Agreement for Reservation ', r.reservationID) AS description,
       'Standard policy'                                     AS policy,
       r.customer_id                                         AS customer_id,
       ra.id                                                 AS rentalAgent_id,
       r.reservationID                                       AS reservation_id,
       NOW()                                                 AS created_at,
       NOW()                                                 AS updated_at
FROM reservation r
         JOIN rental_agent ra ON ra.id = FLOOR(RAND() * 10) + 1 -- Replace '1' with the appropriate rental agent ID
WHERE r.reservation_status = 'CONFIRMED';
-- Insert 60 dummy bill for each confirmed reservation

INSERT INTO bill (amount, description, customer_id, reservation_id, created_at, updated_at)
SELECT ROUND(RAND() * 500 + 50, 2)                      AS amount,
       CONCAT('Bill for Reservation ', r.reservationID) AS description,
       r.customer_id                                    AS customer_id,
       r.reservationID                                  AS reservation_id,
       NOW()                                            AS created_at,
       NOW()                                            AS updated_at
FROM reservation r
WHERE r.reservation_status = 'CONFIRMED';
-- insert 60 dummy feedbacks for each confirmed reservation
INSERT INTO feedback (local_date_time, comment, customer_id, reservation_id, created_at, updated_at)
SELECT NOW()                                                AS local_date_time,
       CONCAT('Feedback for Reservation ', r.reservationID) AS comment,
       r.customer_id                                        AS customer_id,
       r.reservationID                                      AS reservation_id,
       NOW()                                                AS created_at,
       NOW()                                                AS updated_at
FROM reservation r
WHERE r.reservation_status = 'CONFIRMED';

INSERT INTO user_roles (user_id, roles_id)
VALUES (1, 1), -- Assuming 1 is the ID of the first role you want to assign
       (1, 2), -- Assuming 2 is the ID of the second role
       (1, 3); -- Assuming 3 is the ID of the third role
