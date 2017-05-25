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
        {
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
    }
}
