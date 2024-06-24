package org.hunger.saviour.portal.restaurant.service.utilities;


import org.hunger.saviour.portal.restaurant.service.dto.RestaurantDto;
import org.hunger.saviour.portal.restaurant.service.entities.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface RestaurantMapper {

    public static RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    @Mapping(source = "menus" ,target = "menuDtos" )
     RestaurantDto convertEntityToDto(RestaurantEntity restaurantEntity) ;

    @Mapping(source = "menuDtos" ,target = "menus" )

      RestaurantEntity convertDtoToEntity(RestaurantDto restaurantDto) ;


}
