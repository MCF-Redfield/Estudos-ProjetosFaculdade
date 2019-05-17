#include <stdlib.h>
#include <stdio.h>

struct Arvore {
  int chave;
  struct Arvore *esq;
  struct Arvore *dir;
};

// definirmos o tipo arvore como sinônimo de struct Arvore
typedef struct Arvore arvore;

// função que cria um node de uma arvore
arvore* criaNode (int i)
{
  // vou alocar espaco para o novo node
  arvore *node = (arvore*) malloc(sizeof(arvore)); // aloco espaco
  // verifico se alocou espaco
  if (node == NULL){
    printf("Erro! Falta de memoria");
    exit(0);
  }
  else{ // insiro os valores do novo node
    node->chave = i; // guardo a informacao
    node->esq = NULL; //
    node->dir = NULL; //
  }
  return node;
}

arvore* insere(arvore *raiz, int chave){
    arvore *corrente = raiz; // nao altero a raiz
    arvore *ant = NULL; // guardo o node anterior

    // percorro a arvore procurando a posicao para insercao
    while (corrente != NULL) {
        ant = corrente;

        if (corrente->chave < chave) {
            corrente = corrente->dir;
        }
        else {
            corrente = corrente->esq;
        }
    }

    // vou alocar espaco para o novo node
    arvore* node = criaNode(chave); // aloco espaco e cria um node

    // agora insiro o novo node na posicao correta da arvore
    if ( raiz == NULL) {
        raiz = node; // primeiro node a ser inserido
    }
    else if (ant->chave < chave) {
        ant->dir = node; // insiro na direita
    }
    else {
        ant->esq = node; // insiro na esquerda
    }

    return raiz;

} // fim da funcao


void imprime_ordem(arvore *raiz){

  if ( raiz == NULL ){
    return;
  }

  imprime_ordem(raiz->esq);
  if(raiz->chave){
    printf(" %i ", raiz->chave);
  }
  imprime_ordem(raiz->dir);

} // fim da funcao imprime_ordem

void imprime_ordem_grafica(arvore *raiz, int l){

  int i = 0;

  if ( raiz == NULL ){
    return; // nada a ser impresso nesse ramo
  }

  imprime_ordem_grafica(raiz->dir, l+1);

  for(i=0; i<l; ++i)
    printf("  ");
  printf("%i\n", raiz->chave);

  imprime_ordem_grafica(raiz->esq, l+1);

} // fim da funcao imprime_ordem_grafica


int main(){

  // cria uma arvore vazia
  arvore* raiz = NULL;

  // inicio das insercoes
  raiz = insere(raiz, 10);

  raiz = insere(raiz, 5);

  raiz = insere(raiz, 9);

  raiz = insere(raiz, 14);

  raiz = insere(raiz, 19);

  raiz = insere(raiz, 8);

  printf("\nArvore em ordem: \n");
  imprime_ordem(raiz);

  printf("\n\nArvore em ordem grafica: \n");
  imprime_ordem_grafica(raiz, 0);

  printf("\n\n");
  return 0;
}
