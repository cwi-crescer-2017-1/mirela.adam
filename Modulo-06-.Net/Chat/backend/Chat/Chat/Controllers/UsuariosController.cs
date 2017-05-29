using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Chat.Models;

namespace Chat.Controllers
{
    public class UsuariosController : ApiController
    {
        public static List<Usuario> usuarios = new List<Usuario>();
        private object @lock = new object();
        private static int contador = 0;

        public IEnumerable<Usuario> Get()
        {
            return usuarios;
        }

        public IHttpActionResult Post(Usuario usuario)
        {
            if (usuario == null)
            {
                return BadRequest();
            }
            else
            {
                lock (@lock)
                {
                    usuarios.Add(usuario);
                    usuario.Id = ++contador;
                    return Ok(usuario);
                }
            }
        }
    }
}
