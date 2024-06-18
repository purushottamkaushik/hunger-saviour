package org.hunger.saviour.portal.restaurant.service.utilities;


import org.hunger.saviour.portal.restaurant.service.dto.RestaurantDto;
import org.hunger.saviour.portal.restaurant.service.entities.RestaurantEntity;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {


    public static RestaurantDto convertEntityToDto(RestaurantEntity restaurantEntity) {
        return RestaurantDto.builder()
                .restaurantName(restaurantEntity.getRestaurantName())
                .location(restaurantEntity.getLocation())
                .imageUrl(restaurantEntity.getImageUrl())
                .menuTypes(restaurantEntity.getMenuTypes())
                .restaurantId(restaurantEntity.getRestaurantId())
                .build();
    }

    public static RestaurantEntity convertDtoToEntity(RestaurantDto restaurantDto) {
        return RestaurantEntity.builder()
                .restaurantName(restaurantDto.getRestaurantName())
                .location(restaurantDto.getLocation())
                .imageUrl(restaurantDto.getImageUrl())
                .menuTypes(restaurantDto.getMenuTypes())
//                .restaurantId(restaurantEntity.getRestaurantId())
                .build();
    }


}
