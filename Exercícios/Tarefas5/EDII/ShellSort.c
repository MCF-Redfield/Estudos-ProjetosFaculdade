#include <stdio.h>
#include <stdlib.h>
#include<time.h>
#include <windows.h>
void shellSort(int size)
{
    int i , j , k, x=0,aux, value,cont=0;
    int gap = 1;
    int vet[size];

    time_t ini = time(0);
    srand( (unsigned)time(NULL) );

    for(x=0;x<size;x++)
    {
      aux = rand();
      vet[x] = aux;
    }

    while(gap < size)
    {
        gap = 3*gap+1;
    cont++;
    }
    while ( gap > 1)
    {
        gap /= 3;
        for(i = gap; i < size; i++)
        {
            value = vet[i];
            j = i - gap;
            while (j >= 0 && value < vet[j])
            {
                vet [j + gap] = vet[j];
                j -= gap;
                Sleep(000);
            cont++;
            }
            vet [j + gap] = value;
        cont++;
        }
    cont++;
    }
    for(k=0;k<size;k++)
    {
        printf("%d ",vet[k]);
    }
    printf("\nDuracao em seg: %d\n",time(0)-ini);
    printf("Execucoes feitas:%d\n\n\n",cont);
}

void shellSortinvertido(int size)
{
    int i , j , k, x=0,aux, value,cont=0;
    int gap = 1;
    int vet[size];

    time_t ini = time(0);
    srand( (unsigned)time(NULL) );

    for(x=0;x<size;x++)
    {
      aux = rand();
      vet[x] = aux;
    }

    while(gap < size)
    {
        gap = 3*gap+1;
    cont++;
    }
    while ( gap > 1)
    {
        gap /= 3;
        for(i = gap; i < size; i++)
        {
            value = vet[i];
            j = i - gap;
            while (j >= 0 && value > vet[j])
            {
                vet [j + gap] = vet[j];
                j -= gap;
                Sleep(000);
            cont++;
            }
            vet [j + gap] = value;
        cont++;
        }
    cont++;
    }
    for(k=0;k<size;k++)
    {
        printf("%d ",vet[k]);
    }
    printf("\nDuracao em seg: %d\n",time(0)-ini);
    printf("Execucoes feitas:%d\n\n\n",cont);
}

void shellSortateomeio(int size)
{
    int i , j , k, x=0,aux, value,cont=0;
    int gap = 1;
    int vet[size];

    time_t ini = time(0);
    srand( (unsigned)time(NULL) );

    for(x=0;x<size;x++)
    {
      aux = rand();
      vet[x] = aux;
    }

    while(gap < size)
    {
        gap = 3*gap+1;
    cont++;
    }
    while ( gap > 1)
    {
        gap /= 3;
        for(i = gap; i < size/2; i++)
        {
            value = vet[i];
            j = i - gap;
            while (j >= 0 && value < vet[j])
            {
                vet [j + gap] = vet[j];
                j -= gap;
                Sleep(000);
            cont++;
            }
            vet [j + gap] = value;
        cont++;
        }
    cont++;
    }
    for(k=0;k<size;k++)
    {
        printf("%d ",vet[k]);
    }
    printf("\nDuracao em seg: %d\n",time(0)-ini);
    printf("Execucoes feitas:%d\n\n\n",cont);
}

main()
{
shellSortinvertido(20);
shellSortinvertido(100000);
shellSort(1000000);
shellSortateomeio(1000000);
getchar();
getchar();
}
