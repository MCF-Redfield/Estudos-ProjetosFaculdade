#include<stdio.h>
main()
{
    int num;
    do{
        printf("Digite um numero: ");
        scanf("%d",&num);
      }while(num<1||num>100);
      printf("Este numero esta entre 1 e 100!");
getchar();
getchar();
}
