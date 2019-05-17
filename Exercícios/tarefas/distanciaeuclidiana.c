#include<stdio.h>
main(){
float x1,x2,y1,y2,euc;
      printf("\nDigite X1: ");
      scanf("%f",&x1);
      printf("\nDigite Y1: ");
      scanf("%f",&y1);
      printf("\nDigite X2: ");
      scanf("%f",&x2);
      printf("\nDigite Y2: ");
      scanf("%f",&y2);
      euc=((pow((x1-x2),2))+(pow((y2-y1),2)));
      euc=sqrt(euc);
           printf("\nDistancia:%f",euc);
           getchar();
           getchar();}
