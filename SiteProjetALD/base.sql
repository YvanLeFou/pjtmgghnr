-- phpMyAdmin SQL Dump
-- version 3.2.1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Lun 02 Mai 2011 à 13:08
-- Version du serveur: 5.1.37
-- Version de PHP: 5.2.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de données: `projetald`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `idCategorie` int(11) NOT NULL AUTO_INCREMENT,
  `libelleCategorie` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idCategorie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`idCategorie`, `libelleCategorie`) VALUES
(1, 'Voiture'),
(2, 'Moto'),
(3, 'Caravaning'),
(4, 'Equipement auto'),
(5, 'Equipement moto'),
(6, 'Equipement caravaning'),
(7, 'Nautisme'),
(8, 'Informatique'),
(9, 'Consoles & Jeux vidéo'),
(10, 'Image & Son'),
(11, 'Téléphonie'),
(12, 'Ameublement'),
(13, 'Electroménager'),
(14, 'Arts de la table'),
(15, 'Décoration'),
(16, 'Linge de maison'),
(17, 'Bricolage / Jardinage'),
(18, 'Accessoires & Bagagerie'),
(19, 'Montres & Bijoux'),
(20, 'Equipement bébé'),
(21, 'DVD / Films'),
(22, 'CD / Musique'),
(23, 'Livres'),
(24, 'Animaux'),
(25, 'Sports & Hobbies'),
(26, 'Instruments de musique'),
(27, 'Collection'),
(28, 'Jeux & Jouets'),
(29, 'Vins & Gastronomie'),
(30, 'Matériel professionnel');

-- --------------------------------------------------------

--
-- Structure de la table `departement`
--

CREATE TABLE IF NOT EXISTS `departement` (
  `idDepartement` int(11) NOT NULL AUTO_INCREMENT,
  `libelleDepartement` varchar(30) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `idRegion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDepartement`),
  KEY `FK_Departement_idRegion` (`idRegion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=105 ;

--
-- Contenu de la table `departement`
--

INSERT INTO `departement` (`idDepartement`, `libelleDepartement`, `code`, `idRegion`) VALUES
(1, 'Ain', '01', 22),
(2, 'Aisne', '02', 19),
(3, 'Allier', '03', 2),
(4, 'Alpes de Haute Provence', '04', 21),
(5, 'Alpes (Hautes)', '05', 21),
(6, 'Alpes Maritimes', '06', 21),
(7, 'Ardéche', '07', 22),
(8, 'Ardennes', '08', 6),
(9, ' Ariége', '09', 14),
(10, 'Aube', '10', 6),
(11, 'Aude', '11', 11),
(12, 'Aveyron', '12', 14),
(13, 'Bouches du Rhône', '13', 21),
(14, 'Calvados', '14', 24),
(15, 'Cantal', '15', 2),
(16, 'Charente', '16', 20),
(17, 'Charente Maritime', '17', 20),
(18, 'Cher', '18', 5),
(19, 'Corréze', '19', 12),
(21, 'Creuse ', '23', 12),
(22, 'Dordogne', '24', 1),
(23, 'Doubs', '25', 9),
(24, 'Drôme', '26', 22),
(25, 'Eure', '27', 17),
(26, 'Eure et Loir', '28', 5),
(27, 'Finistére', '29', 4),
(28, 'Gard', '30', 11),
(29, 'Garonne (Haute)', '31', 14),
(30, 'Gers', '32', 14),
(31, 'Gironde', '33', 1),
(32, 'Hérault', '34', 11),
(33, 'Ile et Vilaine', '35', 4),
(34, 'Indre', '36', 5),
(35, 'Indre et Loire', '37', 5),
(36, 'Isére', '38', 22),
(37, 'Jura', '39', 9),
(38, 'Landes', '40', 1),
(39, 'Loir et Cher', '41', 5),
(40, 'Loire', '42', 22),
(41, 'Loire (Haute)', '43', 2),
(42, 'Loire Atlantique', '44', 18),
(43, 'Loiret', '45', 5),
(44, 'Lot', '46', 14),
(45, 'Lot et Garonne', '47', 1),
(46, 'Lozére', '48', 11),
(47, 'Maine et Loire', '49', 18),
(48, 'Manche', '50', 24),
(49, 'Marne', '51', 6),
(50, 'Marne (Haute)', '52', 6),
(51, 'Mayenne', '53', 18),
(52, 'Meurthe et Moselle', '54', 13),
(53, 'Meuse', '55', 13),
(54, 'Morbihan', '56', 4),
(55, 'Moselle', '57', 13),
(56, 'Niévre', '58', 3),
(57, 'Nord', '59', 15),
(58, 'Oise', '60', 19),
(59, 'Orne', '61', 24),
(60, 'Pas de Calais', '62', 15),
(61, 'Puy de Dôme', '63', 2),
(62, 'Pyrénées Atlantiques', '64', 1),
(63, 'Pyrénées (Hautes)', '65', 14),
(64, 'Pyrénées Orientales', '66', 11),
(65, 'Rhin (Bas)', '67', 23),
(66, 'Rhin (Haut)', '68', 23),
(67, 'Rhône', '69', 22),
(68, 'Saône (Haute)', '70', 9),
(69, 'Saône et Loire', '71', 3),
(70, 'Sarthe', '72', 18),
(71, 'Savoie', '73', 22),
(72, 'Savoie (Haute)', '74', 22),
(73, 'Paris', '75', 10),
(74, 'Seine Maritime', '76', 17),
(75, 'Seine et Marne', '77', 10),
(76, 'Yvelines', '78', 10),
(77, 'Sèvres (Deux)', '79', 20),
(78, 'Somme', '80', 19),
(79, 'Tarn', '81', 14),
(80, 'Tarn et Garonne', '82', 14),
(81, 'Var', '83', 21),
(82, 'Vaucluse', '84', 21),
(83, 'Vendée', '85', 18),
(84, 'Vienne', '86', 20),
(85, 'Vienne (Haute)', '87', 12),
(86, 'Vosges', '88', 13),
(87, 'Yonne', '89', 3),
(88, 'Belfort (Territoire de)', '90', 9),
(89, 'Essonne', '91', 10),
(90, 'Hauts de Seine', '92', 10),
(91, 'Seine Saint Denis', '93', 10),
(92, 'Val de Marne', '94', 10),
(93, 'Mayotte', '976', 8),
(94, 'Guadeloupe', '971', 8),
(95, 'Guyane', '973', 8),
(96, 'Martinique', '972', 8),
(97, 'Réunion', '974', 8),
(98, 'Côte d''or', '21', 4),
(100, 'Côtes d''armor', '22', 4),
(102, 'Corse du sud', '2A', 7),
(103, 'Haute corse', '2B', 7),
(104, 'Val d''oise', '95', 10);

-- --------------------------------------------------------

--
-- Structure de la table `droit`
--

CREATE TABLE IF NOT EXISTS `droit` (
  `idDroit` int(11) NOT NULL AUTO_INCREMENT,
  `libelleDroit` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idDroit`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `droit`
--

INSERT INTO `droit` (`idDroit`, `libelleDroit`) VALUES
(1, 'client'),
(2, 'administrateur');

-- --------------------------------------------------------

--
-- Structure de la table `encherit`
--

CREATE TABLE IF NOT EXISTS `encherit` (
  `pseudo` varchar(30) NOT NULL,
  `idOffre` int(11) NOT NULL,
  `prix` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`pseudo`,`idOffre`),
  KEY `FK_Encherit_idOffre` (`idOffre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `encherit`
--

INSERT INTO `encherit` (`pseudo`, `idOffre`, `prix`, `date`) VALUES
('emaneth', 3, 17, '2011-05-02 11:05:10'),
('emaneth', 4, 5, '2011-05-02 11:04:51'),
('Emaneth', 15, 9, '2011-04-11 13:05:00'),
('marguf', 1, 6, '2011-04-30 17:50:07'),
('marguf', 5, 14, '2011-05-02 11:02:24'),
('nico', 1, 8, '2011-05-02 09:47:56'),
('nico', 11, 35, '2011-05-02 11:02:48');

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

CREATE TABLE IF NOT EXISTS `image` (
  `idImage` int(11) NOT NULL AUTO_INCREMENT,
  `libelleImage` varchar(50) DEFAULT NULL,
  `idOffre` int(11) NOT NULL,
  PRIMARY KEY (`idImage`),
  KEY `FK_Image_idOffre` (`idOffre`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Contenu de la table `image`
--

INSERT INTO `image` (`idImage`, `libelleImage`, `idOffre`) VALUES
(1, 'ImageUpload\\27 avr. 2011', 1),
(2, 'ImageUpload\\27 avr. 2011 11-46-50', 2),
(3, 'ImageUpload\\2 mai 2011 10-27-48', 3),
(4, 'ImageUpload\\2 mai 2011 10-30-43', 4),
(5, 'ImageUpload\\2 mai 2011 10-32-47', 5),
(6, 'ImageUpload\\2 mai 2011 10-35-17', 6),
(7, 'ImageUpload\\2 mai 2011 10-37-17', 7),
(8, 'ImageUpload\\2 mai 2011 10-44-05', 8),
(9, 'ImageUpload\\2 mai 2011 10-46-16', 9),
(10, 'ImageUpload\\2 mai 2011 10-48-58', 10),
(11, 'ImageUpload\\2 mai 2011 10-52-08', 11),
(12, 'ImageUpload\\2 mai 2011 10-53-53', 12),
(13, 'ImageUpload\\2 mai 2011 11-10-25', 13),
(14, 'ImageUpload\\2 mai 2011 12-41-46', 14),
(15, 'ImageUpload\\2 mai 2011 13-02-02', 15);

-- --------------------------------------------------------

--
-- Structure de la table `internaute`
--

CREATE TABLE IF NOT EXISTS `internaute` (
  `pseudo` varchar(30) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `noRue` int(11) DEFAULT NULL,
  `nomRue` varchar(50) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `cp` varchar(5) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  `mdp` varchar(30) DEFAULT NULL,
  `idDepartement` int(11) DEFAULT NULL,
  `idDroit` int(11) DEFAULT NULL,
  PRIMARY KEY (`pseudo`),
  KEY `FK_Internaute_idDepartement` (`idDepartement`),
  KEY `FK_Internaute_idDroit` (`idDroit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `internaute`
--

INSERT INTO `internaute` (`pseudo`, `nom`, `prenom`, `noRue`, `nomRue`, `ville`, `cp`, `email`, `telephone`, `mdp`, `idDepartement`, `idDroit`) VALUES
('Admin', 'Guffroy', 'Marine', 8, 'rue des vignes', 'Onville', '54890', 'marguf@hotmail.com', '0383818268', 'admin', 57, 2),
('Babar', 'Elephant', 'Babar', 18, 'rue des bananes', 'Nancy', '54000', 'babardu54@truc.fr', '0605040302', 'babar', 52, 1),
('Emaneth', 'Huguin', 'Gabriel', 60, 'rue de la chapelle', 'Metz', '57000', 'dr_frankenstein@live.fr', '0606060606', 'emaneth', 55, 1),
('marguf', 'Guffroy', 'Marine', 8, 'rue des vignes', 'Onville', '54890', 'marguf@hotmail.com', '0698110356', 'uobjkm', 52, 1),
('Mickey', 'Mouse', 'Mickey', 95, 'Main Street', 'Marne la Vallée', '77777', 'mickey@disney.com', '0607060706', 'mickey', 75, 1),
('nico', 'Reitz', 'Nicolas', 28, 'rue des foufou', 'Hayange', '57700', 'nicolas.reitz@gmx.fr', '0606060660', 'a', 55, 1),
('VendeurTest', 'Université Paul Verlaine', 'TestVendeur', 1, 'Ile du Saulcy', 'Metz', '57012', 'test@mail.fr', '0102030405', 'a', 55, 1);

-- --------------------------------------------------------

--
-- Structure de la table `motclef`
--

CREATE TABLE IF NOT EXISTS `motclef` (
  `idMotClef` int(11) NOT NULL AUTO_INCREMENT,
  `libelleMotClef` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idMotClef`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `motclef`
--

INSERT INTO `motclef` (`idMotClef`, `libelleMotClef`) VALUES
(1, 'nazi'),
(2, 'organes'),
(3, 'craqué'),
(4, 'cracké'),
(5, 'pédophile'),
(6, 'arme'),
(7, 'drogue'),
(8, 'lsd'),
(10, 'cannabis');

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

CREATE TABLE IF NOT EXISTS `offre` (
  `idOffre` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(70) DEFAULT NULL,
  `descriptif` text,
  `miseAPrix` double DEFAULT NULL,
  `joignable` tinyint(1) DEFAULT NULL,
  `dateDepot` datetime DEFAULT NULL,
  `dateDebut` datetime DEFAULT NULL,
  `dateFin` datetime DEFAULT NULL,
  `suspecte` tinyint(1) DEFAULT NULL,
  `pseudo` varchar(30) DEFAULT NULL,
  `idDepartement` int(11) DEFAULT NULL,
  `idCategorie` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOffre`),
  KEY `FK_Offre_pseudo` (`pseudo`),
  KEY `FK_Offre_idDepartement` (`idDepartement`),
  KEY `FK_Offre_idCategorie` (`idCategorie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Contenu de la table `offre`
--

INSERT INTO `offre` (`idOffre`, `titre`, `descriptif`, `miseAPrix`, `joignable`, `dateDepot`, `dateDebut`, `dateFin`, `suspecte`, `pseudo`, `idDepartement`, `idCategorie`) VALUES
(1, '3 peluches diney', '3 peluches de 15 cm, neuves: minnie, dingo, mickey', 8, 0, '2011-04-27 10:48:18', '2010-12-15 00:00:00', '2011-05-09 00:00:00', 0, 'Mickey', 75, 28),
(2, 'Soupière', 'Soupière de luxe', 20, 0, '2011-04-27 11:46:50', '2010-08-08 00:00:00', '2011-04-28 00:00:00', 0, 'marguf', 55, 15),
(3, 'Arbre à chats', 'Arbre à chat3 étages + échelles\r\nMatière velours gris', 17, 1, '2011-05-02 10:27:48', '2011-05-01 00:00:00', '2011-05-03 00:00:00', 0, 'VendeurTest', 1, 24),
(4, 'Bougies gallets', '6 bougies en forme de gallets\r\ntaille environ 5 cm de long', 5, 0, '2011-05-02 10:30:43', '2011-03-15 00:00:00', '2011-05-06 00:00:00', 0, 'VendeurTest', 19, 15),
(5, 'Clavier souris Hello Kitty', 'Clavier et souris hellow kitty (azerty)', 14, 0, '2011-05-02 10:32:47', '2011-05-02 00:00:00', '2011-05-05 00:00:00', 0, 'VendeurTest', 17, 8),
(6, 'Clio', 'Clio blanche essence\r\nannée 2003', 1500, 1, '2011-05-02 10:35:17', '2010-12-08 00:00:00', '2011-06-09 00:00:00', 0, 'nico', 6, 1),
(7, 'Parasol rond bleu et blanc', 'Parasol rond, rayé bleu et blanc', 8, 1, '2011-05-02 10:37:17', '2011-05-03 00:00:00', '2011-06-03 00:00:00', 0, 'nico', 15, 17),
(8, 'Sims (5 jeux)', '5 jeux des sims:\r\n- deluxe edition\r\n- surprise partie\r\n- en vacances\r\n- entre chiens et chats\r\n- et plus si affinités', 50, 1, '2011-05-02 10:44:05', '2010-07-07 00:00:00', '2011-06-10 00:00:00', 0, 'emaneth', 64, 9),
(9, 'Guitare rose', 'Guitare sèche rose', 15, 0, '2011-05-02 10:46:16', '2010-08-21 00:00:00', '2011-05-20 00:00:00', 0, 'emaneth', 95, 26),
(10, 'Service de table 30 pièces', '6 assiettes plates\r\n6 assiettes à soupe\r\n6 assiettes à dessert\r\n6 sous tasse\r\n6 tasses', 9, 1, '2011-05-02 10:48:58', '2011-02-05 00:00:00', '2011-05-10 00:00:00', 0, 'marguf', 32, 14),
(11, 'Commode couleur argent', 'Commode argenté:    \r\n80*100*45', 35, 0, '2011-05-02 10:52:08', '2010-11-06 00:00:00', '2011-05-09 00:00:00', 0, 'marguf', 97, 12),
(12, 'Monopoly Simpsons', 'Monopoly version limitée Simpsons', 20, 0, '2011-05-02 10:53:53', '2010-06-06 00:00:00', '2011-06-06 00:00:00', 0, 'marguf', 67, 28),
(13, 'Pistolet', 'L.326 Le Page ® Target DeLuxe à percussion\r\n\r\nCalibre:44	 Longueur du canon: 260mm	 Longueur Totale: 435	 mm Poids: 1.1kg', 1700, 0, '2011-05-02 11:10:25', '2010-09-09 00:00:00', '2011-07-09 00:00:00', 2, 'VendeurTest', 61, 15),
(14, 'rêve', '30 grammes de cannabis\r\n(photo non contractuelle)', 10, 0, '2011-05-02 12:41:46', '2011-05-02 00:00:00', '2011-05-07 00:00:00', 1, 'Babar', 59, 29),
(15, 'BD Titeuf', 'Titeuf : le sens de la vie', 9, 0, '2011-04-06 13:02:02', '2011-04-06 00:00:00', '2011-04-20 00:00:00', 0, 'marguf', 68, 23);

-- --------------------------------------------------------

--
-- Structure de la table `region`
--

CREATE TABLE IF NOT EXISTS `region` (
  `idRegion` int(11) NOT NULL AUTO_INCREMENT,
  `libelleRegion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idRegion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Contenu de la table `region`
--

INSERT INTO `region` (`idRegion`, `libelleRegion`) VALUES
(1, 'Aquitaine'),
(2, 'Auvergne'),
(3, 'Bourgogne'),
(4, 'Bretagne'),
(5, 'Centre'),
(6, 'Champagne Ardenne'),
(7, 'Corse'),
(8, 'DOM/TOM'),
(9, 'Franche Comté'),
(10, 'Ile de France'),
(11, 'Languedoc Roussillon'),
(12, 'Limousin'),
(13, 'Lorraine'),
(14, 'Midi Pyrénées'),
(15, 'Nord Pas de Calais'),
(17, 'Haute Normandie '),
(18, 'Pays de la Loire'),
(19, 'Picardie'),
(20, 'Poitou Charentes'),
(21, 'Provence Alpes Côte d''azur'),
(22, 'Rhône Alpes'),
(23, 'Alsace'),
(24, 'Basse-Normandie');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `departement`
--
ALTER TABLE `departement`
  ADD CONSTRAINT `FK_Departement_idRegion` FOREIGN KEY (`idRegion`) REFERENCES `region` (`idRegion`);

--
-- Contraintes pour la table `encherit`
--
ALTER TABLE `encherit`
  ADD CONSTRAINT `FK_Encherit_idOffre` FOREIGN KEY (`idOffre`) REFERENCES `offre` (`idOffre`),
  ADD CONSTRAINT `FK_Encherit_pseudo` FOREIGN KEY (`pseudo`) REFERENCES `internaute` (`pseudo`);

--
-- Contraintes pour la table `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `FK_Image_idOffre` FOREIGN KEY (`idOffre`) REFERENCES `offre` (`idOffre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `internaute`
--
ALTER TABLE `internaute`
  ADD CONSTRAINT `FK_Internaute_idDepartement` FOREIGN KEY (`idDepartement`) REFERENCES `departement` (`idDepartement`),
  ADD CONSTRAINT `FK_Internaute_idDroit` FOREIGN KEY (`idDroit`) REFERENCES `droit` (`idDroit`);

--
-- Contraintes pour la table `offre`
--
ALTER TABLE `offre`
  ADD CONSTRAINT `FK_Offre_idCategorie` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`),
  ADD CONSTRAINT `FK_Offre_idDepartement` FOREIGN KEY (`idDepartement`) REFERENCES `departement` (`idDepartement`),
  ADD CONSTRAINT `FK_Offre_pseudo` FOREIGN KEY (`pseudo`) REFERENCES `internaute` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE;
