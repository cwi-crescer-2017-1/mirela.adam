using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public string NomeCliente { get; set; }
        public List<ItemPedido> Itens { get; set; }

        public Pedido()
        {
            Itens = new List<ItemPedido>();
        }
        public bool Validar(out List<string> mensagens)
        {
            mensagens = new List<string>();

            foreach (var item in Itens)
            {
                if (item.Quantidade <= 0)
                {
                    mensagens.Add("Quantidade deve ser maior que zero.");
                }
            }

            if (string.IsNullOrWhiteSpace(NomeCliente))
            {
                mensagens.Add("Nome do cliente deve ser preenchido");
            }

            return mensagens.Count() == 0;
        }
    }
}
