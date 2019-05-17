/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao3lista3;

/**
 *
 * @author Mcf
 */
public class Retangulo extends Forma
{
    private float h;
    private float lado;

    public Retangulo(float h, float lado)
    {
        this.h = h;
        this.lado = lado;
    }
            
    @Override
    public float calcularArea()
    {
        return getH()*getLado();
    }

    @Override
    public float calcularPerimetro()
    {
        return 2*getH()+2*getLado();
    }

    public float getH()
    {
        return h;
    }

    public void setH(float h)
    {
        this.h = h;
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
