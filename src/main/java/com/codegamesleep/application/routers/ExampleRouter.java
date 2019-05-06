package com.codegamesleep.application.routers;


import com.codegamesleep.application.handlers.ExampleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ExampleRouter {
    /**
     * A {@link RouterFunction} associates a ServerRequest to a Handler. The naming of the RouterFunction Bean must be
     * unique if multiple Beans are defined that return {@link RouterFunction}. It is suggested to group similar sets of
     * behavior within a single RouterFunction for clarity when utilizing Functional Endpoints.
     *
     * @param exampleHandler {@link ExampleHandler} leveraged for managing the ServerRequest
     *
     * @return {@link RouterFunction} closure that routes to a Handler function
     */
    @Bean
    public RouterFunction<ServerResponse> exampleRoute(ExampleHandler exampleHandler) {
        return RouterFunctions
                .route()
                .GET("/example", accept(MediaType.APPLICATION_JSON_UTF8), exampleHandler::example)
                .build();
    }
}
