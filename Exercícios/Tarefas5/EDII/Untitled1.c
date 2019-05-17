#include <stdio.h>
#include <stdlib.h>
#include<time.h>
#include <windows.h>
void shellSort(int size)
{
    int i , j , k, x=0,aux, value;
    int gap = 1;
    int vet[size];

    srand( (unsigned)time(NULL) );

    for(x=0;x<size;x++)
    {
      aux = rand();
      vet[x] = aux;
    }

    while(gap < size)
    {
        gap = 3*gap+1;
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
            }
            vet [j + gap] = value;
        }
    }
    for(k=0;k<size;k++)
    {
        printf("%d ",vet[k]);
    }
}

main()
{
shellSort(6);
getchar();
getchar();
}
