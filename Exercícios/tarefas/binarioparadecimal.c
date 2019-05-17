#include<stdio.h>
main()
{
      int soma=0,i=0,vet[100];
      while(vet[i]==0||vet[i]==1)
      {
      printf("\nDigite o numero em binario: ");
      scanf("%d",&vet[i]);
      i++;
      }
      for(i=0;i=vet[i];i--)
      {
         soma=soma+(pow(2,i)*vet[i]);
      i--;
      }
      printf("\n O numero em decimal eh:%d ",soma);
getchar();
getchar();
}
