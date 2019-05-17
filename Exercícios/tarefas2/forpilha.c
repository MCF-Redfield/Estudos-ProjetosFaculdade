#include <stdio.h>
#define TAMANHO 4

float pilha[TAMANHO];
int topo=-1;
void push (float insert)
{
     if(topo>=TAMANHO-1)
     {
       printf(">>>A pilha esta cheia!<<<\n\n");
       return;
     }
     pilha[++topo]=insert;
}
int pop ()
{
    if(topo<0)
    {
      printf("\n>>>Pilha esta vazia!<<<\n");
      return 0;
    }
    else
    return pilha[topo--];
}
void imprime()
{
     int i;
     printf("Pilha -> ");
     for(i=0;i<=topo;i++)
     {
      printf("%.2f  ",pilha[i]);
     }
     printf("\n\n");
}
main()
{
      float menu,insert;
      for(;;)
      {
          printf("1-Empilhar\n2-Desempilhar\n3-Imprimir\n->");
          scanf("%f",&menu);
          if(menu==1)
          {
           printf("\nDigite o item a ser empilhado: ");
           scanf("%f",&insert);
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
