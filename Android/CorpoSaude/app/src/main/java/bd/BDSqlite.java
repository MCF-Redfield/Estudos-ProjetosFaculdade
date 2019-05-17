package bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDSqlite extends SQLiteOpenHelper
{
	


	private static final String NOME_BD = "novasfichas";
	private static final int VERSAO_BD = 1;
	
	public BDSqlite(Context ctx){
		super(ctx, NOME_BD, null, VERSAO_BD);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	db.execSQL("create table ficha(_id integer primary key autoincrement, nomeficha text not null,"
			+ "exercicio text not null, series integer not null, peso integer not null, repeticoes integer not null);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table ficha;");
		onCreate(db);
		
	}
	
	public static class Fichas{
		public static final String TABELA = "fichas";
		public static final String _ID = "_id";
		public static final String NOMEFICHA = "nomeficha";
		public static final String EXERCICIO = "exercicio";
		public static final String SERIES = "series";
		public static final String PESO = "peso";
		public static final String REPETICOES = "repeticoes";
	
		public static final String[] COLUNAS = new String[]{
			_ID,NOMEFICHA, EXERCICIO,SERIES,PESO,REPETICOES
		};
	}

}
