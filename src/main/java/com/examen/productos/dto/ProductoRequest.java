package com.examen.productos.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private String descripcion;

    @NotNull
    @Positive
    private BigDecimal precio;

    @NotNull
    @PositiveOrZero
    private Integer stock;

    @NotNull
    private Boolean estado;
}
