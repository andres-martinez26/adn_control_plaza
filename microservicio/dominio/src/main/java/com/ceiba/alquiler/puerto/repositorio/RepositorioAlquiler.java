package com.ceiba.alquiler.puerto.repositorio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;

public interface RepositorioAlquiler {
    /**
     * Permite crear un registro
     */
    void crear(Alquiler alquiler);

    /**
     * Permite actualizar un registro
     */
    void actualizar(Alquiler alquiler);

    /**
     * Permite eliminar un registro
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un registro con una cédula
     * @return si existe o no un registro
     */
    boolean existe(Long id);
    /**
     * Permite validar si existe un registro completo
     * @return si existe o no un registro
     */
    boolean existeCompleto(Alquiler alquiler);
    /**
     * Permite validar si existe un registro con un local
     * @return si existe o no un registro
     */
    boolean existeLocal(String letraLocal);
}
