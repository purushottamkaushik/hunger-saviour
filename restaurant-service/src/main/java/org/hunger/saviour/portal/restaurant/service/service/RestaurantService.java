package org.hunger.saviour.portal.restaurant.service.service;


import org.hunger.saviour.portal.restaurant.service.dto.RestaurantDto;
import org.hunger.saviour.portal.restaurant.service.entities.RestaurantEntity;
import org.springframework.data.domain.Page;

public interface RestaurantService {

    public void createRestaurant(RestaurantDto restaurantDto);

    public Page<RestaurantEntity> getRestaurants(int offset, int pageSize);
}
