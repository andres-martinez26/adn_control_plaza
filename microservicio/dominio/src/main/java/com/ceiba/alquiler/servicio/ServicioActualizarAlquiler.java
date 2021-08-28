package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarAlquiler {

    private static final String EL_REGISTRO_YA_EXISTE_EN_EL_SISTEMA = "El registro ya existe en el sistema";
    private static final String EL_LOCAL_YA_FUE_ALQUILADO = "El local ya fue alquilado";

    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioActualizarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public String ejecutar(Alquiler alquiler){
        boolean existe = false;
        existe = validarExistenciaPrevia(alquiler);
        if(existe) {
            return new ExcepcionDuplicidad(EL_REGISTRO_YA_EXISTE_EN_EL_SISTEMA).getMessage();
        }
        existe = validarExistenciaLocal(alquiler.getLetraLocal());
        if(existe) {
            return new ExcepcionDuplicidad(EL_LOCAL_YA_FUE_ALQUILADO).getMessage();
        }
        this.repositorioAlquiler.actualizar(alquiler);
        return "Actualizado";
    }

    private boolean validarExistenciaLocal(String letraLocal) {
        return this.repositorioAlquiler.existeLocal(letraLocal);
    }

    private boolean validarExistenciaPrevia(Alquiler alquiler){
        return this.repositorioAlquiler.existeCompleto(alquiler);
    }
}
