-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-07-2017 a las 21:19:19
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dds-tp-integrador`
--
CREATE DATABASE IF NOT EXISTS `dds-tp-integrador` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dds-tp-integrador`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `condiciones`
--

DROP TABLE IF EXISTS `condiciones`;
CREATE TABLE `condiciones` (
  `metodologia` varchar(500) NOT NULL,
  `indicador` varchar(50) NOT NULL,
  `numeroPeriodo` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
CREATE TABLE `cuentas` (
  `codCuenta` varchar(25) NOT NULL,
  `nombreCuenta` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`codCuenta`, `nombreCuenta`) VALUES
('iNetoOpCont', 'Ingreso Neto en Operaciones Continuas'),
('iNetoOpDisc', 'Ingreso Neto en Operaciones Discontinuas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `codEmpresa` varchar(20) NOT NULL,
  `nombreEmpresa` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`codEmpresa`, `nombreEmpresa`) VALUES
('face', 'Facebook'),
('tw', 'Twitter');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `indicadores`
--

DROP TABLE IF EXISTS `indicadores`;
CREATE TABLE `indicadores` (
  `nombreIndicador` varchar(25) NOT NULL,
  `indicador` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `indicadores`
--

INSERT INTO `indicadores` (`nombreIndicador`, `indicador`) VALUES
('indicadorPrueba', 'f(x)=x+1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodologias`
--

DROP TABLE IF EXISTS `metodologias`;
CREATE TABLE `metodologias` (
  `nombreMetodologia` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id_usuario` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `contrasena`) VALUES
('Hector', '1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valorcuenta`
--

DROP TABLE IF EXISTS `valorcuenta`;
CREATE TABLE `valorcuenta` (
  `codEmpresa` varchar(20) NOT NULL,
  `periodo` varchar(20) NOT NULL,
  `codCuenta` varchar(50) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `valorcuenta`
--

INSERT INTO `valorcuenta` (`codEmpresa`, `periodo`, `codCuenta`, `valor`) VALUES
('face', '2016', 'ebitda', 14870000000),
('face', '2016', 'iNetoOpCont', 4273000000),
('face', '2016', 'iNetoOpDis', 0),
('tw', '2017', 'iNetoOpCont', 4273000000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`codCuenta`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`codEmpresa`);

--
-- Indices de la tabla `indicadores`
--
ALTER TABLE `indicadores`
  ADD PRIMARY KEY (`nombreIndicador`);

--
-- Indices de la tabla `metodologias`
--
ALTER TABLE `metodologias`
  ADD PRIMARY KEY (`nombreMetodologia`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `valorcuenta`
--
ALTER TABLE `valorcuenta`
  ADD PRIMARY KEY (`codEmpresa`,`periodo`,`codCuenta`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
