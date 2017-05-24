using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace MirelaHaag
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void Pode_Instanciar_Demonstrativo()
        {
            double salarioBase = 5000D;
            double hrsConvencao = 200;
            HorasCalculadas horasExtras = new HorasCalculadas(50, 50 * 25);
            HorasCalculadas horasDescontadas = new HorasCalculadas(10, 10 * 25);
            double totalProventos = salarioBase + horasExtras.ValorTotalHoras - horasDescontadas.ValorTotalHoras;
            Desconto inss = new Desconto(10, salarioBase * 0.10);
            Desconto irrf = new Desconto(27.5, salarioBase * 0.275);
            double totalDescontos; 
            double totalLiquido;
            Desconto fgts = new MirelaHaag.Desconto(10, 10000);
        }
    }
}
