#include<stdio.h>
#define max 100
int main(){
    char string1[max],string2[max];
    int tam,i,y=0;
    printf("\nSTRING1->");
    gets(string1);
    tam=strlen(string1);
    printf("%d caracteres digitados\n",tam);
    for(i=tam-1;i>=0;i--){
    string2[y]=string1[i];
    y++;
    }
    string2[y]=0;
    printf("STRING2->%s",string2);
    getch();
    return 0;
}
