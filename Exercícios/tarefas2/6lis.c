/*O sistema de avalia��o de uma determinada disciplina obedece aos seguintes crit�rios:
� durante o semestre s�o dadas tr�s notas;
� a nota final � obtida pela m�dia aritm�tica das tr�s;
� � considerado aprovado o aluno que obtiver a nota final superior ou igual a 6 e que tiver comparecido a um
m�nimo de 40 aulas.
Fa�a um programa que:
� leia um conjunto de dados contendo o n�mero da matr�cula, as tr�s notas e a freq��ncia ( n�mero de aulas
freq�entadas) de dez alunos.
Calcule e mostre:
� para cada aluno o n�mero da matr�cula, a nota final e a mensagem (aprovado ou reprovado);
� a maior e a menor nota da turma;
� o total de alunos reprovados;
� a percentagem de alunos reprovados por freq��ncia abaixo da m�nima necess�ria.
*/
//falta a maior e a menor nota da turma e a percentagem de alunos reprovados por freq��ncia abaixo da m�nima necess�ria.
#include<stdio.h>
main(){
	   int matr[11],nota1[11],nota2[11],i,nota3[11],freq,media,soma,rep=0;
	    
	   
	    for(i=0;i<3;i++){
	     printf("Digite o numero da matricula do aluno: ");
		 scanf("%d",&matr[i]);
		 printf("Digite a nota1: ");
		 scanf("%d",&nota1[i]);
		 printf("Digite a nota2: ");
		 scanf("%d",&nota2[i]);
		 printf("Digite a nota3: ");
		 scanf("%d",&nota3[i]);
		 printf("Digite a frequencia do aluno: ");
		 scanf("%d",&freq);
		 soma=nota1[i]+nota2[i]+nota3[i];
		 media=soma/3;
		  if(media>=60 && freq>=40){
		  
	        printf("\nO aluno matriculado %d teve nota media de %d e esta aprovado!",matr[i],media); 
		  }   else
		        if(media<60 || freq<40)
	           {
	           printf("O aluno matriculado %d teve nota media de %d e esta reprovado!",matr[i],media);
			    rep+=1;
			    }printf("\n\n");	
	               
		 }
		  
	     printf("Total de reprovados foi: %d ",rep);
	   

getchar();
getchar();	    
}
