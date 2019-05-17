#include<stdio.h>
#define TAM 2

typedef struct
{
 int cod;
 char nome[15];
 float preco;
}Produto;

int main()
{
  Produto vet[TAM];
  Produto *vetPtr=vet;
  int i,cod;
  
  for(i=0;i<TAM;i++)
  {
    printf("\nDigite o codigo do produto: ");
    scanf("%d",&vet[i].cod);
    printf("Digite a descricao do produto: ");
    scanf("%s",vet[i].nome);
    printf("Informe o preco do produto: ");
    scanf("%f",&vet[i].preco);
  }
  
  printf("\nCodigo\tDescricao    Preco\n");
  for(i=0;i<TAM;i++)
  {
    printf("%2.d\t%s\t    %.2f\n",vet[i].cod,vet[i].nome,vet[i].preco);
  }
  
    printf("\nDigite o codigo do produto a ser buscado: ");
    scanf("%d",&cod);
    while(buscaPreco(vetPtr,cod)==0)
    {
    printf("\nDigite o codigo do produto a ser buscado: ");
    scanf("%d",&cod);
    }
    
  
getchar();
getchar();
return 0;
}

int buscaPreco(Produto *vetPtr, int codigo)
{
    int i,back=0;
    
    for(i=0;i<TAM;i++)
    {
     if(vetPtr->cod==codigo)
     {
     back=1;
     printf("\n%d %s: R$%.2f",vetPtr->cod,vetPtr->nome,vetPtr->preco);
     }
     vetPtr++;
    }
    
  return back;
}
