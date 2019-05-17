#include <stdio.h>
#include <stdlib.h>
 
char set;
int linha=0,coluna=0,win,casa[3][3];
 
void draw(int x, int y) {
  if (casa[x][y] == '{FONTE}') printf(" ");
  if (casa[x][y] == 1) printf("X");
  if (casa[x][y] == 2) printf("O");
}
 
void limpa() {
}
 
void jogo() {
  printf("\n\n\n  ");
  draw(0,0);
  printf(" | ");
  draw(0,1);
  printf(" | ");
  draw(0,2);
  printf("\n --+---+---\n  ");
  draw(1,0);
  printf(" | ");
  draw(1,1);
  printf(" | ");
  draw(1,2);
  printf("\n --+---+---\n  ");
  draw(2,0);
  printf(" | ");
  draw(2,1);
  printf(" | ");
  draw(2,2);
}
 
void check() {
  int i=0;
  for (i=0;i<3;i++) { /* Horizontal */
    if (casa[i][0] == casa[i][1] && casa[i][0] == casa[i][2]) {
      if (casa[i][0] == 1) win=1;
      if (casa[i][0] == 2) win=2;
    }
  }
  for (i=0;i<3;i++) { /* Vertical */
    if (casa[0][i] == casa[1][i] && casa[0][i] == casa[2][i]) {
      if (casa[0][i] == 1) win=1;
      if (casa[0][i] == 2) win=2;
    }
  }
  if (casa[0][0] == casa[1][1] && casa[0][0] == casa[2][2]) { /* Diagonal Cima->Baixo*/
    if (casa[0][0] == 1) win=1;
    if (casa[0][0] == 2) win=2;
  }
  if (casa[0][2] == casa[1][1] && casa[0][2] == casa[2][0]) { /* Diagonal Baixo->Cima */
    if (casa[0][2] == 1) win=1;
    if (casa[0][2] == 2) win=2;
  }
}
 
void play(int player) {
  int i=0;
  if (player==1) set=1;
  if (player==2) set=2;
  play:
  while (i==0) {
    linha=0;
    coluna=0;
    while (linha<1 || linha>3) {
      printf("\n\n\nJogador %d. Escolha a Linha: ",set);
      scanf("%d",&linha);
      getchar();
    }
    while (coluna<1 || coluna>3) {
      printf("\nJogador %d. Escolha a Coluna: ",set);
      scanf("%d",&coluna);
      getchar();
    }
    linha--;
    coluna--;
    if (casa[linha][coluna] != 1 && casa[linha][coluna] != 2) {
      casa[linha][coluna]=set;
      i=1;
    }
    else {
      printf("A casa esta em uso! Jogue Novamente...\n");
      limpa();
      jogo();
    }
  }
}
 
char divi(int a, int b) {
  return (!(a%b));
}
 
int main() {
  int i=0;
  for (i=0;i<9;i++) {
    limpa();
    jogo();
    if(!divi(i,2)) play(2);
    else play(1);
    check();
    if (win == 1 || win == 2) i=10;
  }
  limpa();
  jogo();
  if (win == 1 || win == 2) printf("\nJogador %d venceu o jogo!\n",win);
  else printf("\nEmpate!\n");
  
 getchar();
 getchar(); 
}  
