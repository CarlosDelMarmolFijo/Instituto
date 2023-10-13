using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2DAM_Ejemplos
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // mostrar contenido de variable
            string nombre = "carlos";
            Console.WriteLine("Hola " + nombre);

            // escritura por teclado
            Console.WriteLine("\nIntroduzca su edad:");
            // uso del metodo "ToInt32" para poder hacer un parceo del numero
            int edad = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Tu edad es " + edad);

            // operadores logicos uso de la clase "MATH"
            int numero1, numero2, numero3;
            double numero4;

            numero1 = 5;
            numero2 = 64;
            numero3 = -15;
            numero4 = 9.99;

            Console.WriteLine("\nEl máximo de los dos números es: " + Math.Max(numero1, numero2));
            Console.WriteLine("El minimo de los dos números es: " + Math.Min(numero1, numero2));
            Console.WriteLine("La raiz cuadrada del segundo número es: " + Math.Sqrt(numero2));
            Console.WriteLine("El valor absoluto del tecer numero es: " + Math.Abs(numero3));
            Console.WriteLine("El valor aproximado de numero4 es: " + Math.Round(numero4));

            // strings
            string texto = "Hola mundo";
                // .Length nos permite obtener la longitud de una cadena
                // tambien podemos concatenar cadenas usando el operador "+" o el metodo "Concat()"
            Console.WriteLine("\nLa longitud del string es: " + texto.Length);
        }
    }
}
