package org.hunger.saviour.portal.user.service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @Enumerated(EnumType.STRING)
    private String role;

//    @ManyToMany
//    private List<UserEntity> userEntities;

    public RoleEntity(String role) {
        this.role = role;
    }
}
