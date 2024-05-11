package org.example.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Collection;

@Entity
@Data
@Table(name = "cat")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;
    private OffsetDateTime birthDate;
    private String breed;
    private String color;
    private Long ownerId;
    @ManyToMany(targetEntity = Cat.class, fetch = FetchType.EAGER)
    @JoinTable(name = "cat_cat",
            joinColumns = @JoinColumn(name = "cat1_id"),
            inverseJoinColumns = @JoinColumn(name = "cat2_id"))
    private Collection<Cat> friends;

}
