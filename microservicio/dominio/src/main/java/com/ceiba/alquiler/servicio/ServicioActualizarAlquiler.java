package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarAlquiler {

    private static final String EL_LOCAL_YA_FUE_ALQUILADO = "El local ya fue alquilado";

    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioActualizarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public void  ejecutar(Alquiler alquiler){
        validarExistenciaLocal(alquiler.getLetraLocal());
        this.repositorioAlquiler.actualizar(alquiler);
    }

    private void validarExistenciaLocal(String letraLocal) {
        boolean existe = this.repositorioAlquiler.existeLocal(letraLocal);
        if(existe) {
            throw new ExcepcionDuplicidad(EL_LOCAL_YA_FUE_ALQUILADO);
        }
    }
}
