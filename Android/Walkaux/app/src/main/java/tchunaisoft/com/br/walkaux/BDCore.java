package tchunaisoft.com.br.walkaux;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usuario on 13/06/2015.
 */
public class BDCore extends SQLiteOpenHelper
{
    private static final String NOME_BD = "walkando";
    private static final int VERSAO_BD = 3;

    public BDCore(Context ctx){
        super(ctx, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase bd)
    {
        bd.execSQL("create table walk(_id integer primary key autoincrement, tempo text not null, distancia text not null, horario text not null, velocidade text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion)
    {
        bd.execSQL("drop table walk;");
        onCreate(bd);
    }
}
