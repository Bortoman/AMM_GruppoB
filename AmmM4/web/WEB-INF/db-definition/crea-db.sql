/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  root
 * Created: 23-mag-2016
 */
CREATE TABLE cliente
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(128),
    cognome VARCHAR(128),
    username VARCHAR(128),
    password VARCHAR(32),
    saldo REAL
);

CREATE TABLE venditore
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(128),
    cognome VARCHAR(128),
    username VARCHAR(128),
    password VARCHAR(32),
    saldo REAL
);

CREATE TABLE oggetto_in_vendita
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(128),
    imageURL VARCHAR(128),
    descrizione VARCHAR(256),
    prezzo REAL,
    quantita INTEGER,
    idVenditore INTEGER,
    FOREIGN KEY (idVenditore) REFERENCES venditore(id)
);

INSERT INTO cliente(id, nome, cognome, username, password, saldo)
VALUES (default, 'Davide', 'Spano', 'SpanoDavide', '0', 9999),
(default, 'Riccardo', 'Scateni', 'ScateniRiccardo', '1',99999.9),
(default, 'Gianni', 'Fenu', 'DjannyFenu', '2', 9999.9);

INSERT INTO venditore(id, nome, cognome, username, password, saldo)
VALUES (default, 'Mario', 'Rossi', 'mariorossi', '0', 999999.9),
(default, 'Riccardo', 'Scateni', 'username', '1',99999.9),
(default, 'Giulio', 'Liguori', 'giu', 'Briscola', 1.0);

INSERT INTO oggetto_in_vendita(id, nome, imageURL, descrizione, prezzo, quantita, idVenditore)
VALUES (default, 'Gibson EDS-DoubleneckCustom', 'images/EDSDoubleneck.jpg', 'Gibson EDS-Doubleneck Custom, l''originale due-in-uno della Gibson ricreata da Gibson Custom curata in ogni suo dettaglio, in versione Heritage Cherry.', 6499, 9, 1),
(default, 'Gibson Flying V Custom', 'images/GibsonFlyingV.jpg', 'Gibson Flying V Custom, rivisitazione futuristica della versione anni 50, in versione Black Beauty Custom.', 5399, 6, 1),
(default, 'Gibson Les Paul', 'images/GibsonLesPaul.jpg', 'La Les Paul Standard 1959 50° Anniversario rifinita con Heritage Cherry Sunburst', 8504, 3, 2),
(default, 'Marshall JVM205H', 'images/MARSHJVM205H.jpg', 'Il British-built, completamente valvolare 50 Watt JVM205H, 2 canali.', 1499, 5, 3),
(default, 'Marshall 1960A', 'images/M1960A.jpg', 'Il British-built, svasato, 4x12\" speakers per un totale di 300W, 2 canali.', 899, 4, 2),
(default, 'Marshall JH-1 JACKHAMMER', 'images/M1960A.jpg', 'Pedale Marshall, distorsione energica, ma sound naturale e realistico.', 79.90, 7, 3);