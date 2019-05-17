#include<stdio.h>
int bissexto(int anno)
{
    if(anno%4==0)
    {
    printf("\nAno bissexto!");
    return 1;
    }
        else
        if(anno%4!=0) 
        printf("\nAno nao eh bissexto!");
        return 0;
}
main()
{
      int ano;
      printf("Informe o ano: ");
      scanf("%d",&ano);
      bissexto(ano);
getchar();
getchar();
}
