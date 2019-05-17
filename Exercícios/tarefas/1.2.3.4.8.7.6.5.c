#include<stdio.h>
#define TAM 10

int* doMeioPraFrente(int p,int *vet)
{
    int aux,menor,i,j;
    for(i=p;i<TAM;i++)
    {
       aux=i;
        for(j=i+1;j<TAM;j++)
        {
            if(vet[j]>vet[aux])
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
return vet;
}


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
        if(i>=(TAM/2))
        {
        aux=*doMeioPraFrente(i,vet);
        }
       else if(i!=aux)
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
