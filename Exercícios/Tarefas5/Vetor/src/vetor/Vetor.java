package vetor;
public class Vetor 
{
    public static void main(String[] args) 
    {
      final int TAM=10;
      int[] array=new int[TAM];
      
      System.out.printf("%s%8s\n","Index","Value");
      
      for(int i=0;i<array.length;i++)
      {   
          System.out.printf("\n%5d%7d ",i,array[i]);
      
          for(int j=0;j<i;j++)
          {
              System.out.print("*");
          }
      }
    }    
}
