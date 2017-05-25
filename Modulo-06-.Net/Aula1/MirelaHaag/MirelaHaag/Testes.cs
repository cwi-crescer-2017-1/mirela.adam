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
    }
}
