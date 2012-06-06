-- phpMyAdmin SQL Dump
-- version 4.0.0-dev
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 01. Jun 2012 um 20:46
-- Server Version: 5.0.96-log
-- PHP-Version: 5.2.14-pl0-gentoo

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `siprojekt`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Smartphones`
--
drop table `Smartphones`;

CREATE TABLE `Smartphones` (
  `Smartphone_id` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Marke` varchar(50) NOT NULL,
  `Preis` decimal(5,2) NOT NULL,
  `Gewicht` decimal(5,2) NOT NULL,
  `Farbe` varchar(50) NOT NULL,
  `Material` varchar(50) NOT NULL,
  `Akkulaufzeit` decimal(5,2) NOT NULL,
  `Displaygroesse` decimal(5,2) NOT NULL,
  `Aufloesung` varchar(50) NOT NULL,
  `Displayart` varchar(50) NOT NULL,
  `Bedienungsart` varchar(50) NOT NULL,
  `Bedienoberflaeche` varchar(50) NOT NULL,
  `Interner Speicher` decimal(10,0) NOT NULL,
  `Os` varchar(50) NOT NULL,
  `AppStore` varchar(50) NOT NULL,
  `Kamera` varchar(50) NOT NULL,
  `Kameraaufloesung` decimal(5,2) NOT NULL,
  `Netzwerktyp` varchar(50) NOT NULL,
  `WLAN` tinyint(1) NOT NULL,
  `Bluetooth` tinyint(1) NOT NULL,
  `MSExchange` tinyint(1) NOT NULL,
  `Beamer` tinyint(1) NOT NULL,
  `Handycap` tinyint(1) NOT NULL,
  `Outdoor` tinyint(1) NOT NULL,
  `Hardwaretastatur` tinyint(1) NOT NULL,
  `MHz` int(11) NOT NULL,
  `cores` int(11) NOT NULL,
  `GPS` tinyint(1) NOT NULL,
  PRIMARY KEY  (`Smartphone_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `Smartphones`
--

INSERT INTO `Smartphones` (`Smartphone_id`, `Name`, `Marke`, `Preis`, `Gewicht`, `Farbe`, `Material`, `Akkulaufzeit`, `Displaygroesse`, `Aufloesung`, `Displayart`, `Bedienungsart`, `Bedienoberflaeche`, `Interner Speicher`, `Os`, `AppStore`, `Kamera`, `Kameraaufloesung`, `Netzwerktyp`, `WLAN`, `Bluetooth`, `MSExchange`, `Beamer`, `Handycap`, `Outdoor`, `Hardwaretastatur`, `MHz`, `cores`, `GPS`) VALUES
(0, 'Galaxy Nexus Prime', 'Samsung', '530.00', '130.00', 'Schwarz', 'Kunststoff', '12.00', '4.00', '1280 x 720', 'AMOLED HD', 'Finger', 'Glas', '16000', 'Android 4.0.1', '1', 'Noname', '5.00', 'HSDPA', 1, 1, 1, 0, 0, 1, 0, 1000, 2, 1),
(2, 'Galaxy Ace', 'Samsung', '190.00', '113.00', 'Schwarz', 'Metall', '25.00', '3.00', '320 x 480', 'HVGA', 'Finger', 'Glas', '150', 'Android 2.2', '1', 'Noname', '5.00', 'HSDPA', 1, 1, 0, 0, 0, 1, 1, 800, 1, 1),
(3, 'IPhone 4 16GB', 'Apple', '450.00', '137.00', 'Schwarz', 'Metall', '36.00', '3.00', '640 x 960', 'Color IPS TFT', 'Finger', 'Glas', '16000', 'IOS4', '1', 'Noname', '5.00', 'HSDPA', 1, 1, 1, 1, 1, 1, 1, 999, 1, 1),
(4, 'Galaxy Note', 'Samsung', '350.00', '400.00', 'Schwarz', 'Metall', '40.00', '4.00', '640 x 960', 'Gorilla Glass', 'Finger', 'Glas', '512', 'Android 4.2', '1', 'Noname', '5.00', 'HSDPA', 0, 0, 0, 1, 0, 1, 0, 600, 1, 1),
(5, 'Nokia', 'Nokia', '99.00', '100.00', 'Rot', 'Metall', '26.00', '3.00', '340 x 960', 'Gorilla Glas', 'Finger', 'Glas', '4000', 'Android 2.2', '0', 'Noname', '5.00', 'HSDPA', 0, 0, 1, 0, 1, 1, 0, 500, 1, 0),
(6, 'Saturn', 'Samsung', '450.00', '400.00', 'Schwarz', 'Plastik', '27.00', '6.00', '1140 x 160', 'Gorilla Glas', 'Finger', 'Glas', '5000', 'Android 1.2', '1', 'Noname', '5.00', 'HSDPA', 0, 1, 0, 0, 1, 0, 1, 666, 1, 1),
(7, 'Yum Yum', 'HTC', '350.00', '300.00', 'Grün', 'Metall', '22.00', '5.00', '1240 x 960', 'Gorilla Glas', 'Finger', 'Glas', '6000', 'Android 3.2', '0', 'Noname', '5.00', 'HSDPA', 1, 0, 0, 0, 1, 1, 0, 666, 1, 0),
(8, 'Error', 'Microsoft', '210.00', '330.00', 'Schwarz', 'Metall', '25.00', '3.00', '1440 960', 'Gorilla Glas', 'Finger', 'Glas', '7000', 'Android 3.3', '1', 'Noname', '5.00', 'HSDPA', 1, 0, 1, 1, 0, 1, 0, 800, 2, 1),
(9, 'Bananaphone', 'Toshiba', '220.00', '270.00', 'Gelb', 'Metall', '25.00', '4.00', '1340 x 960', 'Gorilla Glas', 'Finger', 'Glas', '8000', 'Android 4.2', '0', 'Noname', '5.00', 'HSDPA', 1, 1, 0, 1, 0, 1, 1, 700, 1, 1),
(10, 'Ultraphone', 'Acer', '350.00', '290.00', 'Schwarz', 'Plastik', '21.00', '4.00', '1240 x 1060', '', 'Finger', 'Glas', '9000', 'Android 1.6', '1', 'Noname', '5.00', 'HSDPA', 0, 0, 0, 1, 0, 1, 0, 500, 2, 1),
(11, 'RACER', 'NVDIA', '150.00', '310.00', 'Blau', 'Metall', '20.00', '3.00', '840 x 960', 'Gorilla Glas', 'Finger', 'Glas', '10000', 'Android 2.1', '0', 'Noname', '5.00', 'HSDPA', 1, 1, 1, 0, 0, 1, 0, 1200, 1, 1),
(12, 'TVX Wunderphone', 'TVX', '350.00', '150.00', 'Schwarz', 'Metall', '30.00', '4.00', '1640 x 1960', 'Gorilla Glass', 'Finger', 'Glas', '1512', 'Android 5.2', '1', 'Noname', '5.00', 'HSDPA', 1, 1, 1, 1, 1, 1, 0, 1000, 1, 1),
(13, 'TVX Phone', 'TVX', '250.00', '200.00', 'Schwarz', 'Metall', '32.00', '6.00', '640 x 960', 'Plastik', 'Finger', 'Glas', '522', 'Android 4.2', '1', 'Noname', '5.00', 'HSDPA', 1, 1, 0, 0, 1, 1, 0, 1000, 2, 1),
(14, 'TVX HDX', 'TVX', '250.00', '200.00', 'Schwarz', 'Metall', '30.00', '1.00', '640 x 860', 'Kunststoff', 'Finger', 'Glas', '112', 'Android 4.2', '1', 'Noname', '5.00', 'HSDPA', 1, 0, 1, 1, 0, 1, 0, 1000, 1, 1),
(15, 'TVX YOUPhone', 'TVX', '250.00', '200.00', 'Dunkelbunt', 'Metall', '26.00', '3.00', '740 x 960', 'Glas', 'Finger', 'Glas', '5112', 'Android 4.2', '1', 'Noname', '5.00', 'HSDPA', 1, 1, 1, 1, 0, 1, 1, 900, 2, 1),
(16, 'TVX Longphone', 'TVX', '250.00', '200.00', 'Schwarz', 'Metall', '29.00', '3.00', '640 x 260', 'Gorilla Glass', 'Finger', 'Glas', '12580', 'Android 4.2', '1', 'Noname', '5.00', 'HSDPA', 1, 1, 1, 0, 0, 1, 1, 999, 1, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
