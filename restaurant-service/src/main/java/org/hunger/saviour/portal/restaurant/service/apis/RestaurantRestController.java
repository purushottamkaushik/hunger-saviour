package org.hunger.saviour.portal.restaurant.service.apis;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hunger.saviour.portal.restaurant.service.entities.RestaurantEntity;
import org.hunger.saviour.portal.restaurant.service.service.RestaurantService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
@Slf4j
@RequiredArgsConstructor
public class RestaurantRestController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<?> createRestaurant(@Valid @RequestBody String restaurantDto) {
//        this.restaurantService.createRestaurant(restaurantDto);
        log.info("Restaurant created :: " + restaurantDto);
        return ResponseEntity.ok("Restaurant created");
    }

    @GetMapping("/{offset}/{pagesize}")
    public Page<RestaurantEntity> getRestaurants(@PathVariable("offset") int offset,
                                                 @PathVariable("pagesize") int pageSize) {
        return this.restaurantService.getRestaurants(offset, pageSize);
    }
}
