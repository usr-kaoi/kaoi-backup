package com.gft.api.controller;

import com.gft.api.service.TheCatApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TheCatApiController {

    @Autowired
    private TheCatApiService theCatApiService;

    @GetMapping("/api/racas")
    public String ListarRacas() {
        return theCatApiService.buscarRacas();
    }

    @GetMapping("/api/imagens")
    public String buscarImagens(@RequestParam String raca) {
        return theCatApiService.buscarImagensPorRaca(raca);
    }
}
