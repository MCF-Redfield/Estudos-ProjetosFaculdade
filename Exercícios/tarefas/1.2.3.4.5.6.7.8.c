#include<stdio.h>
#define TAM 10

main()
{
    int vet[TAM]={5,6,9,4,2,3,7,1,10,8};
    int i,j,menor,aux;

    for(i=0;i<TAM;i++)
    {
        aux=i;
        for(j=i+1;j<TAM;j++)
        {
            if(vet[j]<vet[aux])
            {
                aux=j;
            }
        }

        if(i!=aux)
        {
        menor = vet[i];
        vet[i] = vet[aux];
        vet[aux] = menor;
        }
    }
    for(i=0;i<TAM;i++)
    {
        printf("%d ",vet[i]);
    }

getchar();
getchar();
}
