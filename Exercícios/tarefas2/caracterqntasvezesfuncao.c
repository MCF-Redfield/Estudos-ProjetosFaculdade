#include<stdio.h>
int caracter(char caracteres[101] ,char digitado)
{
    int i,vezes=0;
    for(i=0;i<101;i++)
    {
      if(caracteres[i]==digitado)
      vezes+=1;
    }
    printf("O digito \"%c\" aparaceu %d vezes entre os caracteres digitados",digitado,vezes);
}
main()
{
      char carac[101],dig;
      printf("Digite caracteres: \n");
      scanf("%s",&carac[1]);
      printf("Digito q desejas saber qntas vezes apareceu: \n");
      scanf("%s",&dig);
      caracter(carac,dig);     
getchar();
getchar();
}
