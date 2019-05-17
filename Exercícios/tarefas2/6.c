#include<stdio.h>
main()
{
      float num;
      printf("Digite um numero: ");
      scanf("%f,&num");
      printf("A parte inteira desse numero eh:%d",(int)num);
      printf("A parte fracionaria desse numero eh:%d",num-((int)num));
      printf("O numero arredondado eh:%d"num-(num-((int)num)));
getchar();
getchar();
}
