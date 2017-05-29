using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text.RegularExpressions;
using System.Web.Http;
using Chat.Models;

namespace Chat.Controllers
{
    public class MensagensController : ApiController
    {
        private static List<Mensagem> mensagens = new List<Mensagem>();
        private static int contador = 0;
        private static object @lock = new object();

        public IEnumerable<Mensagem> Get()
        {
            return mensagens;
        }

        public IHttpActionResult Post(Mensagem msg)
        {
            if (msg == null)
            {
                return BadRequest();
            }
            else
            {
                lock (@lock)
                {

                    Regex rgNunes = new Regex("nunes", RegexOptions.IgnoreCase);
                    msg.Texto = rgNunes.Replace(msg.Texto, "$$$$$ $$$$$");

                    mensagens.Add(msg);
                    msg.Id = ++contador;
                    msg.Data = DateTime.Now;
                    return Ok(msg);
                }
            }
        }
    }
}
