package arvorebinaria;
public class No 
{
    protected int chave;
    protected No esq;
    protected No dir;
    protected No pai;
    
    public No(int chave)
    {
        this.chave=chave;
        this.esq=null;
        this.dir=null;
        this.pai=null;
    }
}
