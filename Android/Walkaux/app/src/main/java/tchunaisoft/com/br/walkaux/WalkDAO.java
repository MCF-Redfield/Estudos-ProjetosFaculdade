package tchunaisoft.com.br.walkaux;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 13/06/2015.
 */
public class WalkDAO
{
    private SQLiteDatabase bd;

    public WalkDAO(Context context)
    {
        BDCore auxBd = new BDCore(context);
        bd = auxBd.getWritableDatabase();
    }

    public void inserir(Walk walk)
    {
        ContentValues valores = new ContentValues();

        valores.put("tempo",walk.getTempo());
        valores.put("distancia",walk.getDistancia());
        valores.put("horario",walk.getHorario());
        valores.put("velocidade", walk.getVelocidade());

        bd.insert("walk", null, valores);
    }

    public List<Walk> buscar()
    {
        List<Walk> list = new ArrayList<>();
        String[] colunas = new String[]{"_id", "tempo", "distancia", "horario", "velocidade"};

        Cursor cursor = bd.query("walk", colunas, null, null, null, null,null);

        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();

            do
            {
                Walk walk = new Walk();
                walk.setId(cursor.getLong(0));
                walk.setTempo(cursor.getString(1));
                walk.setDistancia(cursor.getString(2));
                walk.setHorario(cursor.getString(3));
                walk.setVelocidade(cursor.getString(4));

                list.add(walk);
            }while(cursor.moveToNext());
        }

        return(list);
    }


    public void deletar()
    {
        bd.delete("walk", null, null);
    }
}
