# Escribir un programa que reciba una cadena de caracteres y devuelva un diccionario con cada palabra que contiene y su frecuencia. 
# Escribir otra función que reciba el diccionario generado con la función anterior y devuelva una tupla con la palabra más repetida y su frecuencia.

# me declaro un diccionario
diccionario = {}

# determino la cadena de caracteres
cadenaTexto = "El perro de San Roque no tiene rabo porque Ramón Ramírez se lo ha cortado. El perro de Ramón Ramírez no tiene rabo porque se lo han robado."

# creo la funcion cadena al cual le paso la cadena de texto como parametro
def cadena(cadena):
    # creo una varible bloques al cual determino que es igual a la cadena separada por palabras con la funcion ".split()"
    bloques = cadena.split()

    # recorro con un for los bloques generados y los almaceno en la variable palabras
    for palabras in bloques:
        # determino que la cantidad de palabras es igual a la el recuento de las palabras de la cadena con la funcion ".count()"
        cantidadRepetida = cadena.count(palabras)
        # finalmente al diccionario le paso las palabras y este es igual al total de las palabras repetidas
        diccionario[palabras] = cantidadRepetida

# llamo a la funcion cadena y le paso la cadena de texto como parametro
cadena(cadenaTexto)
# y muestro por consola el contenido del diccionario
print(diccionario)

# palabra mas repetida determino que sea igual al maximo valor asociado dentro del diccionario es decir busca la palabra que vas veces a sido repetida
palabra_mas_repetida = max(diccionario, key=diccionario.get)
# despues de encontrar la palabra mas repetidad este es asignado al diccionario
frecuencia = diccionario[palabra_mas_repetida]

# por ultimo mostramos en consola la palabra mas repetida y la frecuencia con la que pasa
print(f"Palabra más repetida: {palabra_mas_repetida} , Frecuencia: {frecuencia}")
