package org.hunger.saviour.portal.restaurant.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "restaurant_menu_entity")
@Entity
public class RestaurantMenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "restaurant_menu_id")
    Long restaurantMenuId;
    @Column(name = "menu_item")
    String menuItem;
    @Column(name = "description")
    String description;
    @Column(name = "menu_image_url")
    String menuImageUrl;
    @Column(name = "price")
    Double menuItemPrice;
    @Column(name = "rating")
    String rating;
    @Column(name = "menu_type")
    String menutype;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    RestaurantEntity restaurant;
}
