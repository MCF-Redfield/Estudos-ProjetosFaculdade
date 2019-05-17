#include<stdio.h>
#include<string.h>
#include<stdlib.h>
char ddna(char dnaa[10])
{
     int i;
     
     for(i=0;i<10;i++)
     {
         if((dnaa[i]!='G')&&(dnaa[i]!='T')&&(dnaa[i]!='A')&&(dnaa[i]!='C')&&(dnaa[i]!='\0'))
         {
         printf("Nao compoe uma cadeia de DNA\n");
         return 0;
         }
     }
     printf("Compoe uma cadeia de DNA\n");
}    
main()
{
      char dna[10],i;
      printf("Informe a sequencia de DNA: ");
      scanf("%s",dna);
      printf("\n\na sequencia digitada foi %s\n",dna);
      for(i=0;i<10;i++)
      {
      printf(" %c\n",dna[i]);
      }
      ddna(dna);
getchar();
getchar();
}
