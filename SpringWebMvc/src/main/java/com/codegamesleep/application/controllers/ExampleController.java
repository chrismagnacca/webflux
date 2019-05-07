package com.codegamesleep.application.controllers;

import com.codegamesleep.application.serializers.ExampleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@link RestController} annotation will manage the serialization into Json, over leveraging the
 * other {@link org.springframework.stereotype.Controller} annotation. This facilitates quick API construction
 * without having to define return types on your REST endpoints. This can be extended upon by leveraging
 * {@link org.springframework.web.bind.annotation.RequestMapping} if customization is necessary.
 */
@RestController
public class ExampleController {
    private static final String GET_EXAMPLE = "/example";

    /**
     *
     * @return {@link ExampleResponse} serialized automatically by Spring Mvc
     */
    @GetMapping
    public ExampleResponse example() {
        return new ExampleResponse("OK");
    }
}
