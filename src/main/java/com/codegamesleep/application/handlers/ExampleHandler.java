package com.codegamesleep.application.handlers;


import com.codegamesleep.application.serializers.ExampleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
public class ExampleHandler {
    /**
     * Constructor Injection can be leveraged via @Autowire within Handlers to integrate Service logic calls
     */
    @Autowired
    public ExampleHandler() {
    }

    /**
     *
     * @param request {@link ServerRequest} received by the RouterFunction
     *
     * @return {@link Mono} response consisting of a stream of 0 -> 1 element(s), the Reactive equivalent
     * of an {@link java.util.concurrent.CompletableFuture} type to discern handling single elements vs
     * multiple elements, corresponding to the {@link MediaType} defined by the set contentType call.
     *
     */
    public Mono<ServerResponse> example(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(new ExampleResponse("OK")));
    }
}
