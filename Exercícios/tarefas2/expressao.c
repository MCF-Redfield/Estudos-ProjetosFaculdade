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
int push(int e) // s� passo o valor a ser inserido
{
  /* verificar se a pilha esta cheia ==> evitar overflow*/
  if (cheia()){
    return 0; /* retorno zero ==> zero � falso */
  }
  topo++; /* vou para a pr�xima posi��o livre */
  pilha[topo] = e;
  return 1; /* empilhado com sucesso, retorno 1 ==> diferente de zero � verdadeiro */

}

/* desempilha um elemento */
int pop()
{
  int e;
  /* verificar se a pilha esta vazia ==> evitar underflow*/
  if (vazia()){
    return 0; /* zero � falso */
  }
  e = pilha[topo]; /* guardo o elemento do topo*/
  topo--; /* removo o elemento do topo, i.e., decremento o topo */
  return e; //* desempilhado com sucesso, retorno diferente de zero � verdadeiro */
  /* dar� um problema se a pilha aceitar o elemento zero*/

}

/* devolve o elemento do topo, mas n�o remove */
int elemento_topo ()
{
  int e;
  /* verificar se a pilha esta vazia ==> evitar underflow*/
  if (vazia()){
    return 0; /* zero � falso */
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
  char *exp; // vetor para guardar a express�o

  int i = 0;
  char simbolo; // recebe o simbolo corrente da expressao
  char aux; // armazena temporariamente o valor desempilhado
  int valido = 1; // auxiliar que simula TRUE (1) e FALSE (0)


  exp = "{4*[(45+3)]-3}"; // inicializacao da entrada do usu�rio

  // vou varrer a express�o e pegar elemento por elemento
  while(exp[i] != '\0'){
    simbolo = exp[i]; // guardo um elemento

    // verifico se o simbolo � de abertura: se for empilho
    if ( simbolo == '(' || simbolo == '[' || simbolo == '{' ){
      push(simbolo);
      //printf("simbolo %c pilha ==> ", simbolo ); imprime(); printf("\n");
    }

    // verifico se o simbolo � de fechamento: verifico antes de desempilhar
    if ( simbolo == ')' || simbolo == ']' || simbolo == '}' ){
      // se estiver vazia, a quantidade de simbolos de abertura e fechamento � diferente
      if (vazia()){
	valido = 0;
	break; // j� � falso, saio do while
      }
      else{ // verificar se o s�mbolo atual casa com o s�mbolo no topo da pilha
	aux = pop(); // desempilho o topo
	if( (aux == '(' && simbolo == ')') || (aux == '[' && simbolo == ']') || (aux == '{' && simbolo == '}')){
	  valido = 1; // casou
	}
	else{
	  valido = 0;
	  break; // j� � falso, saio do while
	}
	//printf("simbolo %c pilha ==> ", simbolo ); imprime(); printf("\n");
      }// fim que verifica a fun��o vazia

    }// fim do if que verifica os s�mbolo

    i++; // incrementa para pegar o pr�ximo simbolo da expressao
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
