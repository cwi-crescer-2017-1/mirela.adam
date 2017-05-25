using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MirelaHaag
{
    public class CalculoFolhaPagamento : IFolhaPagamento
    {

        public Demonstrativo GerarDemonstrativo (int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            double valorHora = Math.Round(salarioBase / horasCategoria, 2);
            HorasCalculadas totalHorasExtras = new HorasCalculadas(horasExtras, horasExtras*valorHora);
            HorasCalculadas totalHorasDescontadas = new HorasCalculadas(horasDescontadas, horasDescontadas*valorHora);
            double totalProventos = Math.Round(salarioBase + totalHorasExtras.ValorTotalHoras - totalHorasDescontadas.ValorTotalHoras, 2);
            //INSS
            double aliqINSS = aliquotaINSS(totalProventos);
            Desconto INSS = new Desconto(aliqINSS, calculaImposto(totalProventos, aliqINSS));
            //IRRF
            double aliqIRRF = aliquotaIRRF(totalProventos - INSS.Valor);
            Desconto IRRF = new Desconto(aliqIRRF, calculaImposto(totalProventos - INSS.Valor, aliqIRRF));
            //DESCONTOS
            Double totalDescontos = INSS.Valor + IRRF.Valor;
            //LIQUIDO
            Double salarioLiquido = totalProventos - totalDescontos;
            //FGTS: Fundo de garantia sobre tempo de serviço deve ser apenas discriminado 11% fixo.
            Desconto valorFgts = new Desconto(0.11, totalProventos*0.11);

            Demonstrativo demonstrativo = new Demonstrativo(salarioBase, horasCategoria, totalHorasExtras, totalHorasDescontadas, totalProventos, 
                                                   INSS, IRRF, totalDescontos, salarioLiquido, valorFgts);

            return demonstrativo;

        }

        public double calculaImposto(double baseCalculo, double aliquota)
        {
            return Math.Round(baseCalculo * aliquota, 2);
        }

        public double aliquotaINSS(double totalProventos)
        {
            double aliquota = 0;
            if (totalProventos <= 1000)
            {
                aliquota = 0.08;
            }
            else if (totalProventos <= 1500)
            {
                aliquota = 0.09;
            }
            else
            {
                aliquota = 0.1;
            }
            return aliquota;
        }
        
        public double aliquotaIRRF (double baseCalculo)
        {
            double aliquota;
            if (baseCalculo <= 1710.78)
            {
                aliquota = 0;
            } 
            else if (baseCalculo <= 2563.91)
            {
                aliquota = 0.075;
            }
            else if (baseCalculo <= 3418.59)
            {
                aliquota = 0.15;
            }
            else if (baseCalculo <= 4271.59)
            {
                aliquota = 0.225;
            }
            else
            {
                aliquota = 0.275;
            }
            return aliquota;
        }

    }
}
