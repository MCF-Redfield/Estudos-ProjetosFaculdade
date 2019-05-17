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
	int hora;
}CONSULTA;

void cadastra_paciente()
{
	int i=0;
	PACIENTE coitado[i];
	printf("\nInforme o codigo do paciente: ");
	scanf("%d",&coitado[i].cod);
	getchar();
	printf("\nDigite o nome do paciente: ");
	gets(coitado[i].p_nome);
	printf("\nInforme o telefone: ");
	scanf("%",&coitado[i].p_fone);
	getchar();
	printf("\nDigite o endereco do paciente: ");
	gets(coitado[i].endereco);
	printf("\nInforme o plano de saude do paciente: ");
	gets(coitado[i].plano_saude);
	printf("\n\n\nPaciente %d %s Fone:%d Endereco:%s Plano de saude:%s" ,coitado[i].cod,coitado[i].p_nome,coitado[i].p_fone,coitado[i].endereco,coitado[i].plano_saude);
	i++;
}
		
void cadastra_medico()
{
	int i=0;
	MEDICO medicine[i];
	printf("\nDigite o CRM do medico: ");
	scanf("%d",&medicine[i].crm);
	getchar();
	printf("\nDigite o nome do medico: ");
	gets(medicine[i].m_nome);
	printf("\nInforme o telefone: ");
	scanf("%d",&medicine[i].m_fone);
	getchar();
	getchar();
	printf("\nInforme sua especialidade: ");
	gets(medicine[i].esp);
	printf("\n\n\nDr.%s CRM-%d especialista em %s fone:%d",medicine[i].m_nome,medicine[i].crm,medicine[i].esp,medicine[i].m_fone);	
	i++;
}
main()
{
	int menu;
	printf("1-Cadastrar Medico\n2-Cadastra Paciente\n3-Marcar consulta\n->");
	scanf("%d",&menu);
	if(menu==1)
	cadastra_medico();
	else if(menu==2)
		 cadastra_paciente();
getchar();
getchar();
}
