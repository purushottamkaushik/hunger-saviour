package org.hunger.saviour.portal.restaurant.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "restaurant_entity")
@Entity
@Builder
public class RestaurantEntity {

    @Id
    @SequenceGenerator(name = "rest_seq" , sequenceName = "restaurant sequence" ,initialValue = 20100 , allocationSize = 1)
    @GeneratedValue(generator = "rest_seq" , strategy = GenerationType.SEQUENCE)
            @Column(name = "restaurant_id")
    Long restaurantId ;
    @Column(name = "restaurant_name")
    String restaurantName;
    @Column(name = "rating")
    String rating;
    @Column(name = "image_url")
    String imageUrl;
    @Column(name = "location")
    String location;

    @ElementCollection
    @JoinTable(name = "menu_types")
    List<String> menuTypes;

    @OneToMany(mappedBy ="restaurant" )
    List<RestaurantMenuEntity> restaurantMenuEntity;
}
