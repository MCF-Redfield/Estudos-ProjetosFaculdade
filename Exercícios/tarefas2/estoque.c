#include<stdio.h>
main()
{  
   typedef struct estoque
   {
    int cod,qtde;
    char desc[40];
    float preco;
   }est;
   est prod;
       printf("Informe o numero do item: ");
       scanf("%d",&prod.cod);
       getchar();
       printf("\nInsira a descricao: ");
       gets(prod.desc);
       printf("\nDigite a qtde: ");
       scanf("%d",&prod.qtde);
       printf("\nDigite o preco: ");
       scanf("%f",&prod.preco);
       printf("\n\n\n\n\nNumero item:%d",prod.cod);
       printf("\nDescricao:%s",prod.desc);
       printf("\nQtde item:%d",prod.qtde);
       printf("\nPreco:R$%.2f",prod.preco);
   getchar();
   getchar();
}
