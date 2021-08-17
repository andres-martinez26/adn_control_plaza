package com.ceiba.alquiler.puerto.repositorio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioAlquiler {
    /**
     * Permite crear un registro
     * @param alquiler
     * @return fecha de pago
     */
    Long crear(Alquiler alquiler);

    /**
     * Permite actualizar un registro
     * @param alquiler
     */
    void actualizar(Alquiler alquiler);

    /**
     * Permite eliminar un registro
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un registro con una cédula
     * @param id
     * @return si existe o no un registro
     */
    boolean existe(Long id);

    boolean existeCompleto(Alquiler alquiler);
}
