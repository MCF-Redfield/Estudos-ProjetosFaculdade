#include<stdio.h>
duken(int x,char y)
{
    int i;
    for(i=1;i<=x;i++)
    {
     putchar(y);                
    }
}
main()
{
duken(3,'m');
printf("You lose!!");
getchar();
getchar();
}
