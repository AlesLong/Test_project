CREATE TABLE drivers
(
    id              INTEGER PRIMARY KEY,
    first_name      VARCHAR,
    last_name       VARCHAR,
    age             INTEGER,
    address         VARCHAR,
    status          VARCHAR,
    start_work_time TIME,
    end_work_time   TIME,
    longitude       FLOAT,
    latitude        FLOAT
);

INSERT INTO drivers
VALUES (1,
        'yevheniy',
        'bespalov',
        28,
        'haatzmaut 64',
        'UNAVAILABLE',
        '8:00:00',
        '17:00:00',
        100.10,
        100.10);

INSERT INTO drivers
VALUES (2,
        'Andrew',
        'Rogovets',
        28,
        'Lomonosova 55',
        'DELIVERING',
        '8:00:00',
        '17:00:00',
        50.10,
        50.10);

INSERT INTO drivers
VALUES (3,
        'roman',
        'pechera',
        29,
        'kordovka 6',
        'AVAILABLE',
        '8:00:00',
        '17:00:00',
        45.10,
        45.10);
