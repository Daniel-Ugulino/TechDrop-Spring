package br.edu.infnet.TechStore.model.execptions;

public class ClienteException extends Exception{
    private static final long serialVersionUID = 1L;

    public ClienteException(String mensagem) {
        super(mensagem);
    }

}
