DROP TABLE IF EXISTS TOOLS;
DROP TABLE IF EXISTS TOOL_TYPES;
DROP TABLE IF EXISTS HOLIDAYS;

CREATE TABLE TOOL (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tool_code VARCHAR(4) NOT NULL,
    tool_type VARCHAR(30) NOT NULL,
    brand VARCHAR(20) NOT NULL
);

CREATE TABLE TOOL_TYPES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(30) NOT NULL,
    daily_charge DOUBLE NOT NULL,
    weekday_charge CHAR NOT NULL,
    weekend_charge CHAR NOT NULL,
    holiday_charge CHAR NOT NULL
);

CREATE TABLE HOLIDAYS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL
);