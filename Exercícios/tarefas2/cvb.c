#include<stdio.h>
#include<stdlib.h>

char jog;
int linha = 0, coluna = 0, win, casa[3][3];

void desenha(int x, int y) 
{
    if (casa[x][y] == ' ') printf(" "); //campo não marcado aparece em branco (“ ”) 
    if (casa[x][y] == 1) printf("X"); //campo marcado pelo jogador 1 aparece com “X”
    if (casa[x][y] == 2) printf("O"); //campo marcado pelo jogador 1 aparece com “O”
}

void jogo() {  
    printf("  1   2   3\n"); //aqui,são mostrados os números das colunas do tabuleiro
    printf("1 "); //aqui é mostrado o número da primeira linha
    desenha(0, 0); //aqui é exibido o campo que cruza a linha 1 com a coluna 1
    printf("  | "); //caractere de divisão entre dois campos
    desenha(0, 1); //aqui é exibido o campo que cruza a linha 1 com a coluna 2
    printf("  | "); //caractere de divisão entre dois campos
    desenha(0, 2); //aqui é exibido o campo que cruza a linha 1 com a coluna 3
    printf("\n -----------\n2 "); //desenha linha horizontal e mostra número da linha 2
    desenha(1, 0); //aqui é exibido o campo que cruza a linha 2 com a coluna 1
    printf("  | "); //caractere de divisão entre dois campos
    desenha(1, 1); //aqui é exibido o campo que cruza a linha 2 com a coluna 2
    printf("  | "); //caractere de divisão entre dois campos
    desenha(1, 2); //aqui é exibido o campo que cruza a linha 2 com a coluna 3
    printf("\n -----------\n3 "); //desenha linha horizontal e mostra número da linha 3  
    desenha(2, 0); //aqui é exibido o campo que cruza a linha 3 com a coluna 1
    printf("  | "); //caractere de divisão entre dois campos
    desenha(2, 1); //aqui é exibido o campo que cruza a linha 3 com a coluna 2
    printf("  | "); //caractere de divisão entre dois campos
    desenha(2, 2); //aqui é exibido o campo que cruza a linha 3 com a coluna 3
}
void jogar (int jogador) {
    int i = 0;
    if (jogador == 1) jog = 1;
    if (jogador == 2) jog = 2;


	//Definindo o jogador da vez
    while (i == 0) {
        linha = 0; //inicializando valor da linha
        coluna = 0; //inicializando valor da coluna
        while (linha < 1 || linha > 3) 
        {
            printf("\n\n Vez do Jogador %d. Escolha a Linha (1,2,3): ", jog);
            scanf("%d", &linha); //lendo linha escolhida
            if (linha < 1 || linha > 3) printf("\nAviso: Linha invalida! Voce so pode escolher as linhas de 1 a 3.\n"); //Aviso de linha inválida, caso o jogador tenha escolhido linha menor que 1 ou maior que 3
        }
        while (coluna < 1 || coluna > 3) 
        {
            printf("\n\n Vez do Jogador %d. Escolha a Coluna (1,2,3): ", jog);
            scanf("%d", &coluna); //lendo coluna escolhida
            if (coluna < 1 || coluna > 3) printf("\nAviso: Coluna invalida! Voce so pode escolher as colunas de 1 a 3.\n"); //Aviso de coluna inválida, caso o jogador tenha escolhido coluna menor que 1 ou maior que 3
        }
linha--;
coluna--;

if (casa[linha][coluna] != 1 && casa[linha][coluna] != 2) { //se não estiver marcado
    casa[linha][coluna] = jog; //marcar com o símbolo do jogador da vez
    i = 1;
} else { //se o campo escolhido já estivar marcado
    Printf ("Ja houve jogada nesta casa! Escolha outra casa.\n"); //aviso
}

void jogar (int jogador) {
    int i = 0;
    if (jogador == 1) jog = 1;
    if (jogador == 2) jog = 2;
    while (i == 0) {
        linha = 0;
        coluna = 0;
        while (linha < 1 || linha > 3) {
            printf ("\n\n Vez do Jogador %d. Escolha a Linha (1,2,3): ", jog);
            scanf ("%d", &linha);
            if (linha < 1 || linha > 3) printf ("\nAviso: Linha invalida! Voce so pode escolher as linhas de 1 a 3.\n");
        }
        while (coluna < 1 || coluna > 3) {
           printf ("\n\n Vez do Jogador %d. Escolha a Coluna (1,2,3): ", jog);
            scanf ("%d", &coluna);
            if (coluna < 1 || coluna > 3) printf ("\nAviso: Coluna invalida! Voce so pode escolher as colunas de 1 a 3.\n");
        }
        linha--;
        coluna--;
        if (casa[linha][coluna] != 1 && casa[linha][coluna] != 2) {
            casa[linha][coluna] = jog;
            i = 1;
        } else {
            printf ("Ja houve jogada nesta casa! Escolha outra casa.\n");
        }
    }
}

void check() {
    int i = 0;
    //verificando se houve vencedor na Horizontal:       
    for (i = 0; i < 3; i++) { 
        if (casa[i][0] == casa[i][1] && casa[i][0] == casa[i][2]) {
            if (casa[i][0] == 1) win = 1;
            if (casa[i][0] == 2) win = 2;
        }
    }
    //verificando se houve vencedor na Vertical:
    for (i = 0; i < 3; i++) { 
        if (casa[0][i] == casa[1][i] && casa[0][i] == casa[2][i]) {
            if (casa[0][i] == 1) win = 1;
            if (casa[0][i] == 2) win = 2;
        }
    }
    //verificando se houve vencedor na Diagonal de cima para baixo:  
    if (casa[0][0] == casa[1][1] && casa[0][0] == casa[2][2]) {
        if (casa[0][0] == 1) win = 1;
        if (casa[0][0] == 2) win = 2;
    }
    //verificando se houve vencedor na Diagonal de baixo para cima:
    if (casa[0][2] == casa[1][1] && casa[0][2] == casa[2][0]) { 
        if (casa[0][2] == 1) win = 1;
        if (casa[0][2] == 2) win = 2;
    }
}

int main() {
    int i = 0;
    //percorre todo o tabuleiro, nas nove posições:  
    for (i = 0; i < 9; i++) {
        limpa(); //chama a função limpa(), para limpar a tela
        jogo(); //chama a função jogo(), que desenha o tabuleiro
        if (!divi(i, 2)) jogar(2);
        else jogar(1);
        check(); //chama a função check (), para ver se alguém ganhou
        if (win == 1 || win == 2) i = 10; //sai do laço antes de completar o tabuleiro, se alguém tiver vencido
    }
    limpa();//chama a função limpa(), para limpar a tela
    jogo();//chama a função jogo(), para desenhar novamente o tabuleiro
    if (win == 1 || win == 2) { //verifica se houve vencedor
        printf ("\nJogador %d é o ganhador!\n", win);//informa o vencedor
        sleep(2); //Para por 2 segundos o display, para que o jogador possar visualizar a mensagem
    } else { //se não houve vencedor
        printf ("\nNão houve vencedor! O jogo foi empate!!\n");//informa o empate
        sleep(2); //Para por 2 segundos o display, para que o jogador possar visualizar a mensagem
    }
    return 0;
} 
