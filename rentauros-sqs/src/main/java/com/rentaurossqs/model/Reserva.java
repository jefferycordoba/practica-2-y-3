package com.rentaurossqs.model;

public record Reserva(
        String idCliente,
        String nombreCliente,
        String apellidos,
        String placaVehiculo,
        String fechaInicio,
        String fechaFin
) {}
