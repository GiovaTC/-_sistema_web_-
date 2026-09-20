package com.ejemplo.tiendamotos.controller;

import com.ejemplo.tiendamotos.model.Moto;
import com.ejemplo.tiendamotos.service.MotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/motos")
public class MotoController {

    private final MotoService motoService;

    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    @GetMapping
    public String listarMotos(
            @RequestParam(required = false) String marca, Model model)
    {
        if (marca != null &&  !marca.isBlank())
        {
            model.addAttribute(
                    "motos",
                    motoService.buscarPorMarca(marca)
            );
        } else {
            model.addAttribute(
                    "motos",
                    motoService.listarTodas()
            );
        }

        model.addAttribute("marcaBusqueda", marca);

        return "motos";
    }   
}
