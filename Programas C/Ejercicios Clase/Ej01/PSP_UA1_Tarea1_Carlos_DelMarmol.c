#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main()   
{
	pid_t pid;
	int valor;
	
	printf("Introduce un valor entero: ");
	scanf("%d", &valor); // almaceno el valor introducido en la variable "valor"
	
	pid = fork(); // pongo en marchar un nuevo proceso con fork
	
	if (pid < 0) { // si el valor del pid es menor a 0
		printf("No se a podido crear el hijo\n"); //muestro este mensaje
		return(1); // y devolvemos 1
	} else if (pid == 0) { // en caso de ser igual a 0
		printf("El valor del proceso hijo original es %d\n"),
		valor += 4; // sumo 4 al valor inicial
		printf("El valor del proceso hijo despues de sumar 4 es %d\n", valor);
	} else { 
		printf("El valor del proceso padre original es %d\n"),
		valor -= 5; // sino se cumplen ninguna de las anteriores resto 5 al valor inicial
		printf("El valor del proceso padre despues de restar 5 es %d\n", valor);
	}
	
	return 0;
}
