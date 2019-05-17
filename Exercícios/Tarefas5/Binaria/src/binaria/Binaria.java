package binaria;

import java.util.Random;

public class Binaria 
{
   
        private static int contador=1;
        private int local=1;
    
        public boolean buscaBinaria(int[] A, int x)
        {
            local=-1;
            boolean existe=false;
            int inicio=0;
            int fim=A.length;
            int meio;
            
            while(inicio<=fim && local==-1)
            {
                meio=(inicio+fim)/2;
                System.out.println(""+meio);
                if(x==A[meio])
                {
                    local=meio;
                    existe=true;
                    return existe;
                }
                else
                {
                    if(x<A[meio])
                    {
                        fim=meio-1;
                    }
                    else
                    {
                        inicio=meio+1;
                    }
                }
                contador++;
            }
            return existe;
        }

        public int getLocal()
        {
        return local;
        }
        public void setLocal(int local)
        {
            this.local = local;
        }


        public static void main(String[] args)
        {
        Random aleatorio = new Random();
        int[] A = new int[40];
        
        for(int k=0;k<A.length;k++)
        {
            A[k]=k+1;
            System.out.println("A["+k+"]="+A[k]);
        }
        
        int x=A[19];
        
        Binaria busca= new Binaria();
        boolean existe=busca.buscaBinaria(A,x);
        
        if(existe)
        {
            System.out.println("O elemento foi encontrado na posição: "+busca.getLocal()+"\nNúmero de comparações: "+contador);
        }
        else
        {
         System.out.println("O elemento não foi encontrado"+"\nNúmero de comparações: "+contador);
        }
    }
}
