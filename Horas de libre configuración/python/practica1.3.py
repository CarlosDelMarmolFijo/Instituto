# Dado un array tal como [15, 62, 28, 32, 44, 6]

# Borrar el valor menor sin usar la función min
# Calcula el promedio del array sin usan la función promedio
# Añade ese valor en la primera posición del array

array = [15, 62, 28, 32, 44, 6]

"""borra el valor menor"""
array.pop() 

"""muestra el contenido una vez borradoo el valor"""
print(array)

"""calcular el valor promedio del array"""
suma = 0
for x in array:
    suma += x
    
promedio = suma / len(array)

print(promedio)

"""añadir un valor a la ultima posicion del array"""
array.insert(6, promedio)

print(array)
