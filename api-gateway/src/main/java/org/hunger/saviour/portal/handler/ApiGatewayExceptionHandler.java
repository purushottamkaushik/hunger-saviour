package org.hunger.saviour.portal.handler;

import lombok.extern.slf4j.Slf4j;
import org.hunger.saviour.portal.exceptions.ErrorResponseDto;
import org.hunger.saviour.portal.exceptions.UnauthorizedAcessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiGatewayExceptionHandler {

    @ExceptionHandler(UnauthorizedAcessException.class)
    public ErrorResponseDto handleUnauthorizedAcessException(UnauthorizedAcessException e){

        return null;
    }


}
