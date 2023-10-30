# Escribir un programa que pregunte al usuario una cantidad a invertir, el interés anual y el número de años, 
# y muestre por pantalla el capital obtenido en la inversión cada año que dura la inversión.

# pido por consola los valores al usuario
cantidad_invertir = float(input("dime la cantidad a invertir "))
interes_anual = float(input("dime el porcentaje de interes anual "))
numero_anios = int(input("dime el numero de años "))

# calculo la tasa de interes decimal dividiendo el interes anual entre 100
tasa_interes_decimal = interes_anual / 100

# uso un bucle for para ir recorriendo los años y de esta forma calcular el capital obtenido por año
# ese bucle empiza en uno y va incrementando hasta incluir el numero introducido nosotros por consola
for anio in range(1, numero_anios + 1):
    # determino que la variable capita_obtenido es el resultado de multiplicar la cantidad a invertir por la tasa de interes decimal por año
    capital_obtenido = cantidad_invertir * (1 + tasa_interes_decimal) * anio
    # finalmente mostramos para cada año el capital obtenido usando en este :.2f para que el resultado salga con dos decimales
    print(f"Año {anio}: Capital obtenido = {capital_obtenido:.2f} €")

# calculo el capital total que en este caso es la cantidad a invertir por la tasa de interes decimal por el numero de años
capital_total = cantidad_invertir * (1 + tasa_interes_decimal) * numero_anios

# una vez obtenido todos los datos lo muestro por consola usando al igual que antes :.2f para que el resultado salga con dos decimales
print(f"\nCapital total después de {numero_anios} años = {capital_total:.2f} €")
