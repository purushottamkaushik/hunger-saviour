package org.hunger.saviour.portal.restaurant.service.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hunger.saviour.portal.restaurant.service.dto.RestaurantDto;
import org.hunger.saviour.portal.restaurant.service.entities.RestaurantEntity;
import org.hunger.saviour.portal.restaurant.service.repositories.RestaurantRepository;
import org.hunger.saviour.portal.restaurant.service.service.RestaurantService;
import org.hunger.saviour.portal.restaurant.service.utilities.RestaurantMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public void createRestaurant(RestaurantDto restaurantDto) {
        RestaurantEntity restaurantEntity = RestaurantMapper.convertDtoToEntity(restaurantDto);
        this.restaurantRepository.save(restaurantEntity);
    }

    @Override
    public Page<RestaurantEntity> getRestaurants(int offset, int pageSize) {
        PageRequest pageRequest = PageRequest.of(offset, pageSize);

        return this.restaurantRepository.findAll(pageRequest);
    }
}
