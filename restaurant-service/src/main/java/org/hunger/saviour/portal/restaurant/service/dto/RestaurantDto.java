package org.hunger.saviour.portal.restaurant.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hunger.saviour.portal.restaurant.service.entities.RestaurantMenuEntity;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Validated
public class RestaurantDto {

    Long restaurantId;
    @NotBlank(message = "restaurant name must not be blank")
    String restaurantName;

//    @NotBlank(message = "menu item must not be blank")

    String rating;
    @NotBlank(message = "restaurant image url must not be blank")

    String imageUrl;

    @NotBlank(message = "restaurant location must not be blank")
    String location;

    @NotNull
    List<String> menuTypes;
    @NotNull
    @NotEmpty
    List<RestaurantMenuDto> menuDtos;
}