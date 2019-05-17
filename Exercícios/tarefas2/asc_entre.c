#include<stdio.h>
main()
{
   int i,min,max,n;
   do
   {
       printf("Digite um numero de 0 a 255: ");
       scanf("%d",&min);
   }
   while((min<0)||(min>255));
   do
       {
       printf("Digite outro numero de 0 a 255: ");
       scanf("%d",&max);
       }
   while((max<0)||(max>255));
   if(min>max)
   {
      n=min;
      min=max;
      max=n;
      for(i=min;i<=max;i++)
   {
   printf("%d = %c\n",i,(char)i);
   }
   }
   else
   {
   for(i=min;i<=max;i++)
   {
   printf("%d = %c\n",i,(char)i);
   }
   }
getchar();
getchar();
}
