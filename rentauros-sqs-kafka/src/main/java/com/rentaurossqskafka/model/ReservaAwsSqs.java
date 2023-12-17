package com.rentaurossqskafka.model;

import com.amazonaws.services.sns.model.MessageAttributeValue;

import java.util.Map;

public record ReservaAwsSqs(Map<String, MessageAttributeValue> atributosMensaje) implements Reserva {
    @Override
    public String getIdCliente() {
        return null;
    }

    @Override
    public String getNombreCliente() {
        return null;
    }

    @Override
    public String getApellidos() {
        return null;
    }

    @Override
    public String getPlacaVehiculo() {
        return null;
    }

    @Override
    public String getFechaInicio() {
        return null;
    }

    @Override
    public String getFechaFin() {
        return null;
    }
}
