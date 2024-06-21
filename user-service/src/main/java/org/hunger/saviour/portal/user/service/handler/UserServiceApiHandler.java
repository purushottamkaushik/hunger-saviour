package org.hunger.saviour.portal.user.service.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
@Slf4j
public class UserServiceApiHandler {


    @ExceptionHandler(NoResourceFoundException.class)
    public void hello(NoResourceFoundException e) {
      log.info(e.getMessage());

        e.printStackTrace();
    }
}
