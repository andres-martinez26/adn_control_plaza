package com.ceiba;

public class ComandoRespuesta<T> {

    private T mensaje;

    public ComandoRespuesta(T mensaje) {
        this.mensaje = mensaje;
    }

    public T getMensaje() {
        return mensaje;
    }
}
