-- MySQL dump 10.13  Distrib 5.6.19, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: contplus
-- ------------------------------------------------------
-- Server version	5.5.53-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conta` (
  `codigo` varchar(15) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` VALUES ('1','Ativo'),('1.1','Circulante'),('1.1.01','Disponível'),('1.1.01.01','Caixa'),('1.1.01.02','Bancos-ct/movimento'),('1.1.01.03','Aplicação no Mercado Financeiro'),('1.1.02','Mercadorias'),('1.1.03','Custos Acessórios de Mercadorias'),('1.1.04','Duplicatas a Receber'),('1.1.05','Despesas Antecipadas'),('1.2','Não Circulante'),('1.2.01','Realizável a Longo Prazo'),('1.2.01.01','Empréstimos a Diretores'),('1.2.02','Investimento'),('1.2.02.01','Ações'),('1.2.03','Imobilizado'),('1.2.03.01','Veículos'),('1.2.03.02','Maquinas e Equipamentos'),('1.2.03.03','Instalações'),('1.2.04','Intangível'),('1.2.04.01','Franquia'),('1.2.04.02','Despesas Diferidas'),('1.2.04.03','Ponto Comercial'),('1.3','Contas Retificadoras do Passivo'),('1.3.0','Capital a Realizar'),('1.3.1','Prejuízos Acumulados'),('1.4','Contas de Resultado Negativo'),('1.4.0','Devolução de Vendas'),('1.4.1','CMV Custo de Mercadorias Vendidas (Despesas)'),('1.4.2','Despesas com Vendas'),('1.4.2.01','Depesas de Comissões s/vendas'),('1.4.2.02','Despesas de Carreto'),('1.4.2.03','Despesas de Bonificação e Abatimento'),('1.4.2.04','Despesas de Salário de Vendas'),('1.4.2.05','Despesas de Propaganda e Publicidade'),('1.4.2.06','Despesas de Provisão para Devedores Duvidosos'),('1.4.3','Despesas Financeiras'),('1.4.3.01','Despesas de Juros Passivos'),('1.4.3.02','Despesas Bancárias'),('1.4.4','Despesas Administrativas'),('1.4.4.01','Despesas de Salário e Ordenados'),('1.4.4.02','Despesas de Manutenção de Instalações'),('1.4.4.03','Despesas de Depreciação'),('1.4.5','Despesas Tributárias'),('1.4.5.0','Despesas de ICMS'),('1.4.5.1','Despesas de ISS'),('1.4.5.2','Despesas com Imposto de Renda'),('1.4.5.3','Despesas de Impostos e Taxas Diversos'),('2','Passivo'),('2.1','Passivo Circulante'),('2.1.01','Fornecedores'),('2.1.02','Empréstimos Bancários'),('2.1.03','Duplicatas Descontadas'),('2.1.04','Tributos a Pagar'),('2.1.04.01','ICMS a Pagar'),('2.1.04.02','ISS a Pagar'),('2.1.04.03','Impostos Retidos'),('2.1.04.04','Imposto de Renda a Pagar'),('2.1.04.05','Lucros a Pagar'),('2.1.04.06','Débitos Diversos'),('2.2','Passivo Não Circulante'),('2.2.01','Financiamentos'),('2.3','Patrimônio Líquido'),('2.3.01','Capital'),('2.3.02','Reservas de Capital'),('2.3.03','Reservas de Lucros'),('2.3.04','Lucros'),('2.4','Contas Retificadoras Ativo'),('2.4.1','Retificadoras do Circulante'),('2.4.1.0','Duplictas Descontadas'),('2.4.1.1','Provisões'),('2.4.2','Retificadoras do Não Circulante'),('2.4.2.01','Depreciação'),('2.4.2.02','Amortização'),('2.4.2.03','Exaustão'),('2.5','Contas de Resultado Positivo'),('2.5.1','Venda de Mercadorias'),('2.5.2','Venda de Serviços'),('2.5.3','Devolução de Compras'),('2.5.4','Receita Financeira'),('2.5.5','Resultado');
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico`
--

DROP TABLE IF EXISTS `historico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historico` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `historico` varchar(100) NOT NULL,
  `tipo` varchar(15) NOT NULL,
  `conta_codigo` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_historico_conta_idx` (`conta_codigo`),
  CONSTRAINT `fk_historico_conta` FOREIGN KEY (`conta_codigo`) REFERENCES `conta` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico`
--

LOCK TABLES `historico` WRITE;
/*!40000 ALTER TABLE `historico` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-18  2:03:37
