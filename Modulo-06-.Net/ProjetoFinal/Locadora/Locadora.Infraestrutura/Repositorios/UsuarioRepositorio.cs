using Locadora.Dominio.Entidades;
using Locadora.Infraestrutura;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio
    {
        private Contexto contexto = new Contexto();

        public void Criar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
        }

        public Usuario Obter(string email)
        {
            return contexto.Usuarios.Where(u => u.Email == email)
                .Include(a => a.Permissoes)
                .FirstOrDefault();
        }
    }
}