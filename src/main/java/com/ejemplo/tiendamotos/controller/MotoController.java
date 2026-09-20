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

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {

        model.addAttribute("moto", new Moto());

        return "crear-moto";
    }

    @PostMapping("/guardar")
    public String guardarMoto(@ModelAttribute Moto moto) {

        motoService.guardar(moto);

        return "redirect:/motos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(
            @PathVariable Long id,
            Model model)
    {
        Moto moto = motoService
                .buscarPorId(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Moto no encontrada: " + id
                        )
                );
        model.addAttribute("moto", moto);

        return "editar-moto";
    }
}
