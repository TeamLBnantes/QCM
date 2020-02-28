-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  ven. 28 fév. 2020 à 08:20
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
-- Base de données :  `qcmbdd`
--

-- --------------------------------------------------------

--
-- Structure de la table `answer`
--

DROP TABLE IF EXISTS `answer`;
CREATE TABLE IF NOT EXISTS `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(255) DEFAULT NULL,
  `commentPostAnswer` varchar(255) DEFAULT NULL,
  `expectedAnswer` bit(1) NOT NULL,
  `question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfiomvt17psxodcis3d8nmopx8` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `answer`
--

INSERT INTO `answer` (`id`, `body`, `commentPostAnswer`, `expectedAnswer`, `question_id`) VALUES
(4, 'reponse 1 de la question 3,false,remarque after', NULL, b'0', 58),
(5, 'reponse 1 de la question 3,false,remarque after', NULL, b'0', 58),
(19, 'qsdqsddqs', 'ddddd', b'0', 74),
(23, 'court', 'vxvcbbx', b'0', 58),
(24, 'dsfsd', 'sdfqds', b'0', 58);

-- --------------------------------------------------------

--
-- Structure de la table `designer`
--

DROP TABLE IF EXISTS `designer`;
CREATE TABLE IF NOT EXISTS `designer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `certifier` bit(1) NOT NULL,
  `dateStatus` datetime(6) DEFAULT NULL,
  `expertiseField` varchar(255) DEFAULT NULL,
  `presentation` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKespeylw7x8lr30761vfmp048y` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `designer`
--

INSERT INTO `designer` (`id`, `certifier`, `dateStatus`, `expertiseField`, `presentation`, `user_id`) VALUES
(1, b'0', '2020-02-24 09:45:37.926000', 'dddddd', 'ffffffff', 4),
(2, b'0', '2020-02-26 16:53:55.494000', 'dsqfqsdfsd', 'sqdfsdfdqsdq', 2);

-- --------------------------------------------------------

--
-- Structure de la table `forum`
--

DROP TABLE IF EXISTS `forum`;
CREATE TABLE IF NOT EXISTS `forum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `mcq`
--

DROP TABLE IF EXISTS `mcq`;
CREATE TABLE IF NOT EXISTS `mcq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(255) DEFAULT NULL,
  `createDate` datetime(6) DEFAULT NULL,
  `editDate` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `designer_id` int(11) DEFAULT NULL,
  `forum_id` int(11) DEFAULT NULL,
  `theme_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjs49pc7g618918oygxqggl03q` (`designer_id`),
  KEY `FKbl459pyxuw4l7qynwgbw8aa76` (`forum_id`),
  KEY `FKpvfu0kigtlymxrbu4b72gntbl` (`theme_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `mcqpassed`
--

DROP TABLE IF EXISTS `mcqpassed`;
CREATE TABLE IF NOT EXISTS `mcqpassed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `result` int(11) NOT NULL,
  `mcq_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK841qniu3yrbnl8wjbx5n8npug` (`mcq_id`),
  KEY `FKspwx99nsladdd9a81jq3whonp` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `multimedia`
--

DROP TABLE IF EXISTS `multimedia`;
CREATE TABLE IF NOT EXISTS `multimedia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(255) DEFAULT NULL,
  `commentPostAnswer` varchar(255) DEFAULT NULL,
  `createDate` datetime(6) DEFAULT NULL,
  `editDate` datetime(6) DEFAULT NULL,
  `help` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `designer_id` int(11) DEFAULT NULL,
  `forum_id` int(11) DEFAULT NULL,
  `multimedia_id` int(11) DEFAULT NULL,
  `theme_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmjvtsevkm2ttmp11h9b1dunir` (`designer_id`),
  KEY `FKfafki43vjc1wck2j1p0ocrx3p` (`forum_id`),
  KEY `FKi0342fqs6s3y9q9v8963wa4xm` (`multimedia_id`),
  KEY `FK71jjxmbbuukinwc0a4x611vc5` (`theme_id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`id`, `body`, `commentPostAnswer`, `createDate`, `editDate`, `help`, `status`, `designer_id`, `forum_id`, `multimedia_id`, `theme_id`) VALUES
(58, 'question3', 'bla bla bla via interface', NULL, NULL, NULL, 'free', 1, NULL, NULL, NULL),
(74, 'qsdqdsqds', 'qsdqsddsq', NULL, NULL, NULL, 'free', 1, NULL, NULL, NULL),
(75, 'new question', 'new question', NULL, NULL, NULL, 'free', 1, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `questionused`
--

DROP TABLE IF EXISTS `questionused`;
CREATE TABLE IF NOT EXISTS `questionused` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `AnswerAverageTime` time DEFAULT NULL,
  `nbAnswered` int(11) NOT NULL,
  `nbCorrect` int(11) NOT NULL,
  `mcq_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmv53td79rf0xwpsol4nylij8g` (`mcq_id`),
  KEY `FK9k3kmnndd5stimrck2lxa0k0j` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `theme`
--

DROP TABLE IF EXISTS `theme`;
CREATE TABLE IF NOT EXISTS `theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `theme`
--

INSERT INTO `theme` (`id`, `value`) VALUES
(1, 'uml');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastConnectionDate` datetime(6) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pseudo` varchar(255) DEFAULT NULL,
  `signInDate` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `email`, `firstName`, `lastConnectionDate`, `lastName`, `password`, `pseudo`, `signInDate`) VALUES
(1, 'gj@gj.fr', NULL, NULL, NULL, '789', NULL, NULL),
(2, 'laurent.boureau@nantes.fr', 'laurent', NULL, 'boureau', '$2a$10$UZ2jNvGolnSGQ4x0KH.L0.Und66ej3dmFgr9YiVV83WDNdUFQFAMa', NULL, NULL),
(3, 'homer.simpson@nantes.fr', 'simpson', NULL, NULL, '$2a$10$4bWdpgyfM4Nm5JndmAVeUeVWp/2ngYVOfNWY/5GHsJ4DN9PFTyCpm', NULL, '2020-02-21 16:59:43.616000'),
(4, 'bs@nantes.fr', 'barth', NULL, 'simpson', '$2a$10$PU8pC1ibf2gFCqJE5tEzFO/T6uRzmrZYkwOdkjVpu4pNdodhKjCDq', NULL, '2020-02-24 09:45:13.125000');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `FKfiomvt17psxodcis3d8nmopx8` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`);

--
-- Contraintes pour la table `designer`
--
ALTER TABLE `designer`
  ADD CONSTRAINT `FKespeylw7x8lr30761vfmp048y` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `mcq`
--
ALTER TABLE `mcq`
  ADD CONSTRAINT `FKbl459pyxuw4l7qynwgbw8aa76` FOREIGN KEY (`forum_id`) REFERENCES `forum` (`id`),
  ADD CONSTRAINT `FKjs49pc7g618918oygxqggl03q` FOREIGN KEY (`designer_id`) REFERENCES `designer` (`id`),
  ADD CONSTRAINT `FKpvfu0kigtlymxrbu4b72gntbl` FOREIGN KEY (`theme_id`) REFERENCES `theme` (`id`);

--
-- Contraintes pour la table `mcqpassed`
--
ALTER TABLE `mcqpassed`
  ADD CONSTRAINT `FK841qniu3yrbnl8wjbx5n8npug` FOREIGN KEY (`mcq_id`) REFERENCES `mcq` (`id`),
  ADD CONSTRAINT `FKspwx99nsladdd9a81jq3whonp` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FK71jjxmbbuukinwc0a4x611vc5` FOREIGN KEY (`theme_id`) REFERENCES `theme` (`id`),
  ADD CONSTRAINT `FKfafki43vjc1wck2j1p0ocrx3p` FOREIGN KEY (`forum_id`) REFERENCES `forum` (`id`),
  ADD CONSTRAINT `FKi0342fqs6s3y9q9v8963wa4xm` FOREIGN KEY (`multimedia_id`) REFERENCES `multimedia` (`id`),
  ADD CONSTRAINT `FKmjvtsevkm2ttmp11h9b1dunir` FOREIGN KEY (`designer_id`) REFERENCES `designer` (`id`);

--
-- Contraintes pour la table `questionused`
--
ALTER TABLE `questionused`
  ADD CONSTRAINT `FK9k3kmnndd5stimrck2lxa0k0j` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  ADD CONSTRAINT `FKmv53td79rf0xwpsol4nylij8g` FOREIGN KEY (`mcq_id`) REFERENCES `mcq` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
