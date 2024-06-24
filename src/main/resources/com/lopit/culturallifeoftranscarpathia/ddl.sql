-- Створення таблиці "users" для зберігання даних користувачів
CREATE TABLE users (
    id_user INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);

-- Створення таблиці "events" для зберігання інформації про події
CREATE TABLE events (
    id_event INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    description TEXT,
    date TIMESTAMP NOT NULL,
    location TEXT NOT NULL,
    organizer_id INTEGER,
    FOREIGN KEY (organizer_id) REFERENCES users (id_user)
);

-- Створення таблиці "venues" для зберігання інформації про місця проведення подій
CREATE TABLE venues (
    id_venue INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    address TEXT NOT NULL
);

-- Створення таблиці "event_venues" для зберігання зв'язків між подіями та місцями проведення (зв'язок багато до багатьох)
CREATE TABLE event_venues (
    event_id INTEGER,
    venue_id INTEGER,
    PRIMARY KEY (event_id, venue_id),
    FOREIGN KEY (event_id) REFERENCES events (id_event),
    FOREIGN KEY (venue_id) REFERENCES venues (id_venue)
);

-- Створення таблиці "categories" для категорій подій
CREATE TABLE categories (
    id_category INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL
);

-- Створення таблиці "event_categories" для зв'язків між подіями та категоріями (зв'язок багато до багатьох)
CREATE TABLE event_categories (
    event_id INTEGER,
    category_id INTEGER,
    PRIMARY KEY (event_id, category_id),
    FOREIGN KEY (event_id) REFERENCES events (id_event),
    FOREIGN KEY (category_id) REFERENCES categories (id_category)
);
