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

        public List<Cliente> ObterClientePorCpf(string cpf)
        {
            return contexto.Clientes.Where(x => x.CPF == cpf).ToList();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

        public bool VerificaExistenciaCliente(int id)
        {
            return contexto.Clientes.Count(x => x.Id == id) > 0;
        }

        public void Editar(Cliente cliente)
        {
            contexto.Entry(cliente).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }
    }
}
