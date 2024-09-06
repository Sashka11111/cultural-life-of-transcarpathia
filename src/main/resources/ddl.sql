DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Events;
DROP TABLE IF EXISTS Venues;
DROP TABLE IF EXISTS Event_Venues;
DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Event_Categories;

-- Створення таблиці "Users" для зберігання даних користувачів
CREATE TABLE Users (
    id_user       INTEGER PRIMARY KEY AUTOINCREMENT,
    username      VARCHAR (50)    NOT NULL UNIQUE,
    password      VARCHAR (20)    NOT NULL,
    role VARCHAR(20) DEFAULT 'USER' NOT NULL CHECK(role IN ('USER', 'ADMIN', 'SPONSOR')) -- Роль користувача: 'USER', 'ADMIN' або 'SPONSOR', за замовчуванням 'user'
);

-- Створення таблиці "Events" для зберігання інформації про події
CREATE TABLE Events (
    id_event INTEGER PRIMARY KEY AUTOINCREMENT,
    title VARCHAR (100) NOT NULL,
    description VARCHAR (200),
    date TIMESTAMP NOT NULL,
    location VARCHAR (100) NOT NULL,
    organizer_id INTEGER,
    FOREIGN KEY (organizer_id) REFERENCES Users (id_user)
);

-- Створення таблиці "Venues" для зберігання інформації про місця проведення подій
CREATE TABLE Venues (
    id_venue INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR (100) NOT NULL,
    address VARCHAR (100) NOT NULL
);

-- Створення таблиці "Event_Venues" для зв'язку багато до багатьох
CREATE TABLE Event_Venues (
    event_id INTEGER,
    venue_id INTEGER,
    PRIMARY KEY (event_id, venue_id),
    FOREIGN KEY (event_id) REFERENCES Events (id_event),
    FOREIGN KEY (venue_id) REFERENCES Venues (id_venue)
);

-- Створення таблиці "Categories" для категорій подій
CREATE TABLE Categories (
    category_id INTEGER PRIMARY KEY AUTOINCREMENT,
    category_name VARCHAR(50) NOT NULL  -- Назва категорії
);

-- Створення таблиці "Event_Categories" для зв'язку багато до багатьох
CREATE TABLE Event_Categories (
    event_id INTEGER,
    category_id INTEGER,
    PRIMARY KEY (event_id, category_id),
    FOREIGN KEY (event_id) REFERENCES Events (id_event),
    FOREIGN KEY (category_id) REFERENCES Categories (id_category)
);