#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main()   
{
	pid_t pid;
	int valor;
	
	printf("Introduce un valor entero: ");
	scanf("%d", &valor);
	
	pid = fork();
	
	if (pid < 0) {
		printf("No se a podido crear el hijo\n");
		return(1);
	} else if (pid == 0) {
		printf("El valor del proceso hijo original es %d\n"),
		valor += 4;
		printf("El valor del proceso hijo despues de sumar 4 es %d\n", valor);
	} else {
		printf("El valor del proceso padre original es %d\n"),
		valor -= 5;
		printf("El valor del proceso padre despues de restar 5 es %d\n", valor);
	}
	
	return 0;
}