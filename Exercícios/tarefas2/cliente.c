#include<stdio.h>
#include<string.h>
#include<strings.h>
main()
{
      typedef struct cliente
      {
      char nome[30];
      int tel;
      char end[40];
      struct data
             {
             int dia;
             int mes;
             int ano;
             }date;
      char mail[50];
      }cliente;
      cliente clt;
        printf("Nome do cliente: ");
        gets(clt.nome);
        printf("Telefone: ");
        scanf("%d",&clt.tel);
        getchar();
        printf("Informe o endereco: ");
        gets(clt.end);
        printf("Informe a data de nascimento dd-mm-aaa: ");
        scanf("%d-%d-%d",&clt.date.dia,&clt.date.mes,&clt.date.ano);
        getchar();
        printf("Digite o e-mail: ");
        gets(clt.mail);
        
        
        printf("\n\n\n\n\nNome:%s\nData nasc.:%d-%d-%d\n",clt.nome,clt.date.dia,clt.date.mes,clt.date.ano);
        printf("Endereco:%s\nFone:%d\nE-mail:%s",clt.end,clt.tel,clt.mail);
getchar();
getchar();
}
