package tchunaisoft.com.br.walkaux;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

import java.util.List;


public class GraficoWalkActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_walk);

        WalkDAO walkDAO = new WalkDAO(getApplication());
        List<Walk> listaWalk = walkDAO.buscar();

        int i=0, tam = 10;
        double v = 0;

        GraphView.GraphViewData[] data = new GraphView.GraphViewData[listaWalk.size()];

        //instancia gráfico de linha
        LineGraphView graph = new LineGraphView(this, "Gráfico X : IDWalk, Y : Distância");
        //encher o vetor de GraphViewData, q são os valores que serão inseridos no gráfico(por isso Data*)

        for(i=0; i<listaWalk.size();i++)
        {
            String aux = listaWalk.get(i).getDistancia();
            data[i] = new GraphView.GraphViewData(Integer.parseInt(listaWalk.get(i).getId()+""), Double.parseDouble(   listaWalk.get(i).getDistancia().substring(0, aux.length() - 6)));//i=valores do eixo X v = valores do eixo Y
        }

        //recebe os valores que estarão no gráfico, no caso o vetor de GraphViewData

        //while(i<listaWalk.size())
        //{
        //    String aux = listaWalk.get(i).getDistancia();
        //    data[i] = new GraphView.GraphViewData(Double.parseDouble(listaWalk.get(i).getHorario().substring(8,10)), Double.parseDouble(listaWalk.get(i).getDistancia().substring(0, aux.length() - 6)));
        //    i++;
        //}
        GraphViewSeries seriesSeno = new GraphViewSeries(data);
        //adiciona os valores ao gráfico
        graph.addSeries(seriesSeno);

        graph.getGraphViewStyle().setGridColor(Color.GRAY);
        graph.getGraphViewStyle().setHorizontalLabelsColor(Color.WHITE);
        graph.getGraphViewStyle().setVerticalLabelsColor(Color.WHITE);
        graph.getGraphViewStyle().setTextSize(15);
        //graph.setHorizontalLabels(new String[]{"00/01","01/01", "02/01", "03/01", "04/01", "05/01", "06/01", "07/01", "08/01", "09/01", "10/01", "11/01", "12/01"});

        //paradinha pra escolher qntas linhas//
        graph.getGraphViewStyle().setNumHorizontalLabels(6);
        graph.getGraphViewStyle().setNumVerticalLabels(listaWalk.size() + 1);
        graph.setViewPort(5, 5);

        graph.setScalable(true);
        graph.setScrollable(true);

        LinearLayout ll = (LinearLayout) findViewById(R.id.graph);
        ll.addView(graph);
        /*graph.setShowLegend(true);
        graph.setLegendAlign(GraphView.LegendAlign.BOTTOM);




        graph.setCustomLabelFormatter(new CustomLabelFormatter()
        {
            int j=0;
            @Override
            public String formatLabel(double value, boolean isValueX)
            {
                // TODO Auto-generated method stub
                if(isValueX)
                {
                    if(value > 2)
                    {
                        j++;
                        return("xx"+j);
                    }
                    return("x2");
                }
                else
                {
                    if(value > 2)
                    {
                        return("y1");
                    }
                    return("y2");
                }
            }
        });

*/



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grafico_walk, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
