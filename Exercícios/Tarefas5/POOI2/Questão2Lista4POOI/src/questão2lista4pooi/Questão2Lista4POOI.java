package questão2lista4pooi;

import java.io.File;

public class Questão2Lista4POOI
{      
        public static void main(String[] args) throws Exception
        {  
            File file = new File("/home/livre/Downloads");
            listaDiretorio(file);
        }  
          
        public static void listaDiretorio(File file)
        {  
            System.out.println("Dir.:" + file.getName());    
            for(File f: file.listFiles())
            {  
                if(f.isFile())   
                    System.out.println("\tArq.: "+f.getName());  
                else  
                    listaDiretorio(f);  
            }  
              
        }  
}