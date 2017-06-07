using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Locacao
    {
        public int Id { get; private set; }
        public DateTime DataRetirada { get; private set; }
        public DateTime DataPrevisaoEntrega { get; private set; }
        public double ValorPrevisao { get; private set; }
        public DateTime? DataRealEntrega { get; private set; }
        public double? ValorRealLocacao { get; private set; }
        public Cliente Cliente { get; private set; }
        public Produto Produto { get; private set; }
        public Pacote Pacote { get; private set; }
        public List<Opcional> Opcionais { get; private set; }

        protected Locacao() { } //EF 

        public Locacao (Cliente cliente, Produto produto, Pacote pacote, List<Opcional> opcionais)
        {
            Cliente = cliente;
            Produto = produto;
            Pacote = pacote;
            Opcionais = opcionais;
            DataRetirada = DateTime.Now.Date;
            DataPrevisaoEntrega = CalculaDataEntrega();
            ValorPrevisao = CalcularValorLocacao();
        }

        public DateTime CalculaDataEntrega()
        {
            return DataRetirada.Date.AddDays(Pacote.QtdDias);
        }

        public double CalcularValorLocacao()
        {
            double valorProduto = Produto.ValorDiaria * Pacote.QtdDias;
            double valorOpcional = Opcionais.Sum(x => x.ValorDiaria) * Pacote.QtdDias;
            double valorPacote = Pacote.Valor;

            return valorProduto + valorPacote + valorOpcional;
        }

        public void Devolver()
        {
            DataRealEntrega = DateTime.Now.Date;
            ValorRealLocacao = CalcularValorRealLocacao();
        }

        private double CalcularValorRealLocacao()
        {
            var diasExcedidos = Convert.ToInt32(DataRealEntrega.Value.Subtract(DataPrevisaoEntrega).TotalDays);
            var valorProdutoAtualizado = 0D;
            var valorOpcionalAtualizado = 0D;

            if (diasExcedidos > 0)
            {
                valorProdutoAtualizado = Produto.ValorDiaria * diasExcedidos;
                
            }
           
            return ValorPrevisao;
        }
    }
}
