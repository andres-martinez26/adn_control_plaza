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

    public void  ejecutar(Alquiler alquiler){
        validarExistenciaPrevia(alquiler);
        validarExistenciaLocal(alquiler.getLetraLocal());
        this.repositorioAlquiler.actualizar(alquiler);
    }

    private void validarExistenciaLocal(String letraLocal) {
        boolean existe = this.repositorioAlquiler.existeLocal(letraLocal);
        if(existe) {
            throw new ExcepcionDuplicidad(EL_LOCAL_YA_FUE_ALQUILADO);
        }
    }

    private void validarExistenciaPrevia(Alquiler alquiler){
        boolean existe = this.repositorioAlquiler.existeCompleto(alquiler);
        if(existe) {
            throw new ExcepcionDuplicidad(EL_REGISTRO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
