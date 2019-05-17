package factorymethod;

public class EmissorJMS implements Emissor {

    @Override
    public void envia(String mensagem) {
        System.out.println("Enviando mensagem por JMS");
        System.out.println(mensagem);

    }

}
