#include<stdio.h>
main()
{
   float celcius;
   printf("Digite a temperatura em Celcius: ");
   scanf("%f",&celcius);
   printf("%.2f graus Celcius corresponde a %2.f graus Fahrenheit",celcius,180*(celcius+32)/100);
getchar();
getchar();
}
