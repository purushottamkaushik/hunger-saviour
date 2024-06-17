package org.hunger.saviour.portal.restaurant.service.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hunger.saviour.portal.restaurant.service.entities.RestaurantEntity;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Validated
public class RestaurantMenuDto {
    Long restaurantMenuId;
    @NotBlank(message = "menu item must not be blank")
    String menuItem;
    @NotBlank(message = "menu description must not be blank")
    String description;
    @NotBlank(message = "menu image url must not be blank")
    String menuImageUrl;
    @NotNull(message = "menu item price must not be null")
            @Positive(message = "menu item price must be greater than zero")
    Double menuItemPrice;

    String rating;
    @NotBlank(message = "menu type must not be blank")
    String menutype;
    RestaurantEntity restaurant;
}
