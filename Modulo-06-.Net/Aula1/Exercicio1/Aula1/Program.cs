using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aula1
{
    class Program
    {
        static void Main(string[] args)
        {

            //var entradas = new int[] { };
            List<int> entradas = new List<int>();

            Console.WriteLine("Digite numeros inteiros valor (exit para sair): ");
            while (true)
            {
                var entrada = Console.ReadLine();
                if (entrada == "exit")
                {
                    foreach (var item in entradas)
                    {
                        Console.WriteLine(item);
                    }

                    Console.ReadKey();
                    return;
                }

                entradas.Add(int.Parse(entrada));

            }

            /*
            while(true){
                var linhaLida = Console.ReadLine();
                if(linhaLida == "exit")
                {
                    break;    
                } 

                var nrEntradas = entradas.Length;
                var entradasAux = new int[nrEntradas + 1];
                for (int i = 0; i<nrEntradas; i++)
                {
                    entradasAux[i] = entradas[i];
                }
                entradasAux[nrEntradas] = int.Parse(linhaLida);
                entradas = entradasAux;
            }          
            
            foreach (var entrada in entradas) 
            {
                Console.WriteLine(entrada);
            } 
            */
        }
    }
}
