package com.ceiba.alquiler.comando.manejador;

import com.ceiba.alquiler.servicio.ServicioEliminarAlquiler;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarAlquiler implements ManejadorComando<Long> {

    private final ServicioEliminarAlquiler servicioEliminarAlquiler;

    public ManejadorEliminarAlquiler(ServicioEliminarAlquiler servicioEliminarAlquiler) {
        this.servicioEliminarAlquiler = servicioEliminarAlquiler;
    }

    @Override
    public void ejecutar(Long id) {
        this.servicioEliminarAlquiler.ejecutar(id);
    }
}
