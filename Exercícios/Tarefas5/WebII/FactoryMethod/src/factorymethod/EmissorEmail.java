package factorymethod;

public class EmissorEmail implements Emissor {

    @Override
    public void envia(String mensagem) {
        System.out.println("Enviando mensagem por Email");
        System.out.println(mensagem);

    }

}
