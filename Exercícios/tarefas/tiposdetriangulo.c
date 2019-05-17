#include<stdio.h>
main(){
float x1,x2,x3;
printf("\n Digite o lado 1: ");
scanf("%f",&x1);
printf("\n Digite o lado 2: ");
scanf("%f",&x2);
printf("\n Digite o lado 3: ");
scanf("%f",&x3);
if(x1<(x2+x3)&&x2<(x1+x3)&&x3<(x1+x2)){
if(x1==x2&&x2==x3&&x3==x1)
     printf("\n eh um triangulo equilatero");
else if((x1!=x2)&&(x1!=x3)&&(x3!=x2))
          printf("\n eh um triangulo escaleno");
     else 
          printf("\n eh um triangulo isoceles");}
else
        printf("\nNao constituem os lados de um triangulo");
       getchar();
       getchar();}
