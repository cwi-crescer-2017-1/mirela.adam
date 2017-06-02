using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio
    {
        static readonly Dictionary<string, Usuario> _usuarios = new Dictionary<string, Usuario>();

        public UsuarioRepositorio()
        {

        }

        public void Criar(Usuario usuario)
        {
            _usuarios.Add(usuario.Email, usuario);
        }

        public void Alterar(Usuario usuario)
        {
            _usuarios[usuario.Email] = usuario;
        }
        public void Excluir(Usuario usuario)
        {
            _usuarios[usuario.Email] = usuario;
        }

        public IEnumerable<Usuario> Listar()
        {
            return _usuarios.Select(u => u.Value);
        }

        public Usuario Obter(string email)
        {
            return _usuarios.Where(u => u.Key == email).Select(u => u.Value).FirstOrDefault();
        }
    }
}
