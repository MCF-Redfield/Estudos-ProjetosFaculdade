#include<stdio.h>
main(){
float bruto,inss,ir,liq,aliq;
  printf("\nDigite o valor do salario: ");
  scanf("%f",&bruto);
  printf("\nDigite o valor do inss: ");
  scanf("%f",&inss);
  printf("\nDigite o valor do imposto de renda: ");
  scanf("%f",&ir);
  liq=(bruto-(inss+ir));
  if((liq>=0)&&(liq<=900)){
    aliq=(liq*0);
    printf("\nAliquota do imposto de renda:%f",aliq);}
    else if((liq>=901)&&(liq<=5000)){
      aliq=(liq*0.05);
      printf("\nAliquota do imposto de renda:%f",aliq);}
      else if((liq>=5001)&&(liq<=10000)){
        aliq=(liq*0.1);
        printf("\nAliquota do imposto de renda:%f",aliq);}
        else if(liq>=10001){
          aliq=(liq*0.15);
          printf("\nAliquota do imposto de renda:%f",aliq);}
      getchar();
      getchar();}
