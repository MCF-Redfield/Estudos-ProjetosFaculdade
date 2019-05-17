#include<stdio.h>
main(){
float a11,a12,a21,a22,det;
printf("\nDigite A11: ");
scanf("%f",&a11);
printf("\nDigite A12: ");
scanf("%f",&a12);
printf("\nDigite A21: ");
scanf("%f",&a21);
printf("\nDigite A22: ");
scanf("%f",&a22);
det=((a11*a22)-(a12*a21));
    printf("\nDeterminante:%f",det);
        if(det==(a11*a22)){
        printf("\neh uma matriz triangular");}
        else {printf("\nnao eh uma matriz triangular");}
     getchar();
     getchar();}
