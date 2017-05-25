using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace MirelaHaag
{
    [TestClass]
    public class Testes
    {
        [TestMethod]
        public void testeIndustriaSalario5000ComHoraExtraComDesconto()
        {
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 5000, 50, 10);
            Assert.AreEqual(5000, result.SalarioBase, 0.1);
            Assert.AreEqual(1250, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(250.0, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(6000.0, result.TotalProventos, 0.1);
            Assert.AreEqual(600.0, result.Inss.Valor, 0.1);
            Assert.AreEqual(1485.0, result.Irrf.Valor, 0.1);
            Assert.AreEqual(2085.0, result.TotalDescontos, 0.1);
            Assert.AreEqual(3915.0, result.TotalLiquido, 0.1);
            Assert.AreEqual(660.0, result.Fgts.Valor, 0.1);
        }
        
        [TestMethod]
        public void testeIndustriaSalario5000SemHoraExtraComDesconto()
        {   //irrf - 0.275
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 5000, 0, 10);
            Assert.AreEqual(5000, result.SalarioBase, 0.1);
            Assert.AreEqual(0, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(250.0, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(4750.0, result.TotalProventos, 0.1);
            Assert.AreEqual(475.0, result.Inss.Valor, 0.1);
            Assert.AreEqual(1175.62, result.Irrf.Valor, 0.1);
            Assert.AreEqual(1650.62, result.TotalDescontos, 0.1);
            Assert.AreEqual(3099.38, result.TotalLiquido, 0.1);
            Assert.AreEqual(522.5, result.Fgts.Valor, 0.1);
        }
        [TestMethod]
        public void testeIndustriaSalario5000SemHoraExtraSemDesconto()
        {   //irrf - 0.275
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 5000, 0, 0);
            Assert.AreEqual(5000, result.SalarioBase, 0.1);
            Assert.AreEqual(0, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(0, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(5000, result.TotalProventos, 0.1);
            Assert.AreEqual(500, result.Inss.Valor, 0.1);
            Assert.AreEqual(1237.5, result.Irrf.Valor, 0.1);
            Assert.AreEqual(1737.5, result.TotalDescontos, 0.1);
            Assert.AreEqual(3262.5, result.TotalLiquido, 0.1);
            Assert.AreEqual(550, result.Fgts.Valor, 0.1);
        }

        [TestMethod]
        public void testeIndustriaSalario4000ComHoraExtraComDesconto()
        {   //irrf - 0.225
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 4000, 10, 15);
            Assert.AreEqual(4000, result.SalarioBase, 0.1);
            Assert.AreEqual(200, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(300, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(3900, result.TotalProventos, 0.1);
            Assert.AreEqual(390, result.Inss.Valor, 0.1);
            Assert.AreEqual(789.75, result.Irrf.Valor, 0.1);
            Assert.AreEqual(1179.75, result.TotalDescontos, 0.1);
            Assert.AreEqual(2720.25, result.TotalLiquido, 0.1);
            Assert.AreEqual(429, result.Fgts.Valor, 0.1);
        }

        [TestMethod]
        public void testeIndustriaSalario4000ComHoraExtraSemDesconto()
        {   //irrf - 0.225
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 4000, 10, 0);
            Assert.AreEqual(4000, result.SalarioBase, 0.1);
            Assert.AreEqual(200, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(0, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(4200, result.TotalProventos, 0.1);
            Assert.AreEqual(420, result.Inss.Valor, 0.1);
            Assert.AreEqual(850.5, result.Irrf.Valor, 0.1);
            Assert.AreEqual(1270.5, result.TotalDescontos, 0.1);
            Assert.AreEqual(2929.5, result.TotalLiquido, 0.1);
            Assert.AreEqual(462, result.Fgts.Valor, 0.1);
        }

        [TestMethod]
        public void testeIndustriaSalario4000SemHoraExtraSemDesconto()
        {   //irrf - 0.225
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 4000, 0, 0);
            Assert.AreEqual(4000, result.SalarioBase, 0.1);
            Assert.AreEqual(0, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(0, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(4000, result.TotalProventos, 0.1);
            Assert.AreEqual(400, result.Inss.Valor, 0.1);
            Assert.AreEqual(810, result.Irrf.Valor, 0.1);
            Assert.AreEqual(1210, result.TotalDescontos, 0.1);
            Assert.AreEqual(2790, result.TotalLiquido, 0.1);
            Assert.AreEqual(440, result.Fgts.Valor, 0.1);
        }

        [TestMethod]
        public void testeIndustriaSalario3000ComHoraExtraComDesconto()
        {   //irrf -  0.15
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 3000, 10, 5);
            Assert.AreEqual(3000, result.SalarioBase, 0.1);
            Assert.AreEqual(150, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(75, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(3075, result.TotalProventos, 0.1);
            Assert.AreEqual(307.5, result.Inss.Valor, 0.1);
            Assert.AreEqual(415.12, result.Irrf.Valor, 0.1);
            Assert.AreEqual(722.62, result.TotalDescontos, 0.1);
            Assert.AreEqual(2352.38, result.TotalLiquido, 0.1);
            Assert.AreEqual(338.25, result.Fgts.Valor, 0.1);
        }
        [TestMethod]
        public void testeIndustriaSalario3000ComHoraExtraSemDesconto()
        {   
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 3000, 10, 0);
            Assert.AreEqual(3000, result.SalarioBase, 0.1);
            Assert.AreEqual(150, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(0, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(3150, result.TotalProventos, 0.1);
            Assert.AreEqual(315, result.Inss.Valor, 0.1);
            Assert.AreEqual(425.25, result.Irrf.Valor, 0.1);
            Assert.AreEqual(740.25, result.TotalDescontos, 0.1);
            Assert.AreEqual(2409.75, result.TotalLiquido, 0.1);
            Assert.AreEqual(346.5, result.Fgts.Valor, 0.1);
        }
        [TestMethod]
        public void testeIndustriaSalario3000SemHoraExtraSemDesconto()
        {   //irrf -  0.15
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 3000, 0, 0);
            Assert.AreEqual(3000, result.SalarioBase, 0.1);
            Assert.AreEqual(0, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(0, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(3000, result.TotalProventos, 0.1);
            Assert.AreEqual(300, result.Inss.Valor, 0.1);
            Assert.AreEqual(405, result.Irrf.Valor, 0.1);
            Assert.AreEqual(705, result.TotalDescontos, 0.1);
            Assert.AreEqual(2295, result.TotalLiquido, 0.1);
            Assert.AreEqual(330, result.Fgts.Valor, 0.1);
        }

        [TestMethod]
        public void testeIndustriaSalario2000ComHoraExtraComDesconto()
        {   //irrf - 0.075;
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 2000, 10, 5);
            Assert.AreEqual(2000, result.SalarioBase, 0.1);
            Assert.AreEqual(100, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(50, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(2050, result.TotalProventos, 0.1);
            Assert.AreEqual(205, result.Inss.Valor, 0.1);
            Assert.AreEqual(138.37, result.Irrf.Valor, 0.1);
            Assert.AreEqual(343.37, result.TotalDescontos, 0.1);
            Assert.AreEqual(1706.62, result.TotalLiquido, 0.1);
            Assert.AreEqual(225.5, result.Fgts.Valor, 0.1);
        }
        [TestMethod]
        public void testeIndustriaSalario2000ComHoraExtraSemDesconto()
        {   //irrf - 0.075;
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 2000, 10, 0);
            Assert.AreEqual(2000, result.SalarioBase, 0.1);
            Assert.AreEqual(100, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(0, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(2100, result.TotalProventos, 0.1);
            Assert.AreEqual(210, result.Inss.Valor, 0.1);
            Assert.AreEqual(141.75, result.Irrf.Valor, 0.1);
            Assert.AreEqual(351.75, result.TotalDescontos, 0.1);
            Assert.AreEqual(1748.25, result.TotalLiquido, 0.1);
            Assert.AreEqual(231, result.Fgts.Valor, 0.1);
        }

        [TestMethod]
        public void testeIndustriaSalario2000SemHoraExtraSemDesconto()
        {   //irrf - 0.075;
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 2000, 0, 0);
            Assert.AreEqual(2000, result.SalarioBase, 0.1);
            Assert.AreEqual(0, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(0, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(2000, result.TotalProventos, 0.1);
            Assert.AreEqual(200, result.Inss.Valor, 0.1);
            Assert.AreEqual(135, result.Irrf.Valor, 0.1);
            Assert.AreEqual(335, result.TotalDescontos, 0.1);
            Assert.AreEqual(1665, result.TotalLiquido, 0.1);
            Assert.AreEqual(220, result.Fgts.Valor, 0.1);
        }

        [TestMethod]
        public void testeIndustriaSalario1000ComHoraExtraComDesconto()
        {   //irrf - 0.075;
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDemonstrativo(200, 1000, 10, 10);
            Assert.AreEqual(1000, result.SalarioBase, 0.1);
            Assert.AreEqual(50, result.HorasExtras.ValorTotalHoras, 0.1);
            Assert.AreEqual(50, result.HorasDescontadas.ValorTotalHoras, 0.1);
            Assert.AreEqual(1000, result.TotalProventos, 0.1);
            Assert.AreEqual(80, result.Inss.Valor, 0.1);
            Assert.AreEqual(0, result.Irrf.Valor, 0.1);
            Assert.AreEqual(80, result.TotalDescontos, 0.1);
            Assert.AreEqual(920, result.TotalLiquido, 0.1);
            Assert.AreEqual(110, result.Fgts.Valor, 0.1);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_1000()
        {
            int horasCategoria = 200;
            double salarioBase = 1000;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new CalculoFolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1000;
            var inssAliquotaEsperado = 0.08;
            var inssValorEsperado = 80;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 80;
            var totalLiquidoEsperado = 920;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 110;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_139944()
        {
            int horasCategoria = 200;
            double salarioBase = 1399.44;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new CalculoFolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1399.44;
            var inssAliquotaEsperado = 0.09;
            var inssValorEsperado = 125.94;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 125.94;
            var totalLiquidoEsperado = 1273.5;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 153.93;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_161287()
        {
            int horasCategoria = 200;
            double salarioBase = 1612.87;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new CalculoFolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1612.87;
            var inssAliquotaEsperado = 0.1;
            var inssValorEsperado = 161.28;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 161.28;
            var totalLiquidoEsperado = 1451.59;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 177.41;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_181234()
        {
            int horasCategoria = 200;
            double salarioBase = 1812.34;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new CalculoFolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1812.34;
            var inssAliquotaEsperado = 0.1;
            var inssValorEsperado = 181.23;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 181.23;
            var totalLiquidoEsperado = 1631.11;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 199.35;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);


        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_201337()
        {
            int horasCategoria = 200;
            double salarioBase = 2013.37;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new CalculoFolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 2013.37;
            var inssAliquotaEsperado = 0.1;
            var inssValorEsperado = 201.33;
            var irrfAliquotaEsperado = 0.075;
            var irrfValorEsperado = 135.9;
            var totalDescontosEsperado = 337.23;
            var totalLiquidoEsperado = 1676.14;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 221.47;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_5000_HrE50_HrD10()
        {
            int horasCategoria = 200;
            double salarioBase = 5000;
            double horasExtras = 50;
            double horasDescontadas = 10;

            var folhaPagamento = new CalculoFolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 50;
            var valorTotalHorasExtrasEsperado = 1250;
            var quantidadeHorasDescontadasEsperado = 10;
            var valorTotalHorasDescontadasEsperado = 250;
            var totalProventosEsperado = 6000;
            var inssAliquotaEsperado = 0.10;
            var inssValorEsperado = 600;
            var irrfAliquotaEsperado = 0.275;
            var irrfValorEsperado = 1485;
            var totalDescontosEsperado = 2085;
            var totalLiquidoEsperado = 3915;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 660;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);
        }
    }
}

