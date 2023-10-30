# Escribir un programa que pida al usuario un número entero positivo y muestre por pantalla la cuenta atrás desde ese número hasta cero separados por comas.

# pido por consola el numero entero al usuario
numero = int(input("dime un numero entero: "))

# controlo con un if que el numero introducido no sea menor a 0
# si es asi este mostrara un error

if numero < 0:
    print("numero introducido incorrecto")
else:
    # sino ejecuto un bucle while mientras el numero sea mayor o igual a 0
    while numero >= 0:
        # si el numero es mayor a 0
        if (numero > 0):
            # imprimo los numeros y le añado con "end=","" una separarcion con coma a los numeros mostrados
            print(numero, end=", ")
        else:
            # sino los numeros se mostraran sin la separacion de la coma
            print(numero, end="")
        # cada vez que ejecute el codigo este reducira en uno el numero hasta llegar a 0
        numero -= 1