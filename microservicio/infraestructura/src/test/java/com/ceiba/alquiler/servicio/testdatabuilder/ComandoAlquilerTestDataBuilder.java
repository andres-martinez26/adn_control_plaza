package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.comando.ComandoAlquiler;

import java.time.LocalDateTime;

public class ComandoAlquilerTestDataBuilder {

    private Long id;
    private String nombre;
    private String numero;
    private LocalDateTime fechaPago;
    private String estadoPago;
    private String letraLocal;

    public ComandoAlquilerTestDataBuilder() {
        id = 1099371682L;
        nombre = "Andrés";
        numero = "3162878196";
        fechaPago = LocalDateTime.parse("2021-08-14T17:10:20");
        estadoPago = "pendiente";
        letraLocal = "A";
    }

    public ComandoAlquiler build(){
        return new ComandoAlquiler(id,nombre,numero,fechaPago,estadoPago,letraLocal);
    }
}
