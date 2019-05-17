package arvorebinaria;

import java.util.Random;

public class ArvoreBinaria
{
 protected No raiz;
 
 public ArvoreBinaria()
 {
     this.raiz=null;
 }
 
 public No inserir(int chave, No raiz)
 {
     if(raiz==null)
     {
       raiz = new No(chave);
     }
     else if(chave<raiz.chave)
          {
            raiz.esq=inserir(chave,raiz.esq);
          }
          else
           raiz.dir=inserir(chave,raiz.dir);
   return raiz;       
 }
 
 public boolean pesquisar(int chave, No raiz)
 {
     boolean resp;
     
     if(raiz==null)
     {
       resp=false;
     }
     else if(chave<raiz.chave)
          {
            pesquisar(chave, raiz.esq);
          }
          else if(chave>raiz.chave)
               {
                 pesquisar(chave, raiz.dir);
               }
               else
               resp=true;
     return false;
     
     
 }
 
 public No removerNo(int chave, No raiz)
 {
     if(raiz==null)
     {
       return null;
     }
     else if(chave<raiz.chave)
          {
            raiz.esq=removerNo(chave, raiz.esq);
          }
          else if(chave>raiz.chave)
               {
                 raiz.dir=removerNo(chave, raiz.dir);
               }
               else
               {
                  if(raiz.esq==null && raiz.dir == null)
                  {
                     raiz=null;
                  }
                  else if(raiz.esq==null)
                       {
                         raiz=raiz.dir;
                       }
                       else if(raiz.dir==null)
                            {
                              raiz=raiz.esq;
                            }
                            else
                            {
                                No no=raiz.esq;
                                while(no.dir!=null)
                                {
                                  no=no.dir;
                                }
                                raiz.chave=no.chave;
                                no.chave=chave;
                                raiz.esq=removerNo(chave,raiz.esq);
                            }
               }
               return raiz;
 }
 
 public void imprimirArvoreEmOrdem(No no)
 {
     if(no!=null)
     {
         imprimirArvoreEmOrdem(no.esq);
         System.out.print(no.chave+" ");
         imprimirArvoreEmOrdem(no.dir);
         
     }
 }
 
    public static void main(String[] args) 
    throws CloneNotSupportedException
    {
        ArvoreBinaria tree = new ArvoreBinaria();
        Random sorte = new Random();
      for(int i=0;i<40;i++)
      {
        int chave=1+sorte.nextInt(40);
        tree.raiz = tree.inserir(chave, tree.raiz);
      } 
        tree.imprimirArvoreEmOrdem(tree.raiz);
        
        boolean resp = tree.pesquisar(02, tree.raiz);
        
        System.out.println();
        
        if(resp)
        {
            System.out.println("Registro encontrado");
        }
        else
            System.out.println("O registro não está presente na árvore");
        
        tree.raiz = tree.removerNo(5,tree.raiz);
        System.out.println("A raiz agora é: "+tree.raiz.chave);
        tree.imprimirArvoreEmOrdem(tree.raiz);
    }
}
