#include<stdio.h>
#define TAM 40
int contador=0;
int buscaBinRec(int vetor[],int ini,int fim,int pesq)
{
     while(ini<=fim)
     {
         contador++;
          int meio;
          meio=(ini+fim)/2;

          if(vetor[meio]==pesq)
          {
            return meio;
          }
          else if (vetor[meio]<pesq)
                 {
                   return buscaBinRec(vetor,meio+1,fim,pesq);
                 }
                 else
                 {
                   return buscaBinRec(vetor,ini,meio-1,pesq);
                 }
     }
     return -1;

}
int main (void)
{
 int i,vetor_tst[TAM],fun,x;
 for(i=0;i<TAM;i++)
 {
     vetor_tst[i]=i+1;
 }
 x=vetor_tst[];
 fun=buscaBinRec(vetor_tst,0,TAM-1,x);
 printf("%d",fun);
 printf("\n\n");
 printf("Numero de comparacoes: %d",contador);
 return 0;
}
