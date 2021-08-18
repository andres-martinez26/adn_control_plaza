package com.ceiba.alquiler.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarNumerico;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Alquiler {

    private static final String DEBE_SER_UN_VALOR_NUMERICO = "Debe ser un valor numerico";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_ALQUILADOR = "Se debe ingresar el nombre del alquilador";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_CONTACTO = "Se debe ingresar el numero de contacto";
    private static final String SE_DEBE_INGRESAR_LA_FECHA = "Se debe ingresar la fecha";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO_DEL_PAGO = "Se debe ingresar el estado del pago";
    private static final String SE_DEBE_INGRESAR_EL_LOCAL_ALQUILADO = "Se debe ingresar el local alquilado";

    private Long id;
    private String nombre;
    private String numero;
    private LocalDateTime fechaPago;
    private String estadoPago;
    private String letraLocal;

    public Alquiler(Long id, String nombre, String numero, LocalDateTime fechaPago, String estadoPago, String letraLocal) {

        validarNumerico(id.toString(),DEBE_SER_UN_VALOR_NUMERICO);
        validarObligatorio(nombre,SE_DEBE_INGRESAR_EL_NOMBRE_DEL_ALQUILADOR);
        validarObligatorio(numero,SE_DEBE_INGRESAR_EL_NUMERO_DE_CONTACTO);
        validarObligatorio(fechaPago,SE_DEBE_INGRESAR_LA_FECHA);
        validarObligatorio(estadoPago,SE_DEBE_INGRESAR_EL_ESTADO_DEL_PAGO);
        validarObligatorio(letraLocal,SE_DEBE_INGRESAR_EL_LOCAL_ALQUILADO);

        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.fechaPago = fechaPago;
        this.estadoPago = estadoPago;
        this.letraLocal = letraLocal;
    }
}
