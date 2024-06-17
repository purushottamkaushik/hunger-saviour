package org.hunger.saviour.portal.restaurant.service.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // WHatever data in non-null that will be included inside Response Object
public class ResponseDto {

    private List<String> errorMessages; // validation messages
    private LocalDateTime timestamp;
    private RestaurantDto restaurantDetails;

    private String exceptionMessages;
    private String statusCodeDescription;

}
