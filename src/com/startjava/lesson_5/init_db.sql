\echo 'Подключение к БД robots'
\c robots;

\echo 'Удаление таблицы jaegers если она уже существует'
DROP TABLE IF EXISTS jaegers;

\echo 'Создание таблицы jaegers'
CREATE TABLE jaegers (
    id         SERIAL PRIMARY KEY,
    model_name TEXT,
    mark       INT,
    height     DECIMAL(4, 2),
    weight     NUMERIC,
    status     VARCHAR(10),
    origin     TEXT,
    launch     DATE,
    kaiju_kill INT
);

\echo 'Запускаем файл populate.sql'
\ir populate.sql;

\echo 'Запускаем файл queries.sql'
\ir queries.sql;