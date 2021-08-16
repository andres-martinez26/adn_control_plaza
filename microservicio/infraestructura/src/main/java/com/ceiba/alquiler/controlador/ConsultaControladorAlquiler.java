package com.ceiba.alquiler.controlador;

import com.ceiba.alquiler.consulta.ManejadorListarAlquiler;
import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alquiler")
@Api(tags={"Controlador consulta alquiler"})
public class ConsultaControladorAlquiler {

    private final ManejadorListarAlquiler manejadorListarAlquiler;

    public ConsultaControladorAlquiler(ManejadorListarAlquiler manejadorListarAlquiler) {
        this.manejadorListarAlquiler = manejadorListarAlquiler;
    }

    @GetMapping
    @ApiOperation("Listar Registros")
    public List<DtoAlquiler> listar() {
        return this.manejadorListarAlquiler.ejecutar();
    }
}
