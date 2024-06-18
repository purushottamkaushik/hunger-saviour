package org.hunger.saviour.portal.restaurant.service.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestaurantExceptionHandler {

    public void handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

    }
}
