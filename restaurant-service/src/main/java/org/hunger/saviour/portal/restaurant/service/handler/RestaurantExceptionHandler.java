package org.hunger.saviour.portal.restaurant.service.handler;

import lombok.extern.slf4j.Slf4j;
import org.hunger.saviour.portal.restaurant.service.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class RestaurantExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDto handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .exceptionMessages(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .statusCodeDescription(HttpStatus.BAD_REQUEST.name())
                .errorMessages(exception.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .map(ObjectError::getDefaultMessage)
                        .collect(Collectors.toUnmodifiableList()))
                .build();
    }
}
