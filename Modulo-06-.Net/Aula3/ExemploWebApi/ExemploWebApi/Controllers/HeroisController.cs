using ExemploWebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebApi.Controllers
{
    public class HeroisController : ApiController
    {
        private static List<Heroi> ListaHerois { get; set; } = new List<Heroi>();
        private static int IdContador { get; set; } = 0;
        private static object objetoLock = new object();

        public IEnumerable<Heroi> Get(string nome=null, int? id=null)
        {         
                return ListaHerois.Where( x =>
                            (id == null || id == x.Id) &&
                            (nome == null || x.Nome == nome)
                       );
            
        }

        public IHttpActionResult Post(Heroi heroi)
        {

            if (heroi == null)
            {
                return BadRequest();
            }
            else
            {
                lock (objetoLock)
                {
                    heroi.Id = ++IdContador;
                    ListaHerois.Add(heroi);
                }
                return Ok(heroi); 
            }
        }
    }
}
