-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  ven. 31 jan. 2020 à 11:11
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `qcmdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `answer`
--

DROP TABLE IF EXISTS `answer`;
CREATE TABLE IF NOT EXISTS `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(200) NOT NULL,
  `expectedAnswer` tinyint(1) NOT NULL,
  `commentPostAnswer` varchar(200) NOT NULL,
  `idQuestion` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `answer`
--

INSERT INTO `answer` (`id`, `body`, `expectedAnswer`, `commentPostAnswer`, `idQuestion`) VALUES
(1, 'premiere reponse de la base', 1, 'et bien oui, .....', 143),
(2, 'deuxieme reponse de la base', 1, 'et bien oui, .....', 1177),
(5, 'tesxte MAJ de la 5', 1, 'commentaire post rep', 1),
(4, 'tesxte du body de la reponse', 1, 'commentaire post rep', 1),
(6, 'tesxte du body de la reponse de vendredi matin', 1, 'commentaire post rep', 1);

-- --------------------------------------------------------

--
-- Structure de la table `designer`
--

DROP TABLE IF EXISTS `designer`;
CREATE TABLE IF NOT EXISTS `designer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `presentation` varchar(500) NOT NULL,
  `dateStatus` date NOT NULL,
  `expertiseField` varchar(500) NOT NULL,
  `certifier` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(500) NOT NULL,
  `createDate` date NOT NULL,
  `editDate` date NOT NULL,
  `idTheme` int(11) NOT NULL,
  `status` varchar(100) NOT NULL,
  `commentPostAnswer` varchar(500) NOT NULL,
  `help` varchar(500) NOT NULL,
  `idMultimedia` int(11) NOT NULL,
  `idForum` int(11) NOT NULL,
  `idDesigner` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `theme`
--

DROP TABLE IF EXISTS `theme`;
CREATE TABLE IF NOT EXISTS `theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pseudo` varchar(100) NOT NULL,
  `signInDate` date NOT NULL,
  `lastConnectionDate` date NOT NULL,
  `designer` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
