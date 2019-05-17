#include<stdio.h>
#include<string.h>
char *strrchr1(char *str, char ch)
{
    int i;
    char *ptr=NULL;
    for(i=0; str[i]!='\0';i++)
    {
        if(str[i]==ch)
        {
          ptr=&str[i];
          return ptr;
        }
    }
}
main()
{
    char nome[100], *sobrenome;
    printf("Digite uma string: ");
    gets(nome);
    sobrenome=strrchr(nome,' ');
    if(sobrenome==NULL)
    {
      sobrenome=nome;
      printf("Nao tem sobrenome.\n");
    }
    else
        sobrenome--;
        puts(sobrenome);
getchar();
getchar();
}
