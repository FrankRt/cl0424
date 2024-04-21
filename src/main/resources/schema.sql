DROP TABLE IF EXISTS TOOL;
DROP TABLE IF EXISTS TOOL_TYPE;
DROP TABLE IF EXISTS HOLIDAY;

CREATE TABLE HOLIDAY (
    id INT AUTO_INCREMENT PRIMARY KEY,
    yr INT NOT NULL,
    date DATE NOT NULL
);

CREATE TABLE TOOL_TYPE (
    tool_type_id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(30) NOT NULL,
    daily_charge DOUBLE NOT NULL,
    weekday_charge BOOLEAN NOT NULL,
    weekend_charge BOOLEAN NOT NULL,
    holiday_charge BOOLEAN NOT NULL
);

CREATE TABLE TOOL (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tool_code VARCHAR(4) NOT NULL UNIQUE,
    tool_type_id INT,
    brand VARCHAR(20) NOT NULL,

    CONSTRAINT FK_TOOL_TYPE_ID
      FOREIGN KEY (tool_type_id)
      REFERENCES TOOL_TYPE(tool_type_id)
);