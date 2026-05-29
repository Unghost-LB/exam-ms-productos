package com.examen.productos.service;

import com.examen.productos.dto.ProductoRequest;
import com.examen.productos.entity.Producto;
import com.examen.productos.exception.ProductoNotFoundException;
import com.examen.productos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repository;

    public Producto crear(ProductoRequest request) {

        Producto producto = Producto.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .precio(request.getPrecio())
                .stock(request.getStock())
                .estado(request.getEstado())
                .categoria(request.getCategoria())
                .fechaCreacion(LocalDateTime.now())
                .imagenUrl(request.getImagenUrl())
                .build();

        return repository.save(producto);
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Producto buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    public Producto actualizar(Long id, ProductoRequest request) {

        Producto producto = buscar(id);

        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());
        producto.setEstado(request.getEstado());
        producto.setCategoria(request.getCategoria());
        producto.setImagenUrl(request.getImagenUrl());
        producto.setFechaActualizacion(LocalDateTime.now());
        return repository.save(producto);
    }

    public void eliminar(Long id) {

        Producto producto = buscar(id);

        producto.setEstado(false);

        repository.save(producto);
    }
}
