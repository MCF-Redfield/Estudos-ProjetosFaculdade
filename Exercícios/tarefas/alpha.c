#include<stdio.h>
#define tam 8
main()
//void selection_sort(int num[], int tam)
{
    int num[tam]={5,6,20,2,49,7,88,8};
  int i, j, min, swap;
  for (i = 0; i < tam; i++)
  {
    min = i;
    for (j = (i+1); j < tam; j++)
    {
      if(num[j] < num[min])
      {
        min = j;
      }
    }
    if (i != min)
    {
      swap = num[i];
      num[i] = num[min];
      num[min] = swap;
    }
  }
  for (i = 0; i < tam; i++)
  {
    printf("%d  ",num[i]);
}
getchar();
getchar();
}
