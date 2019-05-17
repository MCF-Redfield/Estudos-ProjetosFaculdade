#include<stdio.h>
#include<stdlib.h>

void  buble_sort(int x[],int n){
      printf("Entrei no bubble sort");
      int k;
      int i;
      int j;
      int aux = 0;
      //int n = sizeof(x)/sizeof(int);
      //printf("\n%d", n);
      k = n-1;

      for(i = 0; i < n; i++){
            for(j = 0; j < k; j++)
            {
                  if( x[j] > x[j+1] )
                  {
                     aux = x[j];
                     x[j] = x[j+1];
                     x[j+1] = aux;

                  }
            }
      }
}


void imprimir(int x[],int n)
{
     //int n=sizeof(x)/sizeof(int);
     int i;
     for(i=0; i<n;i++)
     {
       printf("\n%d",x[i]);
     }
}



int main(){
    int x[5]={5,4,3,1,2};
    int n = sizeof(x) / sizeof(int);
    buble_sort(x,n);
    imprimir(x,n);
    getchar();
    getchar();
    return 0;
}
