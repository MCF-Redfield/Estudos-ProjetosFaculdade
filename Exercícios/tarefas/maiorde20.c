#include<stdio.h>
main()
{
	    int num,maior,i;
	    printf("\nDigite o numero <1>: ");
	    scanf("%d",&maior);
	    for(i=2; i<=20;i++)
	    {
	    printf("\nDigite o numero <%d>: ",i);
	    scanf("%d",&num);
	    if(num > maior)
	    {
        maior=num;
        }
		}
		printf("\n o maior numero eh: %d",maior);
		system("pause");
	    getchar();
	    getchar();
}
