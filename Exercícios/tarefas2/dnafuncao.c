#include<stdio.h>
#include<string.h>
#include<stdlib.h>
char ddna(char dnaa[23])
{
     int i,j;
     for(j=0;j<23;j++)
     {
       if((dnaa[j]!='G')&&(dnaa[j]!='T')&&(dnaa[j]!='A')&&(dnaa[j]!='C')&&(dnaa[j]!='\0'))
       dnaa[j]='q';
     }
         for(i=0;i<23;i++)
         {
           if((dnaa[i]!='G')&&(dnaa[i]!='T')&&(dnaa[i]!='A')&&(dnaa[i]!='C')&&(dnaa[i]!='\0'))
           {
             printf("Nao compoe uma cadeia de DNA!\n");
             break;
           }
           else
             if((i==23)&&((dnaa[i]=='G')||(dnaa[i]=='T')||(dnaa[i]=='A')||(dnaa[i]=='C')||(dnaa[i]=='q')))
             {
                printf("Compoe uma cadeia de DNA!\n");
                break;
             }
         }
}
main()
{
      char dna[23],i;
        printf("Informe a sequencia de DNA: ");
        scanf("%s",dna);
        ddna(dna);
getchar();
getchar();
}
