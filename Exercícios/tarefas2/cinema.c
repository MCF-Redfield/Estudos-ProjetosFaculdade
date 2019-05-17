#include<stdio.h>
main()
{
      int i,id,op,reg=0;
      float perc=0,otimo=0,tid=0,bom=0;
      for(i=0;i<15;i++)
      {
      printf("Qual a sua idade?\n");
      scanf("%d",&id);
      printf("O que voce achou do filme? <3>Otimo <2>Bom <1>Regular\n");
      scanf("%d",&op);
      if(op==3)
      {
      otimo=otimo+1;
      tid+=id;
      }else
           if(op==1)
           {
           reg+=1;
           }
           else
               if(op==2)
               bom+=1;
      }
      perc=((bom*100)/15);
      printf("\n\nA media da idade das pessoas que responderam otimo eh %f!\n\n",tid/otimo);
      printf("%d pessoa(s) responderam regular!\n\n",reg);
      printf("%f%% dos espectadores acharam o filme bom!\n\n",perc);
getchar();
getchar();
}
