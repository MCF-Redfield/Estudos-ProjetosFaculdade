#include <stdio.h>

#define tamanho 100

// Variaveis globais
char pilha[tamanho]; // definicao da pilha
int topo = -1; // inicializacao da varariavel topo com valor -1 */

/* verifica se a pilha esta cheia */
int cheia ()
{
  if (topo == (tamanho-1))
  {
    printf ("\nA pilha (stack) esta cheia!!!\n");
    return 1;
  }
  return 0;

}


/* verifica se a pilha esta vazia */
int vazia ()
{
  if (topo == -1)
  {
    printf ("\nA pilha (stack) esta vazia!!!\n");
    return 1;
   }
  return 0;

}


/* empilha um elemento */
int push(int e) // só passo o valor a ser inserido
{
  /* verificar se a pilha esta cheia ==> evitar overflow*/
  if (cheia()){
    return 0; /* retorno zero ==> zero é falso */
  }
  topo++; /* vou para a próxima posição livre */
  pilha[topo] = e;
  return 1; /* empilhado com sucesso, retorno 1 ==> diferente de zero é verdadeiro */

}

/* desempilha um elemento */
int pop()
{
  int e;
  /* verificar se a pilha esta vazia ==> evitar underflow*/
  if (vazia()){
    return 0; /* zero é falso */
  }
  e = pilha[topo]; /* guardo o elemento do topo*/
  topo--; /* removo o elemento do topo, i.e., decremento o topo */
  return e; //* desempilhado com sucesso, retorno diferente de zero é verdadeiro */
  /* dará um problema se a pilha aceitar o elemento zero*/

}

/* devolve o elemento do topo, mas não remove */
int elemento_topo ()
{
  int e;
  /* verificar se a pilha esta vazia ==> evitar underflow*/
  if (vazia()){
    return 0; /* zero é falso */
  }
  e = pilha[topo]; /* guardo o elemento do topo*/
  return e; //* retorna o elemento */

}

/* imprime os elementos da pilha */
void imprime ()
{
  int i=0;
  /* verificar se a pilha nao esta vazia antes de tentar imprimir */
  if (!(vazia())){
    for(i=0; i<=topo; i++){
      printf(" %c ",pilha[i]);
    }
  }

}

/* funcao main*/
int main ()
{
  char *exp; // vetor para guardar a expressão

  int i = 0;
  char simbolo; // recebe o simbolo corrente da expressao
  char aux; // armazena temporariamente o valor desempilhado
  int valido = 1; // auxiliar que simula TRUE (1) e FALSE (0)


  exp = "{4*[(45+3)]-3}"; // inicializacao da entrada do usuário

  // vou varrer a expressão e pegar elemento por elemento
  while(exp[i] != '\0'){
    simbolo = exp[i]; // guardo um elemento

    // verifico se o simbolo é de abertura: se for empilho
    if ( simbolo == '(' || simbolo == '[' || simbolo == '{' ){
      push(simbolo);
      //printf("simbolo %c pilha ==> ", simbolo ); imprime(); printf("\n");
    }

    // verifico se o simbolo é de fechamento: verifico antes de desempilhar
    if ( simbolo == ')' || simbolo == ']' || simbolo == '}' ){
      // se estiver vazia, a quantidade de simbolos de abertura e fechamento é diferente
      if (vazia()){
	valido = 0;
	break; // já é falso, saio do while
      }
      else{ // verificar se o símbolo atual casa com o símbolo no topo da pilha
	aux = pop(); // desempilho o topo
	if( (aux == '(' && simbolo == ')') || (aux == '[' && simbolo == ']') || (aux == '{' && simbolo == '}')){
	  valido = 1; // casou
	}
	else{
	  valido = 0;
	  break; // já é falso, saio do while
	}
	//printf("simbolo %c pilha ==> ", simbolo ); imprime(); printf("\n");
      }// fim que verifica a função vazia

    }// fim do if que verifica os símbolo

    i++; // incrementa para pegar o próximo simbolo da expressao
  }// fim do while

  // verifico que se a pilha ainda contem algum elemento, neste caso temos mais abertura do que fechamento
  if (!vazia()){
    valido = 0;
  }

  if (valido == 1){
    printf("\nA expressao eh valida\n\n");
  }
  else{
    printf("\nA expressao eh invalida\n\n");
  }

  //imprime();

  return 0;
getchar();
getchar();
}
