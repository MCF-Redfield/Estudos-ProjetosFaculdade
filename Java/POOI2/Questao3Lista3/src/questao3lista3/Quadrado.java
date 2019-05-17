package questao3lista3;

/**
 *
 * @author Mcf
 */
public class Quadrado extends Forma
{
    private float lado;

    public Quadrado(float lado)
    {
        this.lado = lado;
    }
    
    @Override
    public float calcularArea()
    {
        return (float)(Math.pow(getLado(),2));
    }

    @Override
    public float calcularPerimetro()
    {
        return getLado()*4;
    }

    public float getLado()
    {
        return lado;
    }

    public void setLado(float lado)
    {
        this.lado = lado;
    }   
}
