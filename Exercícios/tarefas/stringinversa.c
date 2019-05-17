#include<string.h>
int main(){
    char string1[30],string2[30];
    int tam,i,y=0;
    printf("\nString: ");
    gets(string1);
    tam=strlen(string1);
    for(i=tam-1;i>=0;i--){
    string2[y]=string1[i];
    y++;
    }
    string2[y]=0;
    printf("String invertida:%s",string2);
    getchar();
    getchar();}
