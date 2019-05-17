package questao3lista3;

/**
 *
 * @author Mcf
 */
public class Circulo extends Forma
{
    private float raio;

    public Circulo(float raio)
    {
        this.raio = raio;
    }
    
    @Override
    public float calcularArea()
    {
        return (float)(Math.PI * Math.pow(getRaio(), 2));
    }

    @Override
    public float calcularPerimetro()
    {
        return (float)(2 * Math.PI * getRaio());
    }

    public float getRaio()
    {
        return raio;
    }

    public void setRaio(float raio)
    {
        this.raio = raio;
    }
    
    
}
