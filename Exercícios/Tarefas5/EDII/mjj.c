#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <conio.h>
main(){

int menu,a,b,c,menu2;


printf("Digite sua opçao: 1 para usar a calculadora , 2 para verificaçao de triangulo ");
scanf("%d",&menu);

  switch(menu)
   case 1: {  printf("\nDigite a operacao:");
               scanf("%d",menu2);
                printf("Digite o 1 numero: ");
                scanf("%d",&a);
                printf("Digite o 2 numero: ");
                scanf("%d",&b);

                switch (menu2)
                case 1: {printf("O resultado de %d + %d  eh: %d",a,b,a+b);
                             break;

                }

                 case 2: {printf("O resultado de %d - %d  eh: %d",a,b,a-b);
                             break;
                 }
                 case 3: {printf("O resultado de %d * %d  eh: %d",a,b,a*b);
                             break;
                 }
                  case 4:{ printf("O resultado de %d dividido %d  eh: %d",a,b,a/b);
                             break;
                  }
                    case 5: {printf("O resultado de %d ^ %d  eh: %d",a,b,pow(a,b));
                                   break;
                    }
   }





getchar();
getchar();
}
