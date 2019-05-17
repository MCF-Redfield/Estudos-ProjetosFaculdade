#include<stdio.h>
main()
{
   int b_maior, b_menor, h;
   printf("Base maior eh:");
   scanf("%d",&b_maior);
   printf("Base menor eh:");
   scanf("%d",&b_menor);
   printf("A altura eh:");
   scanf("%d",&h);
   printf("A area do trapezio eh:%d",(((b_maior+b_menor)*h)/2));
getchar();
getchar();
}
