package com.rentaurossqs.controller;

import com.rentaurossqs.model.Reserva;
import com.rentaurossqs.services.ReservaSQSServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/reserva-autos")
public class ReservaController {

    ReservaSQSServices reservaSQSServices;

    @PostMapping("/aws")
    public Mono<String> postMessageQueue(@RequestBody Reserva reserva) {
        return Mono.just(reservaSQSServices.publishStandardQueueMessage(10, reserva));
    }
}
