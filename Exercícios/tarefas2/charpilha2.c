#include <stdio.h>
#define TAMANHO 10

char pilha[TAMANHO];
int topo=-1;
void push (char insert)
{
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
     printf("Pilha ->                ");
     for(i=0;i<=topo;i++)
     {
      printf("%c  ",pilha[i]);
     }
     printf("\n\n");
}
main()
{
      int menu,i;
      char insert,exp[10];
      printf("Informe a expressao: ");
      gets(exp);
      for(i=0;i<30;i++)
      {
          if((exp[i]!='{')&&(exp[i]!='}')&&(exp[i]!='[')&&(exp[i]!=']')&&(exp!='(')&&(exp[i]!=')'))
          exp[i]=' ';
          else
          push(exp[i]);

      }
      printf("\n");
        imprime();
        printf("\n");
getchar();
getchar();
}
