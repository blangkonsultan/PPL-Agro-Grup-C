-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2018 at 05:09 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hutanku`
--

-- --------------------------------------------------------

--
-- Table structure for table `pemain`
--

CREATE TABLE `pemain` (
  `idPemain` int(11) NOT NULL,
  `namaPemain` varchar(50) NOT NULL,
  `level1` varchar(10) NOT NULL,
  `level2` varchar(10) NOT NULL,
  `level3` varchar(10) NOT NULL,
  `level4` varchar(10) NOT NULL,
  `level5` varchar(10) NOT NULL,
  `pupuk` int(11) NOT NULL,
  `siram` int(11) NOT NULL,
  `karet` int(11) NOT NULL,
  `pilang` int(11) NOT NULL,
  `cemara` int(11) NOT NULL,
  `kapur` int(11) NOT NULL,
  `pinus` int(11) NOT NULL,
  `kayuhitam` int(11) NOT NULL,
  `jati` int(11) NOT NULL,
  `kayubesi` int(11) NOT NULL,
  `uang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pemain`
--

INSERT INTO `pemain` (`idPemain`, `namaPemain`, `level1`, `level2`, `level3`, `level4`, `level5`, `pupuk`, `siram`, `karet`, `pilang`, `cemara`, `kapur`, `pinus`, `kayuhitam`, `jati`, `kayubesi`, `uang`) VALUES
(1, 'a', 'true', 'false', 'false', 'false', 'false', 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(2, 'b', 'true', 'false', 'false', 'false', 'false', 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0),
(3, 'c', 'false', 'true', 'false', 'false', 'false', 2, 2, 1, 1, 1, 5, 1, 1, 1, 1, 200);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pemain`
--
ALTER TABLE `pemain`
  ADD PRIMARY KEY (`idPemain`),
  ADD UNIQUE KEY `namaPemain` (`namaPemain`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pemain`
--
ALTER TABLE `pemain`
  MODIFY `idPemain` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
