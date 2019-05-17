#include <stdlib.h>
#include <stdio.h>
#include <time.h>

void preencheVetor(int iNum, int *iVetor);
int main(int argc, char *argv[])
{

    int iNum, i;
    printf("Digite um numero: \n");
    scanf("%d", &iNum);
    int *iVet = (int *)malloc(sizeof(int) * iNum);
    preencheVetor(iNum, iVet);
    printf("\n");
    for (i = 0; i < iNum; i++)
        printf("\n %d ", iVet[i]);
    system("pause");

    return 0;

}

void preencheVetor(int iNum, int *iVetor) {
     int iAux, iFlag = 0,i,j;
     srand(time(NULL));
     for (i = 0; i < iNum; i++) {
          iAux = (int) rand() % 1000000;
          for (j = 0; j < i; j++) {
              if (iAux == iVetor[j])
                 iFlag = 1;
          }
     if (iFlag != 1)
        iVetor[i] = iAux;
     else
         i--;
     iFlag = 0;
     }
}
