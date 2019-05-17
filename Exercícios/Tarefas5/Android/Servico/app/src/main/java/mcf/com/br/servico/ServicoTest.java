package mcf.com.br.servico;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Mcf on 05/05/2015.
 */
public class ServicoTest extends Service
{

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate()
    {
        Log.i("Script", "OnStartCommand()");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.i("Script", "OnStartCommand()");

        Worker w = new Worker(startId);
        w.start();

        return (super.onStartCommand(intent,flags,startId));
    }

    class Worker extends Thread
    {
        public Worker(int starId)
        {
            this.starId=starId;
        }
        int count = 0;
        int starId;
        boolean ativo = true;

        public void run()
        {
            while(ativo && count<10)
            {
                try {
                       Thread.sleep(1000);
                    }
                catch (InterruptedException e)
                    {
                       e.printStackTrace();
                    }
                count++;
                Log.i("Script", "COUNT: " + count);
            }
            stopSelf(starId);
        }
    }

    public void
}
