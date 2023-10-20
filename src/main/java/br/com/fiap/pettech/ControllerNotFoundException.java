package br.com.fiap.pettech;

public class ControllerNotFoundException extends RuntimeException {

    public ControllerNotFoundException (String msg) {
        super(msg);
    }

}
