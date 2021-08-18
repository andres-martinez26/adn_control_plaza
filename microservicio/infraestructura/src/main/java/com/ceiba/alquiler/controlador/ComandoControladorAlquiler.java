package com.ceiba.alquiler.controlador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.comando.manejador.ManejadorActualizarAlquiler;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearAlquiler;
import com.ceiba.alquiler.comando.manejador.ManejadorEliminarAlquiler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alquiler")
@Api(tags = { "Controlador comando alquiler"})
public class ComandoControladorAlquiler {

    private final ManejadorCrearAlquiler manejadorCrearAlquiler;
    private final ManejadorEliminarAlquiler manejadorEliminarAlquiler;
    private final ManejadorActualizarAlquiler manejadorActualizarAlquiler;

    @Autowired
    public ComandoControladorAlquiler(ManejadorCrearAlquiler manejadorCrearAlquiler,
                                      ManejadorEliminarAlquiler manejadorEliminarAlquiler,
                                      ManejadorActualizarAlquiler manejadorActualizarAlquiler) {
        this.manejadorCrearAlquiler = manejadorCrearAlquiler;
        this.manejadorEliminarAlquiler = manejadorEliminarAlquiler;
        this.manejadorActualizarAlquiler = manejadorActualizarAlquiler;
    }

    @PostMapping
    @ApiOperation("Crea un registro de alquiler")
    public ComandoRespuesta<String> crear(@RequestBody ComandoAlquiler comandoAlquiler){
        return manejadorCrearAlquiler.ejecutar(comandoAlquiler);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar registro")
    public void eliminar(@PathVariable Long id){
        manejadorEliminarAlquiler.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar registro")
    public void actualizar(@RequestBody ComandoAlquiler comandoAlquiler, @PathVariable Long id){
        comandoAlquiler.setId(id);
        manejadorActualizarAlquiler.ejecutar(comandoAlquiler);
    }
}
