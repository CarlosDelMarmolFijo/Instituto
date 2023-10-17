# Escribir un programa que pida al usuario dos números y muestre por pantalla su división. Si el divisor es cero el programa debe mostrar un error.

"""pido los dos numeros el dividendo y divisor por consola"""
dividendo = float(input('Introduce el dividendo: '))
divisor = float(input('Introduce el divisor: '))

"""determino que si el divisor es igual a 0"""
if divisor == 0:
    print('Error, no se puede hacer una divicion por 0')
else:
    """declaro una variable donde almaceno el resultado de la division"""
    resultado = dividendo / divisor
    """la muestro por consola"""
    print(f'El resultado es: {resultado}')
