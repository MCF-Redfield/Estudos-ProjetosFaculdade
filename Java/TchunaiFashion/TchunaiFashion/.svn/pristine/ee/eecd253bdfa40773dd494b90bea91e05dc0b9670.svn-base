package br.com.tchunaifashion.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Matheus Correia
 */
public class ConfigurarData
{
    public java.sql.Date configuraData(String data) throws ParseException
    {
            String dia = data.substring(8, 10);
            String mes = data.substring(5, 7);
            String ano = data.substring(0, 4);
            String startDate = ano+mes+dia;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            java.util.Date date;
                    date = sdf.parse(startDate);
                    java.sql.Date dataSql = new java.sql.Date(date.getTime());
                    return dataSql;
                
    }
    
    public String confuguraMes(int mes)
    {
        mes=mes+1;
        
        if(mes<=9 && mes>0)
        {
            return "0"+mes;
        }
        else
        return mes+"";
    }
    
    public String confuguraDia(int dia)
    {
        if(dia<=9 && dia>0)
        {
            return "0"+dia;
        }
        else
        return dia+"";
    }
}
