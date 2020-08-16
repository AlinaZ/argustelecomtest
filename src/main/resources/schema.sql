CREATE TABLE IF NOT EXISTS Point
(
    point_id    INTEGER COMMENT 'Уникальный идентификатор точки в сети' PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    point_cu_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор точки в пределах коннектора',
    cu_id       INTEGER NOT NULL COMMENT 'Уникальный идентификатор коннектора'
);

CREATE TABLE IF NOT EXISTS Connector
(
    cu_id    INTEGER COMMENT 'Уникальный идентификатор коннектора' PRIMARY KEY AUTO_INCREMENT,
    version  INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    name     VARCHAR(25) NOT NULL COMMENT 'Имя коннектора',
    capacity INTEGER NOT NULL COMMENT 'Емкость коннектора',
    node_id  INTEGER NOT NULL COMMENT 'Уникальный идентификатор узла, в котором находится коннектор'
);

CREATE TABLE IF NOT EXISTS Node
(
    node_id INTEGER COMMENT 'Уникальный идеентификатор узла' PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    name    VARCHAR(25) NOT NULL COMMENT 'Имя узла',
    region  VARCHAR(25) NOT NULL COMMENT 'Регион',
    street  VARCHAR(25) NOT NULL COMMENT 'Улица',
    house   VARCHAR(25) NOT NULL COMMENT 'Дом'
);

CREATE TABLE IF NOT EXISTS Link
(
    link_id   INTEGER COMMENT 'Уникальный идентификатор связи в сети' PRIMARY KEY AUTO_INCREMENT,
    version   INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    point1_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор первой точки',
    point2_id INTEGER NOT NULL COMMENT 'Уникальный идентификатор второй точки'
);

ALTER TABLE Point
    ADD FOREIGN KEY (cu_id) REFERENCES Connector (cu_id);
ALTER TABLE Connector
    ADD FOREIGN KEY (node_id) REFERENCES Node (node_id);
ALTER TABLE Link
    ADD FOREIGN KEY (point1_id) REFERENCES Point (point_id);
ALTER TABLE Link
    ADD FOREIGN KEY (point2_id) REFERENCES Point (point_id);


	
