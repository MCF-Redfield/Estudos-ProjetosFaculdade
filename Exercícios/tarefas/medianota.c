#include<stdio.h>
main(){
float a,s,d,f,media_t;
       printf("\nDigite nota do 1º bimestre: ");
       scanf("%f",&a);
       printf("\nDigite nota do 2º bimestre: ");
       scanf("%f",&s);
       printf("\nDigite nota do 3º bimestre: ");
       scanf("%f",&d);
       printf("\nDigite nota do 4º bimestre: ");
       scanf("%f",&f);
       media_t=(a+s+d)/4;
            if(media_t>=60)
              printf("\n vc passou no 3º bimestre.Sua media foi:%f"),media_t;
            getchar();
            getchar();}
