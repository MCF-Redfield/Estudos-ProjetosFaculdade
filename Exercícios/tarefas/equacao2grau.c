#include<stdio.h>
main(){
float a,b,c,delta,x1,x2;
      printf("\n Digite A; ");
      scanf("%f",&a);
      printf("\n Digite B; ");
      scanf("%f",&b);
      printf("\n Digite C; ");
      scanf("%f",&c);
      delta=b*b-4*a*c;
      if(delta<0)
            printf("\n não possui raiz real");
      else
      x1=(-b-sqrt(delta))/(2*a);
      x2=(-b+sqrt(delta))/(2*a);
      printf("X¹:%f    X²:%f  ",x1,x2);
      getchar();
      getchar();}
