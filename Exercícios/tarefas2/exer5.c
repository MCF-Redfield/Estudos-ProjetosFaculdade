#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int i=0;
typedef struct bike
{
  int cod;
  char marca[20];
  float peso;
  struct bike* prox;
}Bike;

typedef struct aluguel
{
  char nome[20];
  Bike cod_bike;
  struct aluguel* prox;
}Aluguel;

Bike* inicializa (void)
{
  return NULL;
}

Bike* criaBike (int cd)
{
  Bike* novo = (Bike*) malloc(sizeof(Bike));

  if (novo == NULL)
  {
    printf("Erro! Falta de memoria");
    exit(0);
  }
     else
     {
      novo->cod = cd;
      getchar();
      printf("\nDigite a marca da bicicleta: ");
      gets(novo->marca);
      printf("Informe o peso suportado pela bike: ");
      scanf("%f",&novo->peso);
      novo->prox = NULL;
     }
  return novo;
}

Aluguel* criaAluguel ()
{
  Aluguel* novo = (Aluguel*) malloc(sizeof(Aluguel));

  if (novo == NULL)
  {
    printf("Erro! Falta de memoria");
    exit(0);
  }
     else
     {
      getchar();
      printf("\nDigite o nome do cliente: ");
      gets(novo->nome);
      printf("Informe o codigo da bike: ");
      scanf("%d",&novo->cod_bike);
      novo->prox = NULL;
     }
  return novo;
}

Bike* insereInicio (Bike* l, int cd)
{
  Bike* aux;
  Bike* novo = criaBike(cd);

  if (l == NULL)
  {
    l = novo;
  }
  else
  {
  aux=l;
     while (aux->prox != NULL)
     {
      aux = aux->prox;
     }
     aux->prox=novo;
  }
  return novo;
}

Bike* remover (Bike* l, int chave)
{

  Bike* ant = NULL;
  Bike* aux = l;


  while (aux != NULL && aux->cod != chave)
  {
    ant = aux;
    aux = aux->prox;
  }


  if (aux == NULL)
  {
    printf("\nElemento %i nao pertence a lista!!!", chave);
  }
    else if (ant == NULL)
      {
       l = aux->prox;
      }
        else
        {
          ant->prox= aux->prox;
        }

  free(aux);

  return l;
}

Aluguel* insereAluguelFim (Aluguel* k)
{
  Aluguel* aux;
  Aluguel* novo = criaAluguel();

  if (k == NULL)
  {
    k = novo;
  }
  else
  {
  aux=k;
     while (aux->prox != NULL)
     {
      aux = aux->prox;
     }
     aux->prox=novo;
  }
  return k;
}
void imprime (Bike* l)
{
  Bike* aux;

  if( vazia(l) ){
    printf("Vazio");
  }
  else{

    aux = l;
    while (aux != NULL){
      printf(" %s %d  %f\n",aux->marca,aux->cod,aux->peso);
      aux = aux->prox;
    }
  }
}

int vazia (Bike* l)
{
  if (l == NULL)
    return 1;
  else
    return 0;
}

int main ()
{
  Bike* l;
  Aluguel* k;
  int cd,menu,cdrem;
  l = inicializa();
  k = inicializa();
  printf("1-Cadastrar bicicletas\n2-Remover cadastro da bicicleta\n3-Cadastrar os Alugueis|Cliente\n4-Remover aluguel\n0-Imprimir\n");
for(;;)
{
    cd=i++;
	printf("\nDigite sua opcao: ");
	scanf("%d",&menu);
	 if(menu==1)
	 {
	    l = insereInicio(l,cd);
	 }
      if(menu==2)
      {
		  printf("Digite o codigo da bicicleta para ser removida: ");
		  scanf("%d",&cdrem);
		  remover(l,cdrem);
	  }
	   if(menu==3)
	   {
         k=insereAluguelFim(k);
	   }
	    if(menu==4)
	    {
		}
		 if(menu==0)

		 imprime(l);

}

 getchar();
 getchar();
}
