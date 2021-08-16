package com.ceiba.alquiler.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoAlquiler {

    private Long id;
    private String nombre;
    private String numero;
    private LocalDateTime fechaPago;
    private Boolean estadoPago;
    private String local;
}
