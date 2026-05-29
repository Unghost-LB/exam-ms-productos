package com.examen.productos.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

@Data
public class ProductoRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
    private String descripcion;


    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe de ser mayor a 0")
    private BigDecimal precio;

    @NotNull(message = "El stock es obligatorio")
    @PositiveOrZero(message = "El stock no puede ser negativo")
    private Integer stock;

    @NotNull
    private Boolean estado;

    @NotBlank(message = "La categoria es obligatoria")
    private String categoria;

    @URL(message = "Debe de proporcionar una URL válida")
    private String imagenUrl;
}
