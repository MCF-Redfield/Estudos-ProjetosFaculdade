#include<stdio.h>
#include<string.h>
int strend(char *s, char *t)
{
 int i;
 for(i=0;i<10;i++)
 {
     if(s[i]==*t)
     printf("\n O final eh igual ");
 }





}
int main()
{
	int i,j,confere;
	char s[10], t[3];
	printf("Informe a palavra: ");
	gets(s);
	printf("\nInforme o trecho a ser conferido: ");
	gets(t);
	confere=strend(s,t);
getchar();
getchar();
}
