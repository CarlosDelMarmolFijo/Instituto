# pido la edad al usuario
edad = int(input("dime tu edad: "))

# determino que si la edad es menor a 0 me salte un mensaje de error
if (edad <= 0) :
    print("error edad introducida incorrecta")
else:
    # sino muestro los años cumplidos
    print("as cumplido estos años")
    # el bucle me recorre desde el uno hasta el año que le e indicado sumando uno cada vez
    for i in range(1, edad + 1):
        print(i)