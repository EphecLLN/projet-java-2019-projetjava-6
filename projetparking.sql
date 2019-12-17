-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 17 déc. 2019 à 12:25
-- Version du serveur :  10.4.10-MariaDB
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
-- Base de données :  `projetparking`
--

-- --------------------------------------------------------

--
-- Structure de la table `offence`
--

CREATE TABLE `offence` (
  `idOffence` int(11) NOT NULL COMMENT 'id de l''offence',
  `idUserSignal` int(11) NOT NULL COMMENT 'id de l''utilisateur signalant',
  `idUserFlagged` int(11) NOT NULL COMMENT 'id de l''utilisateur qui est en tort',
  `comment` char(140) NOT NULL COMMENT 'commentaire sur la faute',
  `idPlace` int(11) NOT NULL COMMENT 'id de la place ou a lieu l''infraction',
  `date` char(50) NOT NULL DEFAULT current_timestamp() COMMENT 'date ou à lieu l''infraction'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `offence`
--

INSERT INTO `offence` (`idOffence`, `idUserSignal`, `idUserFlagged`, `comment`, `idPlace`, `date`) VALUES
(1, 1, 1, 'Test de base', 1, '0000-00-00');

-- --------------------------------------------------------

--
-- Structure de la table `parking`
--

CREATE TABLE `parking` (
  `idParking` int(11) NOT NULL COMMENT 'id du parking',
  `name` char(50) NOT NULL COMMENT 'nom du parking',
  `position` char(100) NOT NULL COMMENT 'adresse ou se situe le parking',
  `placeTot` int(11) NOT NULL COMMENT 'nombre de place totale du parking',
  `placeDispo` int(11) NOT NULL COMMENT 'nombre de place encore disponible',
  `type` char(10) NOT NULL COMMENT 'type du parking'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `parking`
--

INSERT INTO `parking` (`idParking`, `name`, `position`, `placeTot`, `placeDispo`, `type`) VALUES
(1, 'Baudoin 1er', 'Boulevard Baudoin 1er Louvain-la-Neuve', 210, 210, 'Gratuit'),
(2, 'Parking Agro', '', 91, 90, 'UCL A3'),
(3, 'Parking croix du sud', 'Avenue Théodore Schwann Louvain-la-Neuve', 120, 120, 'UCL B'),
(4, 'Parking Cyclotron', 'Rue Louis de Geer Louvain-la-Neuve', 75, 75, 'UCL B'),
(5, 'Parking de Lauzelle', 'Boulevard de Lauzelle 61 Louvain-la-Neuve', 180, 180, 'Gratuit'),
(6, 'Parking des Sciences', 'Porte Lemaitre 6 Louvain-la-Neuve', 80, 80, 'UCL B'),
(7, 'Parking Euler', '', 89, 89, 'UCL A3'),
(8, 'Parking Grand-Place', '', 300, 300, 'UCL A1'),
(9, 'Parking Grand-Rue', '', 200, 200, 'UCL A1'),
(10, 'Parking Halles', '', 86, 86, 'UCL A1'),
(11, 'Parking Leclercq', 'Boulevard du Sud Louvain-la-Neuve', 433, 433, 'UCL A2'),
(12, 'Parking Les Serres', '', 90, 90, 'UCL A3'),
(13, 'Parking Magritte', 'Avenue du Ciseau 10 Louvain-la-Neuve', 60, 60, 'UCL B'),
(14, 'Parking Montesquieu', '', 288, 288, 'UCL A1'),
(15, 'Parking P14', 'Avenue Georges Lemaitre 39 Louvain-la-Neuve', 90, 90, 'UCL B'),
(16, 'Parking Rédimé', 'Porte Lemaitre 39 Louvain-la-Neuve', 74, 74, 'Gratuit'),
(17, 'Parking Sablon', '', 192, 192, 'UCL A2'),
(18, 'Parking Sainte-Barbe', 'Rue du Compas Louvain-la-Neuve', 150, 150, 'UCL B'),
(19, 'Parking Socrate', '', 198, 198, 'UCL A1'),
(20, 'Parking Wallons', '', 230, 230, 'UCL A2'),
(21, 'Parking Vinci', '', 104, 104, 'UCL A3'),
(22, 'Parking Hocaille', 'Route de Longchamp 10 Louvain-la-Neuve', 80, 80, 'UCL B');

-- --------------------------------------------------------

--
-- Structure de la table `place`
--

CREATE TABLE `place` (
  `idPlace` int(11) NOT NULL COMMENT 'id de la place',
  `number` int(11) NOT NULL COMMENT 'numéro de la place sur le parking',
  `idParking` int(11) NOT NULL COMMENT 'id du parking sur lequel la place se trouve',
  `booked` tinyint(1) NOT NULL DEFAULT 0 COMMENT 'dit si la place est prise ou non'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `place`
--

INSERT INTO `place` (`idPlace`, `number`, `idParking`, `booked`) VALUES
(1, 1, 2, 0);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `idReservation` int(11) NOT NULL COMMENT 'id de la réservation',
  `idPlace` int(11) NOT NULL COMMENT 'id de la place réservée',
  `idUser` int(11) NOT NULL COMMENT 'id de l''utilisateur qui a fait la réservation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`idReservation`, `idPlace`, `idUser`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `idUser` int(11) NOT NULL COMMENT 'id de l''utilisateur',
  `name` char(50) NOT NULL COMMENT 'nom de l''utilisateur',
  `firstName` char(50) NOT NULL COMMENT 'prénom de l''utilisateur',
  `phone` char(13) NOT NULL COMMENT 'n° de téléphone de l''utilisateur',
  `mail` char(100) NOT NULL COMMENT 'mail de l''utilisateur',
  `plate` char(9) NOT NULL COMMENT 'plaque de la voiture de l''utilisateur',
  `penalty` int(11) DEFAULT NULL COMMENT 'nombre de pénalité de l''utilisateur',
  `username` char(50) DEFAULT NULL,
  `mdp` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`idUser`, `name`, `firstName`, `phone`, `mail`, `plate`, `penalty`, `username`, `mdp`) VALUES
(0, 'admin', 'admin', '0478262700', 'admin.admin@admin.com', '87tx3', 1, 'admin', 'admin');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `offence`
--
ALTER TABLE `offence`
  ADD PRIMARY KEY (`idOffence`);

--
-- Index pour la table `parking`
--
ALTER TABLE `parking`
  ADD PRIMARY KEY (`idParking`);

--
-- Index pour la table `place`
--
ALTER TABLE `place`
  ADD PRIMARY KEY (`idPlace`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`idReservation`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`idUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
