#include<stdio.h>
void imprimir(int x[],int n)
{
     //int n=sizeof(x)/sizeof(int);
     int i;
     for(i=0; i<n;i++)
     {
       printf("%d  ",x[i]);
     }
     printf("\n");
}

void insertionSort(int numeros[], int tam) 
{
   int i, j, eleito;
   for (i = 1; i < tam; i++)
   {
      eleito = numeros[i];
      j = i - 1;
      imprimir(numeros,12);
      while ((j>=0) && (eleito < numeros[j]))
      {
         numeros[j+1] = numeros[j];
         j--;
         imprimir(numeros,12);
      }
      
      numeros[j+1] = eleito;
   }
   
}

main()
{
  int vet[]={50, 32, 23, 20, 12, 10, 40, 18, 23, 14, 07, 34};
  insertionSort(vet,12);

  getchar();
  getchar();
}
