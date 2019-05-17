#include <stdio.h>
#define TAMANHO 4

char pilha[TAMANHO];
int topo=-1;
void push (char insert)
{
     if(topo>=TAMANHO-1)
     {
       printf(">>>A pilha esta cheia!<<<\n\n");
       return;
     }
     pilha[++topo]=insert;
}
int pop ()
{int i;
        return pilha[i];
}
void imprime()
{
     int i;
     printf("Pilha -> ");
     for(i=0;i<=topo;i++)
     {
      printf("%c  ",pilha[i]);
     }
     printf("\n\n");
}
main()
{
      int menu;
      char insert;
      for(;;)
      {
          printf("1-Empilhar\n2-Desempilhar\n3-Imprimir\n->");
          scanf("%d",&menu);
          if(menu==1)
          {
           printf("\nDigite o item a ser empilhado: ");
           scanf("%s",&insert);
           push(insert);
           printf("\n");
          }
          else
              if(menu==2)
              {
              pop();
              printf("\n");
              }
              else
                  if(menu==3)
                  {
                  printf("\n");
                  imprime();
                  printf("\n");
                  }
      }
getchar();
getchar();
}
