#include<stdio.h>
#define TAM 10
int contador=0;
int mmenor(int m[TAM])
{
    int menor,j;
    for(j=0;j<TAM;j++)
    {
      if(j==0)
      {
        menor=m[j];
        {contador++;}
      }
      else
          if(menor<m[j])
          {
           menor=m[j];
           {contador++;}
          }
    }
    return menor;
}

int mmaior(int m[TAM])
{
    int maior,j;
    for(j=0;j<TAM;j++)
    {
      if(j==0)
      {
       maior=m[j];
       {contador++;}
      }
      else if(maior>m[j])
      {
        maior=m[j];
        {contador++;}
      }
    }
    return maior;
}

int* doMeioPraFrente(int p,int *vet)
{
    int aux,base,i,j;
    for(i=p;i<TAM;i++)
    {
       aux=i;
        for(j=i+1;j<TAM;j++)
        {
            if(vet[j]>vet[aux])
            {
            aux=j;
            {contador++;}
            }
        }

            if(i!=aux)
            {
            base = vet[i];
            vet[i] = vet[aux];
            vet[aux] = base;
            {contador++;}
            }
    }
return vet;
}

void decrescente()
{
    int vet[TAM]={5,6,9,4,2,3,7,1,10,8};
    int i,j,base,aux,maior,menor;
    menor=mmenor(vet);
    maior=mmaior(vet);
    printf("Maior elemento: %d\n",maior);
    printf("Menor elemento: %d\n",menor);
    for(i=0;i<TAM;i++)
    {
        aux=i;
        for(j=i+1;j<TAM;j++)
        {
            if(vet[j]>vet[aux])
            {
                aux=j;
            }
            {contador++;}
        }

        if(i!=aux)
        {
        base = vet[i];
        vet[i] = vet[aux];
        vet[aux] = base;
        }
        {contador++;}
    }
    for(i=0;i<TAM;i++)
    {
        printf("%d ",vet[i]);
    }
    printf("\n\n");
}

void meioemdiante()
{
    int vet[TAM]={5,6,9,4,2,3,7,1,10,8};
    int i,j,base,aux,maior,menor;
    menor=mmenor(vet);
    maior=mmaior(vet);
    printf("Maior elemento: %d\n",maior);
    printf("Menor elemento: %d\n",menor);


    for(i=0;i<TAM;i++)
    {
        aux=i;
        for(j=i+1;j<TAM;j++)
        {
            if(vet[j]<vet[aux])
            {
                aux=j;
                {contador++;}
            }

        }
        if(i>=(TAM/2))
        {
        aux=*doMeioPraFrente(i,vet);
        {contador++;}
        }
       else if(i!=aux)
            {
            base = vet[i];
            vet[i] = vet[aux];
            vet[aux] = base;
            {contador++;}
            }
    }
    for(i=0;i<TAM;i++)
    {
        printf("%d ",vet[i]);
    }
    printf("\n\n");
}

void crescente()
{
    int vet[TAM]={5,6,9,4,2,3,7,1,10,8};
    int i,j,base,aux,maior,menor;
    menor=mmenor(vet);
    maior=mmaior(vet);
    printf("Maior elemento: %d\n",maior);
    printf("Menor elemento: %d\n",menor);
    for(i=0;i<TAM;i++)
    {
        aux=i;
        for(j=i+1;j<TAM;j++)
        {
            if(vet[j]<vet[aux])
            {
                aux=j;
                {contador++;}
            }

        }

        if(i!=aux)
        {
        base = vet[i];
        vet[i] = vet[aux];
        vet[aux] = base;
        {contador++;}
        }
    }
    for(i=0;i<TAM;i++)
    {
        printf("%d ",vet[i]);
    }
    printf("\n\n");
}

main()
{
crescente();
decrescente();
meioemdiante();
printf("numero de execucoes:%d",contador);
getchar();
getchar();
}
