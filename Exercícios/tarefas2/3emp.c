#include<stdio.h>
main()
{
      int cod,pref,big,mini,bigg=0,exp;
      float preff=0,dell=0,expp=0,exxpp=0;
      do{
          printf("Digite o codigo da empresa:\n");
          scanf("%d",&cod);
          if(cod>0)
          {
          printf("Qual a preferencia de fabricante? <1>DELL <2>COMPAQ <3>IBM\n");
          scanf("%d",&pref);
          preff+=1;
          if(pref==1)
          dell+=1;
          printf("Possui computadores de grande porte? <1>SIM <2>NAO\n");
          scanf("%d",&big);
          if(big==1)
          bigg+=1;
          printf("Necessitam de minicomputadores? <1>SIM <2>NAO\n");
          scanf("%d",&mini);
          printf("Desejas fazer expansao? <1>SIM <4>NAO\n");
          scanf("%d",&exp);
          expp+=1;
          if(exp==1)
          exxpp+=1;
          }
        }while(cod>0);
printf("%d empresa(s) possuem computadore(s) de grande porte.\n",bigg);
printf("%f%% das empresas desejam expandir.\n",((exxpp*100)/expp));
printf("%f%% das empresas preferem DELL.\n",((dell*100)/preff));
getchar();
getchar();
}
