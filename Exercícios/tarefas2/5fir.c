#include<stdio.h>
main(){
	   int sex,i,fem,sim=0,nao=0,simm=0;
	   char pdr,masc=0,man=0;
	   float por;
	   
	   for(i=0;i<10;i++)
	   {
	   	printf("Digite 1 para masculino e 2 para feminino: \n");
	   	scanf("%d",&sex);
	   	 if(sex==1)
	   	  masc+=1;
	   	   else
	   	    if(sex==2)
			 fem+=1;
	   	    
        printf("Digite S se a pessoa gostou ou N se a pessoa n gostou do produto: \n");
		scanf("%s",&pdr); 
		 if((pdr=='S')|| (pdr=='s'))
		  sim+=1;
		   else
		    if((pdr=='N') || (pdr=='n'))
		     nao+=1;
		     
		      if(sex==2 && pdr=='S' || pdr=='s')
		       simm+=1;
		       
		       if(sex==1 && (pdr=='N' || pdr=='n'))
		        man+=1;
		        
		       
	   }
		 por=((man*100)/masc);
		printf("O numero de pessoas q responderam sim foi: %d \n",sim);
		printf("O numero de pessoas q responderam nao foi: %d \n",nao);
	    printf("O numero de mulheres q responderam sim foi: %d \n",simm);
	    printf("A porcentagem de homens q respondeu nao entre todos os homens foi: %f%% \n",por);
	   
getchar();
getchar();	   
}
