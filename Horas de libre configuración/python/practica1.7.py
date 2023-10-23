# La pizzería Bella Napoli ofrece pizzas vegetarianas y no vegetarianas a sus clientes. Los ingredientes para cada tipo de pizza aparecen a continuación.

# Ingredientes vegetarianos: Pimiento y tofu.
# Ingredientes no vegetarianos: Peperoni, Jamón y Salmón.

# Escribir un programa que pregunte al usuario si quiere una pizza vegetariana o no, y en función de su respuesta le muestre un menú con los ingredientes 
# disponibles para que elija. Solo se puede eligir un ingrediente además de la mozzarella y el tomate que están en todas la pizzas. Al final se debe mostrar 
# por pantalla si la pizza elegida es vegetariana o no y todos los ingredientes que lleva.

# Usad arrays para almacenar los ingredientes.

ingredientes_vegetarianos = ["pimiento", "tofu"]
ingredientes_no_vegetarianos = ["peperoni", "jamon", "salmon"]

# pedimos al usuario que nos indique que tipo de pizza quiere
eleccion = input("Quieres una pizza vegetariana (V), o una pizza no vegetariana (NV)?: ")

# determinamos segun la eleccion que opciones tiene disponible
if (eleccion == "V"):
    print("Ingredientes disponibles para la pizza vegetariana:")
    for i, ingrediente in enumerate(ingredientes_vegetarianos, 1):
        print(f"{i}. {ingrediente}")
elif (eleccion == "NV"):
    print("Ingredientes disponibles para la pizza no vegetaria:")
    for i, ingrediente in enumerate(ingredientes_no_vegetarianos, 1):
        print(f"{i}. {ingrediente}")
else:
    print("Opcion realizada no valida, por favor elija una de las opciones validas (V) o (NV)")
    
# opcion a que elija un elemento extra
if (eleccion == "V" or eleccion == "NV"):
    eleccion_ingrediente = int(input("Dime el ingredientes adicionales (numero): "))
    
    if eleccion == "V" and eleccion_ingrediente in range(1, len(ingredientes_vegetarianos) + 1):
        pizza = ingredientes_vegetarianos[eleccion_ingrediente - 1]
        es_vegetariana = True
    elif eleccion == "NV" and eleccion_ingrediente in range(1, len(ingredientes_no_vegetarianos) + 1):
        pizza = ingredientes_no_vegetarianos[eleccion_ingrediente - 1]
        es_vegetariana = False
    else:
        print("Selección de ingrediente no válida.")
        pizza = None
else:
    pizza = None

# finalmente mostramos la eleccion de la pizza
if pizza is not None:
    print(f"La pizza {'vegetariana' if es_vegetariana else 'no vegetariana'} lleva mozzarella, tomate y {pizza}.")
else:
    print("Eleccion no valida")
