-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  ven. 13 mars 2020 à 01:00
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
  `body` varchar(255) DEFAULT NULL,
  `commentPostAnswer` varchar(255) DEFAULT NULL,
  `expectedAnswer` bit(1) NOT NULL,
  `question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfiomvt17psxodcis3d8nmopx8` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `answer`
--

INSERT INTO `answer` (`id`, `body`, `commentPostAnswer`, `expectedAnswer`, `question_id`) VALUES
(1, 'electra', 'confusion. c\'est en fait Personnage de fiction apparaissant dans Daredevil.', b'0', 1),
(2, 'zoe', 'modele depose par le constructeur', b'1', 1),
(3, ' scrum', 'commentaire sur cette rÃ©ponse.', b'1', 2),
(4, 'XP Programming', 'particulierement orienteee sur l\'aspect realisation d\'une application. Pour autant, elle est moi mise en oeuvre ue scrum.', b'0', 2),
(5, '4', '17/9 = 3', b'1', 3),
(6, '2', '7/9 = 3', b'0', 3),
(7, '4', '7/9 = 3', b'1', 3),
(8, '1 ans', 'non quand mÃªme', b'0', 4),
(9, '2 ans', 'c\'est juste son prÃ©nom ;-)', b'1', 4),
(10, 'nantes', 'peut etre de la bretagne, mais pas de la france !!', b'0', 5),
(11, 'Paris', '', b'1', 5),
(12, 'lyon', 'du temps d\'Obelix, mais plus maintenant !!', b'0', 5),
(14, 'trello', 'tableau kanban', b'0', 6),
(15, 'deezer', '', b'0', 6),
(16, 'vertou', 'vu du club de Kayak', b'0', 5),
(17, 'DUOLINGO', '', b'1', 6);

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
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1iop30hmiwmekf5rwvx1yjum3` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `designer`
--

INSERT INTO `designer` (`id`, `certifier`, `dateStatus`, `expertiseField`, `presentation`, `user_id`) VALUES
(1, b'0', '2020-03-13 00:52:06.962000', 'Durite, JPA, Hibernate .....', 'Je vis a Nantes, depuis peu dans le developpement logiciel\r\nJe prends beaucoup de plaisir Ã  travailler sur le environnements Java.', 1),
(2, b'0', '2020-03-13 01:31:37.659000', 'il a revolutionne le monde', 'Einstein est expert en relativite', 2);

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
  `theme` varchar(255) DEFAULT NULL,
  `topic` varchar(255) DEFAULT NULL,
  `designer_id` int(11) DEFAULT NULL,
  `forum_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjs49pc7g618918oygxqggl03q` (`designer_id`),
  KEY `FKbl459pyxuw4l7qynwgbw8aa76` (`forum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `mcq`
--

INSERT INTO `mcq` (`id`, `body`, `createDate`, `editDate`, `status`, `theme`, `topic`, `designer_id`, `forum_id`) VALUES
(1, '  Questionnaire sur les voitures', '2020-03-13 01:05:21.869000', '2020-03-13 01:05:21.869000', 'disponible', NULL, 'mecanique', 1, NULL),
(2, '  qcm1 de albert', '2020-03-13 01:41:37.706000', '2020-03-13 01:41:37.706000', 'free', NULL, '', 2, NULL),
(3, ' nom du qcm', '2020-03-13 01:44:39.047000', '2020-03-13 01:46:23.112000', 'free', NULL, '', 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `mcqpassed`
--

DROP TABLE IF EXISTS `mcqpassed`;
CREATE TABLE IF NOT EXISTS `mcqpassed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `finalise` bit(1) NOT NULL,
  `result` int(11) NOT NULL,
  `mcq_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK841qniu3yrbnl8wjbx5n8npug` (`mcq_id`),
  KEY `FKspwx99nsladdd9a81jq3whonp` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `mcqpassed`
--

INSERT INTO `mcqpassed` (`id`, `finalise`, `result`, `mcq_id`, `user_id`) VALUES
(1, b'0', 0, 2, 3),
(2, b'0', 0, 1, 2),
(3, b'0', 0, 3, 1),
(4, b'0', 0, 3, 1),
(5, b'0', 0, 2, 1),
(6, b'0', 0, 3, 2),
(7, b'0', 0, 1, 2),
(8, b'0', 0, 3, 2);

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
  `theme` varchar(255) DEFAULT NULL,
  `topic` varchar(255) DEFAULT NULL,
  `designer_id` int(11) DEFAULT NULL,
  `forum_id` int(11) DEFAULT NULL,
  `multimedia_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmjvtsevkm2ttmp11h9b1dunir` (`designer_id`),
  KEY `FKfafki43vjc1wck2j1p0ocrx3p` (`forum_id`),
  KEY `FKi0342fqs6s3y9q9v8963wa4xm` (`multimedia_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`id`, `body`, `commentPostAnswer`, `createDate`, `editDate`, `help`, `status`, `theme`, `topic`, `designer_id`, `forum_id`, `multimedia_id`) VALUES
(1, '    Renault commercialise un petite voiture electrique. Qu\'elle est son nom ? (Question de Alphonse)', 'culture generale industrie automobile Francaise', '2020-03-13 01:07:56.849000', '2020-03-13 01:20:07.445000', NULL, 'disponible', NULL, 'voiture', 1, NULL, NULL),
(2, '    methode Agile (de Gaston). quelle est le nom de la methode actuellement la plus utilisee dans l\'univers de l\'IT (Question de Alphonse)', 'La metaphore du scrum (melee du rugby) apparait pour la premiere fois en 1986', '2020-03-13 01:14:27.433000', '2020-03-13 01:20:21.974000', NULL, 'validate', NULL, 'IT', 1, NULL, NULL),
(3, '   est plus grand que 27/9  (QCM de Alphonse)', 'revision des table de multiplication', '2020-03-13 01:21:38.164000', '2020-03-13 01:24:16.068000', NULL, 'disponible', NULL, 'calcul mental', 1, NULL, NULL),
(4, ' Le controle technique pour une voiture de plus de 4 ans doit se faire tout les ?\r\n(question de Alphonse)', 'c\'est pas d\'aujourd\'hui :-(', '2020-03-13 01:26:04.135000', '2020-03-13 01:26:04.135000', NULL, 'free', NULL, 'voiture', 1, NULL, NULL),
(5, '  capital de la france', 'bas si vous ne savez pas, votre cas est desesperant', '2020-03-13 01:33:30.546000', '2020-03-13 01:35:45.343000', NULL, 'disponible', NULL, 'geographie', 2, NULL, NULL),
(6, '  appli pour faire de L\'anglais sur smartphone', '', '2020-03-13 01:37:46.768000', '2020-03-13 01:37:55.069000', NULL, 'free', NULL, 'it', 2, NULL, NULL),
(7, '  bla bla bla ......', '1234567890\r\n1234567890\r\n1234567890', '2020-03-13 01:40:03.212000', '2020-03-13 01:40:07.107000', NULL, 'validate', NULL, 'tmp', 2, NULL, NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `questionused`
--

INSERT INTO `questionused` (`id`, `AnswerAverageTime`, `nbAnswered`, `nbCorrect`, `mcq_id`, `question_id`) VALUES
(1, NULL, 0, 0, 3, 6),
(2, NULL, 0, 0, 3, 1),
(3, NULL, 0, 0, 3, 5),
(4, NULL, 0, 0, 2, 6),
(5, NULL, 0, 0, 2, 5),
(6, NULL, 0, 0, 2, 2),
(7, NULL, 0, 0, 1, 1),
(8, NULL, 0, 0, 1, 4);

-- --------------------------------------------------------

--
-- Structure de la table `theme`
--

DROP TABLE IF EXISTS `theme`;
CREATE TABLE IF NOT EXISTS `theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_e6gkqunxajvyxl5uctpl2vl2p` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `email`, `firstName`, `lastConnectionDate`, `lastName`, `password`, `pseudo`, `signInDate`) VALUES
(1, 'at@dawan.fr', 'Alphonse', NULL, 'TABOGNOLE', '$2a$10$Dt18X2ms23X4vNufFwMbBez61bG4aFFCjvyeaH3mZB.W.2kyJ4atm', 'speedy Gonzalez', '2020-03-13 00:49:36.628000'),
(2, 'a-einstein@dawan.fr', 'Albert', NULL, 'EINSTEIN', '$2a$10$vf9VAFkSzQV4Air1lKNtC.SLWwIJrvnqhMxm3nyYZKDZBt2E289Te', 'E=MC2', '2020-03-13 01:30:19.742000'),
(3, 'hp@dawan.fr', 'Harry', NULL, 'POTTER', '$2a$10$Ln3R/UVJXQQQKsFdtlxcBeij66Fzu5lC.3L9V7AZ66fBfBNqORjxq', 'LeRoiDuBalai', '2020-03-13 01:48:18.349000');

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
  ADD CONSTRAINT `FKjs49pc7g618918oygxqggl03q` FOREIGN KEY (`designer_id`) REFERENCES `designer` (`id`);

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
