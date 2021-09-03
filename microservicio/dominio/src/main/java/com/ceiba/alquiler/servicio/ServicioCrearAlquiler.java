package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import static com.ceiba.dominio.CalculadorFecha.sumarUnMesFechaActual;

public class ServicioCrearAlquiler {

    private static final String EL_USUARIO_YA_TIENE_ALQUILADO_UN_LOCAL = "El usuario ya tiene alquilado un local";
    private static final String EL_LOCAL_YA_FUE_ALQUILADO = "El local ya fue alquilado";

    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public String ejecutar(Alquiler alquiler) {
        validarExistenciaPrevia(alquiler);
        validarExistenciaLocal(alquiler.getLetraLocal());
        this.repositorioAlquiler.crear(alquiler);
        return sumarUnMesFechaActual(alquiler.getFechaPago(), 1);
    }

    private void validarExistenciaLocal(String letraLocal) {
        boolean existe = this.repositorioAlquiler.existeLocal(letraLocal);
        if(existe) {
            throw new ExcepcionDuplicidad(EL_LOCAL_YA_FUE_ALQUILADO);
        }
    }

    private void validarExistenciaPrevia(Alquiler alquiler) {
        boolean existe = this.repositorioAlquiler.existeCompleto(alquiler);
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_TIENE_ALQUILADO_UN_LOCAL);
        }
    }
}
