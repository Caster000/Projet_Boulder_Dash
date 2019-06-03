-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 02 juin 2019 à 15:29
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jpublankproject`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `mapById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `mapById` (IN `p_id` INT)  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM map WHERE id = p_id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `map`
--

DROP TABLE IF EXISTS `map`;
CREATE TABLE IF NOT EXISTS `map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `mapChar` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `map`
--

INSERT INTO `map` (`id`, `width`, `height`, `mapChar`) VALUES
(1, 15, 15, '000000000000000\r\n010100110010010\r\n010101001010010\r\n010101001010010\r\n001001001010010\r\n001000110001100\r\n000000000000000\r\n000000000000000\r\n011100010011110\r\n010010010010000\r\n010010010011100\r\n010010010010000\r\n011100010011110\r\n000000000000000\r\n000000000000000'),
(2, 16, 16, '1111111111111111\r\n1333333333333331\r\n1363332333333331\r\n1333333333333331\r\n1333333333443331\r\n1332333333333331\r\n1324433334333331\r\n1333333333333331\r\n1334333332223331\r\n1333333333333331\r\n1333323343334331\r\n1334343333333331\r\n1333333333333331\r\n1333334333323331\r\n1343333333333731\r\n1111111111111111\r\n1111111111111111'),
(3, 16, 16, '1111111111111111\r\n1433333333334331\r\n1363332333333331\r\n1333330000003331\r\n1334330000503331\r\n1332330000003331\r\n1333333334333331\r\n1212121200212121\r\n1334333333333331\r\n1333000033233331\r\n1333000022334331\r\n1335000043333331\r\n1333333333333331\r\n1333333343333331\r\n1337333333343331\r\n1111111111111111'),
(4, 16, 16, '1111111111111111\r\n1333333333333331\r\n1363332333343331\r\n1333333333333331\r\n1333333333503331\r\n1332333333003331\r\n1334333334333331\r\n1333111111133331\r\n1334333333333331\r\n1333333233233331\r\n1333333322334331\r\n1335000033333331\r\n1333333333333331\r\n1333334333333331\r\n1333333333333731\r\n1111111111111111\r\n'),
(5, 16, 16, '1111111111111111\r\n1733333223334331\r\n1363333333333331\r\n1333000000003331\r\n1334005000503331\r\n1333000000003331\r\n1333333333333331\r\n1443323333333441\r\n1333333433333331\r\n1333000033233331\r\n1333050022334331\r\n1333000043333331\r\n1333233333333331\r\n1334222333433331\r\n1333333333343331\r\n1111111111111111'),
(6, 16, 16, '1111111111111111\r\n1323232323334331\r\n1603333333333331\r\n1333232323233331\r\n1332424242423331\r\n1333333333333331\r\n1333333333333331\r\n1333323333333441\r\n1333343433333331\r\n1333333333233331\r\n1333050000034331\r\n1333000033333331\r\n1343000333334331\r\n1433003333433331\r\n1333733333343331\r\n1111111111111111'),
(7, 15, 15, '000000000000000\r\n010100110010010\r\n010101001010010\r\n010101001010010\r\n001001001010010\r\n001000110001100\r\n000000000000000\r\n000000000000000\r\n100010010010001\r\n100010010011001\r\n101010010010101\r\n101010010010011\r\n010100010010001\r\n000000000000000\r\n000000000000000');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;