-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-09-2017 a las 05:05:00
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
  `monto` varchar(20) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `id` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `condiciones`
--

INSERT INTO `condiciones` (`metodologia`, `indicador`, `monto`, `tipo`, `id`) VALUES
('metoHector', 'indicadorBueno', '2', 'menorA', 2),
('MetoVic', 'indicadorVic', '546', 'mayorA', 3),
('MetoVic', 'indicadorVic', '2', 'menorA', 4);

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
('iNetoOpDisc', 'Ingreso Neto en Operaciones Discontinuas'),
('ingresoNetito', 'ingreso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

DROP TABLE IF EXISTS `empresas`;
CREATE TABLE `empresas` (
  `codEmpresa` varchar(20) NOT NULL,
  `nombreEmpresa` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`codEmpresa`, `nombreEmpresa`) VALUES
('face', 'Facebook'),
('tw', 'Twitter'),
('wpp', 'Whatsapp');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `indicadores`
--

DROP TABLE IF EXISTS `indicadores`;
CREATE TABLE `indicadores` (
  `nombreIndicador` varchar(25) NOT NULL,
  `indicador` varchar(500) NOT NULL,
  `id_usuario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `indicadores`
--

INSERT INTO `indicadores` (`nombreIndicador`, `indicador`, `id_usuario`) VALUES
('indicadorBueno', 'f(iNetoOpCont)=iNetoOpCont + 1', 'Hector'),
('indicadorVic', 'f(iNetoOpDisc)=iNetoOpDisc + 4', 'Vic');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodologias`
--

DROP TABLE IF EXISTS `metodologias`;
CREATE TABLE `metodologias` (
  `nombreMetodologia` varchar(500) NOT NULL,
  `id_usuario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `metodologias`
--

INSERT INTO `metodologias` (`nombreMetodologia`, `id_usuario`) VALUES
('metoHector', 'Hector'),
('MetoVic', 'Vic');

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
('Hector', '123'),
('Vic', '987');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valorcuenta`
--

DROP TABLE IF EXISTS `valorcuenta`;
CREATE TABLE `valorcuenta` (
  `codEmpresa` varchar(20) NOT NULL,
  `periodo` varchar(20) NOT NULL,
  `codCuenta` varchar(50) NOT NULL,
  `valor` double NOT NULL,
  `id` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `valorcuenta`
--

INSERT INTO `valorcuenta` (`codEmpresa`, `periodo`, `codCuenta`, `valor`, `id`) VALUES
('face', '2016', 'iNetoOpCont', 4273000000, 4),
('face', '2016', 'iNetoOpDisc', 0, 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `condiciones`
--
ALTER TABLE `condiciones`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`codCuenta`);

--
-- Indices de la tabla `empresas`
--
ALTER TABLE `empresas`
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
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
