# Para tributar un determinado impuesto se debe ser mayor de 16 años y tener unos ingresos iguales o superiores a 1000 € mensuales. 
# Escribir un programa que pregunte al usuario su edad y sus ingresos mensuales y muestre por pantalla si el usuario tiene que tributar o no.

"""pido la edad por consola y la almaceno en una varible"""
edad = int(input("Dime la edad: "))

"""pido tambien los ingresos mensuales y los almaceno en una varible"""
ingresos_mensuales = float(input("Dime los ingresos mensuales: "))

"""determino con un condicional if que si la edad es mayor a 16 y los ingresos son mayores o igual a 1000"""
if (edad > 16 and ingresos_mensuales >= 1000):
    print("Tienes que tributar")
else:
    print("No tienes que tributar")
