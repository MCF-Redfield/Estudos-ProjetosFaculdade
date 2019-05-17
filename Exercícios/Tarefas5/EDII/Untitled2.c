#include <stdio.h>
#include <stdlib.h>
#define TAM 10
#include<time.h>
#include <windows.h>
main()
{
int x,vet[20],aux;
srand( (unsigned)time(NULL) );

    for(x=0;x<TAM;x++)
    {
      aux = rand();
      vet[x] = aux;
    }
}
