#include<stdio.h>
#include<stdlib.h>
#define TAMANHO 10


void insertionSortD(int array[], int tamanho)
{
      int i, j, tmp;
      for (i=1;i<tamanho;i++)
      {
            j=i;
            while(j>0&&array[j-1]<array[j])
            {
                  tmp=array[j];
                  array[j]=array[j-1];
                  array[j-1]=tmp;
                  j--;
            }
      }
}

void insertionSortC(int array[], int tamanho)
{
      int i,j,tmp;
      for (i=1;i<tamanho;i++)
      {
            j=i;
            while(j>0&&array[j-1]>array[j])
            {
                  tmp=array[j];
                  array[j]=array[j-1];
                  array[j-1]=tmp;
                  j--;
            }
      }
}

int* doMeioPraFrente(int p,int *vet)
{
    int aux,menor,i,j;
    for(i=p;i<TAMANHO;i++)
    {
       aux=i;
        for(j=i+1;j<TAMANHO;j++)
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

int main()
{
	int maior1=0,menor1=0;
	int maior2=0,menor2=0;
	int maior3=0,menor3=0;
	int contador=0;
	int contador2=0;
	int contador3=0;
	int array[TAMANHO], tamanho, ordem;
	int vet[TAMANHO]={5,6,9,4,2,3,7,1,10,8};
    int i,j,menor,aux;

for(i=0;i<TAMANHO;i++)
{
    	printf("\n\n\tDigite o elemento %d° : ",i+1);
      	scanf("%d",&array[i]);

	if(array[i]<menor1)
	{
	  menor1 = array[i];
	}
	 else if(array[i]>maior1)
	 {
	   maior1 = array[i];
     }
        contador++;
}


   insertionSortC(array,TAMANHO);
      printf("\n Vetor crescente: ");
      for(i=0; i<TAMANHO; i++)
	  {
      printf("\n\t\t\t%d", array[ i ]);
      }

    printf("\n\n O menor elemento do vetor : %d\t", menor1);
	printf("\n\n O maior elemento do vetor : %d\t", maior1);
	printf("\n\n\t   CONTADOR: %d ",contador);
    printf("\n\n\tFinal da primeira execução");


   for(i=0;i<TAMANHO;i++)
   {
      printf("\n\n\tDigite o elemento %d° : ",i+1);
      scanf("%d",&array[ i ]);
      if(array[i]==0)
      {
    	menor1=array[i];
    	maior1=array[i];
      }
      else if(array[i]<menor2)
      {
		menor2 = array[i];
      }
           else if(array[i]>maior2)
           {
            maior2 = array[i];
           }
      contador2++;

  }

  insertionSortD(array,TAMANHO);
   printf("\n Vetor descresente: ");

   for(i=0; i<TAMANHO; i++)
   {
      printf("\n\t\t\t%d", array[ i ]);
      contador2++;
   }
	printf("\n\n O menor elemento do vetor: %d\t", menor2);
	printf("\n\n O maior elemento do vetor: %d\t", maior2);
    printf("\n\n\t   CONTADOR: %d   ",contador2);
	printf("\nfIM DA SEGUNDA EXECUCAO");
//pueblo
    for(i=0;i<TAMANHO;i++)
    {
        aux=i;
        for(j=i+1;j<TAMANHO;j++)
        {
            if(vet[j]<vet[aux])
            {
                aux=j;
            }
        }
        if(i>=(TAMANHO/2))
        {
        aux=*doMeioPraFrente(i,vet);
        }
       else if(i!=aux)
            {
            menor = vet[i];
            vet[i] = vet[aux];
            vet[aux] = menor;
            }
            contador3++;
    }
    for(i=0;i<TAMANHO;i++)
    {
        printf("\n%d ",vet[i]);
    }
getchar();
getchar();
}
