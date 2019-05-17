package quicksorter;
public class QuickSorter
{    
            public int[] quicksort(int[] vet)
        {
            imprime(vet);
            return  quicksort(vet,0,vet.length-1);
        }
        
        public int[] quicksort(int vet[],int limitInf, int limitSup)
        {
            if(limitInf>=limitSup)
            {
                imprime(vet);
                return vet;
            }
            int inf=limitInf;
            int sup=limitSup;
            
            if(limitInf!=limitSup)
            {
                int pivo;
                int aux;
                
                pivo=limitSup;
                
                while(limitInf!=limitSup)
                { imprime(vet);
                    while(vet[limitSup] >= vet[pivo] && limitInf<limitSup)
                    {
                        limitSup--;
                    }
                    while(vet[limitInf] < vet[pivo] && limitInf<limitSup)
                    {
                        limitInf++;
                    }
                    
                    if(limitSup!=limitInf)
                    {
                        aux=vet[limitSup];
                        vet[limitSup]=vet[limitInf];
                        vet[limitInf]=aux;
                    }
                    
                    if(limitSup==limitInf)
                    {
                        quicksort(vet,inf,limitInf-1);
                        quicksort(vet,limitInf+1,sup);
                    }
                    
                }
            imprime(vet);
            }
            
            else return vet;
            imprime(vet);
            return vet;
        }
        public void imprime( int vet[])
        {
            String vetor="";
            for(int k=0;k<vet.length;k++)
            {
                if(k!=vet.length-1)
                {
                    vetor=vetor+vet[k]+",";
                }
                else
                    vetor=vetor+vet[k]+"";
                System.out.println(vetor);
            }
        }
}        