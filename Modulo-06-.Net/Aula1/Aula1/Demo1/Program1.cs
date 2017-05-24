using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class Program1
    {
        static void Main (string[] args)
        {
            Console.WriteLine("Informe seu peso: ");
            var entradaPeso = Console.ReadLine();

            //var peso = double.Parse(entradaPeso);
            //double peso = 0;
            var peso = 0D;
            if (!double.TryParse(entradaPeso, out peso))
            {
                Console.WriteLine("Entrada inválida");
            }

            Console.WriteLine("Informe sua altura: ");
            var entradaAltura = Console.ReadLine();
            
            var altura = double.Parse(entradaAltura);

            var calculoIMC = new CalculoIMC(altura, peso);
            var imc = calculoIMC.CalcularIMC();

            Console.WriteLine($"Seu IMC: {imc}");
            Console.ReadKey();
        }
    }
}
