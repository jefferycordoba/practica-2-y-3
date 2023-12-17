package com.rentaurossqs.services;


import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import com.rentaurossqs.model.Reserva;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Service
public class ReservaSQSServices {

    private final AmazonSQS sqsClient;

    private String getQueueUrl() {
        return sqsClient.getQueueUrl("reserva-autos").getQueueUrl();
    }

    public String publishStandardQueueMessage(Integer delaySeconds, Reserva reserva) {
        Map<String, MessageAttributeValue> atributosMensaje = new HashMap<>();
        atributosMensaje.put("idCliente",
                new MessageAttributeValue()
                        .withStringValue(reserva.idCliente())
                        .withDataType("String")
        );
        atributosMensaje.put("nombreCliente",
                new MessageAttributeValue()
                        .withStringValue(reserva.nombreCliente())
                        .withDataType("String")
        );
        atributosMensaje.put("apellidos",
                new MessageAttributeValue()
                        .withStringValue(reserva.apellidos())
                        .withDataType("String")
        );
        atributosMensaje.put("placaVehiculo",
                new MessageAttributeValue()
                        .withStringValue(reserva.placaVehiculo())
                        .withDataType("String")
        );
        atributosMensaje.put("fechaInicio",
                new MessageAttributeValue()
                        .withStringValue(reserva.apellidos())
                        .withDataType("fechaInicio")
        );
        atributosMensaje.put("fechaFin",
                new MessageAttributeValue()
                        .withStringValue(reserva.apellidos())
                        .withDataType("fechaFin")
        );

        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(this.getQueueUrl())
                .withMessageBody(reserva.idCliente())
                .withDelaySeconds(delaySeconds)
                .withMessageAttributes(atributosMensaje);

        return sqsClient.sendMessage(sendMessageRequest).getMessageId();
    }
}
