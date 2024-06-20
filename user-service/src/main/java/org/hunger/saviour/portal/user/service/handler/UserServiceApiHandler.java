package org.hunger.saviour.portal.user.service.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class UserServiceApiHandler {


    @ExceptionHandler(Exception.class)
    public void hello(Exception e) {
      log.info(e.getMessage());
        e.printStackTrace();
    }
}
