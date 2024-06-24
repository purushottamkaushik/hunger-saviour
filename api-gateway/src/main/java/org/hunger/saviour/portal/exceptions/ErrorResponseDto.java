package org.hunger.saviour.portal.exceptions;

import lombok.Data;

@Data
public class ErrorResponseDto {

    private String errorMessage;
    private String errorCode;

}
