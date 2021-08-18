package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.modelo.entidad.Alquiler;

import java.time.LocalDateTime;

public class AlquilerTestDataBuilder {

    private Long id;
    private String nombre;
    private String numero;
    private LocalDateTime fechaPago;
    private String estadoPago;
    private String letraLocal;

    public AlquilerTestDataBuilder() {
        id = 1099371682L;
        nombre = "Andrés";
        numero = "3162878196";
        fechaPago = LocalDateTime.now();
        estadoPago = "pendiente";
        letraLocal = "A";
    }

    public Alquiler build(){
        return new Alquiler(id,nombre,numero,fechaPago,estadoPago,letraLocal);
    }
}
