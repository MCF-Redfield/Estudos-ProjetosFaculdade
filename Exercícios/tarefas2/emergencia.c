#include<stdio.h>
#include<string.h>
#include<strings.h>
int h,g;

typedef struct hora
{
 int hour;
 int min;
}HORA;
typedef struct data
{
 int dia;
 int mes;
 int ano;
}DATA;
typedef struct medico
{
   int crm;
   char m_nome[30];
   int m_fone;
   char esp[20];
}MEDICO;

typedef struct paciente
{
	int cod;
	char p_nome[30];
	int p_fone;
	char endereco[50];
	char plano_saude[20];
}PACIENTE;

typedef struct consulta
{
	int c_crm;
	int c_cod;
	DATA date;
	HORA time;
}CONSULTA;
PACIENTE coitado[100];
PACIENTE cadastra_paciente()
{
	int i;
	i=h;
	printf("\nInforme o codigo do paciente: ");
	scanf("%d",&coitado[i].cod);
	getchar();
	printf("\nDigite o nome do paciente: ");
	gets(coitado[i].p_nome);
	printf("\nInforme o telefone: ");
	scanf("%d",&coitado[i].p_fone);
	getchar();
	printf("\nDigite o endereco do paciente: ");
	gets(coitado[i].endereco);
	printf("\nInforme o plano de saude do paciente: ");
	gets(coitado[i].plano_saude);
	printf("\n\n\n  %d  Paciente %d %s Fone:%d Endereco:%s Plano de saude:%s\n" ,i,coitado[i].cod,coitado[i].p_nome,coitado[i].p_fone,coitado[i].endereco,coitado[i].plano_saude);
	printf("-----------------------------------------------------------------------------\n\n");
	h++;
}
MEDICO medicine[100];
MEDICO cadastra_medico()
{
	int i;
	i=g;
	printf("\nDigite o CRM do medico: ");
	scanf("%d",&medicine[i].crm);
	getchar();
	printf("\nDigite o nome do medico: ");
	gets(medicine[i].m_nome);
	printf("\nInforme o telefone: ");
	scanf("%d",&medicine[i].m_fone);
	getchar();
	printf("\nInforme sua especialidade: ");
	gets(medicine[i].esp);
	printf("\n\n\n %d  Dr.%s CRM-%d especialista em %s fone:%d\n",i,medicine[i].m_nome,medicine[i].crm,medicine[i].esp,medicine[i].m_fone);
    printf("-----------------------------------------------------------------------------\n\n");
    g++;
}

int marca_consulta()
{
    int i=0,aux,aux2;
    CONSULTA consul[300];
    printf("Informe o CRM do medico com o qual quer atendimento: ");
    scanf("%d",&aux);
    for(i=0;i<300;i++)
    {
      if(aux!=medicine[i].crm)
      {
          if(i==299)
          {
           printf("Medico nao cadastrado!!\n");
           return 0;
          }
      }
        else
        {
          printf("Medico cadastrado: Dr. %s\n",medicine[i].m_nome);
          break;
        }
    }
    printf("\nInforme o codigo do paciente: ");
    scanf("%d",&aux2);
    for(i=0;i<300;i++)
    {
        if(aux2!=coitado[i].cod)
        {
          if(i==299)
          {
          printf("Paciente nao cadastrado!!\n");
          return 0;
          }
        }
          else
          {
            printf("paciente cadastrado: %s\n",coitado[i].p_nome);
            break;
          }
    }
    consul[i].c_crm=aux;
    consul[i].c_cod=aux2;
    printf("Informe a data para a consulta(dd-mm-aaa): ");
    scanf("%d-%d-%d",&consul[i].date.dia,&consul[i].date.mes,&consul[i].date.ano);
    printf("\nInforme a hora da consulta(hh:mm): ");
    scanf("%d:%d",&consul[i].time.hour,&consul[i].time.min);
    printf("\nO paciente %d tem Consulta agendada para dia %d-%d-%d as %d:%d com Dr. %s CRM-%d\n\n",consul[i].c_cod,consul[i].date.dia,consul[i].date.mes,consul[i].date.ano,consul[i].time.hour,consul[i].time.min,medicine[i].m_nome,medicine[i].crm);
    i++;
}
main()
{
	int j,menu;
    for(j=0;j>-1;j++)
	{
	printf("1-Cadastrar Medico\n2-Cadastra Paciente\n3-Marcar consulta\n->");
	scanf("%d",&menu);
	if(menu==1)
	cadastra_medico();
	else if(menu==2)
		 cadastra_paciente();
         else if(menu==3)
              marca_consulta();
	}
getchar();
getchar();
}
