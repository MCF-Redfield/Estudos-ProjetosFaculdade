#include<stdio.h>
#define TAM 3

typedef struct
{
  char nome[15];
  int cpf;
}Cliente;

typedef struct
{
   int numConta;
   Cliente cliente;
   float saldo;
}Conta;

void deposito(Conta *, float );
void saque(Conta *, float );
Conta confereConta(Conta *, int);

int main()
{
    int i,menu;
    float aux;
    Conta vet[TAM];
    Conta *vetPtr=vet;
    
    for(i=0;i<TAM;i++)
    {
     vet[i].numConta=1+i;
     printf("\nDigite o nome do titular da conta: ");
     scanf("%s",vet[i].cliente.nome);
     printf("Digite o CPF do titular da conta: ");
     scanf("%d",&vet[i].cliente.cpf);
     printf("Informe o valor do deposito inicial: ");
     scanf("%f",&vet[i].saldo);
    }
    while(menu)
    {
        printf("\n1-Sacar\n2-Depositar\n3-Sair\n");
        scanf("%d",&menu);
        switch(menu)
        {
        case 1: printf("Informe o valor a ser sacado: ");
                scanf("%f",&aux);
                saque(vetPtr,aux);
                break;
                
        case 2: printf("Informe o valor a ser depositado: ");
                scanf("%f",&aux);
                deposito(vetPtr,aux);
                break;
                
        case 3: exit(0);     
        }
    }
getchar();
getchar();
return 0;
}

void deposito(Conta *vetPtr, float valor)
{
     int i,numConta,aux=0;
     
     printf("Informe o numero da conta: ");
     scanf("%d",&numConta);
     for(i=0;i<TAM;i++)
     {
       if(vetPtr->numConta==numConta)
       {
        vetPtr->saldo+=valor;
        printf("\n%s   saldo:R$%.2f\n\n",vetPtr->cliente.nome,vetPtr->saldo);
       }
       aux=numConta;
     vetPtr++;
     }
     if(aux==0)
     printf("\nConta inexistente!!");
}

void saque(Conta *vetPtr, float valor)
{
     int i,numConta,aux=0;
     
     printf("Informe o numero da conta: ");
     scanf("%d",&numConta);
     for(i=0;i<TAM;i++)
     {
       if(vetPtr->numConta==numConta)
       {
         if(valor<=vetPtr->saldo)
         {
         vetPtr->saldo-=valor;
         printf("\n%s  saldo:R$%.2f\n\n",vetPtr->cliente.nome,vetPtr->saldo);
         }
         else
             {
              printf("\nValor excede o saldo\n");
             }
       aux=numConta;
       }
       vetPtr++;
     }
     if(aux==0)
     printf("\nConta inexistente!!");
}











