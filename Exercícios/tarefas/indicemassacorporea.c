#include<stdio.h>
main(){
float alt,peso,imc;
printf("\nDigite seu peso em Kg: ");
scanf("%f",&peso);
printf("\nDigite sua altura em metros: ");
scanf("%f",&alt);
imc=(peso/(alt*alt));
printf("\nSeu indice de massa corporea:%f",imc);
getchar();
getchar();}
