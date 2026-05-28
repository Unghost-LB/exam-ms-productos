package com.examen.productos.controller;

import com.examen.productos.dto.ProductoRequest;
import com.examen.productos.entity.Producto;
import com.examen.productos.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService service;

    @PostMapping
    public Producto crear(@Valid @RequestBody ProductoRequest request) {
        return service.crear(request);
    }

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Producto actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProductoRequest request
    ) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
