# Dado un array tal como [15, 62, 28, 32, 44, 6], haz un archivo que realice las siguientes operaciones:

# Borrar el valor menor sin usar la función min
# Calcula el promedio del array sin usan la función promedio
# Añade ese valor en la primera posición del array

array = [15, 62, 28, 32, 44, 6] # determino el array de numeros

"""borra el valor menor"""
array.pop()  # "pop()" elimina el ultimo valor de un array

"""muestra el contenido una vez borradoo el valor"""
print(array)

"""calcular el valor promedio del array"""
suma = 0
for x in array: # recorro el array y almaceno los valores en x
    suma += x # voy sumando cada valor de la variable x a la variable suma

# almaceno en la variable promedio el resultado de dividir el total de la suma
# entre el numero total de elementos del array usando "len()"
promedio = suma / len(array) 

print(promedio)

"""añadir un valor a la ultima posicion del array"""
array.insert(6, promedio) # uso un ".insert" para introducir en la posicion 6 el valor obtenido

print(array)
