# Escribir un programa que almacene la cadena de caracteres contraseña en una variable, 
# pregunte al usuario por la contraseña e imprima por pantalla si la contraseña introducida por el usuario coincide 
# con la guardada en la variable sin tener en cuenta mayúsculas y minúsculas.

"""almaceno en la variable "contreseña" la contraseña correcta"""
contraseña = 'password'

"""pido la contraseña por consola"""
contraseña_usuario = input('dime la contraseña ')

"""mediante un if determino que si la contraseña es igual a la contraseña correcta almacenada"""
if (contraseña_usuario == contraseña):
     print('contraseña correcta')
else:
    print('contraseña incorrecta')
    
""" mismo ejercicio pero echo con un bucle while"""
# while (contraseña_usuario != contraseña):
#     respuesta = input("Contraseña incorrecta ¿Quieres intentarlo nuevamente? (si/no)")
#     if (respuesta == "si"):
#         password = input("Ingrese la contraseña")
#         if (password == contraseña):
#             print("Contraseña correcta felicidades")
#             break
#     else:
#         break