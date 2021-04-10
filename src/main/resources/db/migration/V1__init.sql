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
    is_on_map       BOOLEAN
);