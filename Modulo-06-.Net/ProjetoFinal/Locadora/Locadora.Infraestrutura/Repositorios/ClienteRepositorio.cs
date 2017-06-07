using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Repositorios
{
    public class ClienteRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Cliente> Obter()
        {
            return contexto.Clientes.ToList();
        }

        public void Criar(Cliente cliente)
        {
            contexto.Clientes.Add(cliente);
            contexto.SaveChanges();
        }

        public void Excluir(int id)
        {
            var revisor = contexto.Clientes.FirstOrDefault(x => x.Id == id);
            contexto.Clientes.Remove(revisor);
            contexto.SaveChanges();
        }

        public Cliente ObterClientePorCpf(string cpf)
        {
            return contexto.Clientes.Where(x => x.CPF == cpf).FirstOrDefault();
        }

        public Cliente ObterClientePorId(int id)
        {
            return contexto.Clientes.Where(x => x.Id == id).FirstOrDefault();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

        public bool VerificaExistenciaCliente(int id)
        {
            return contexto.Clientes.Count(x => x.Id == id) > 0;
        }

    }
}
