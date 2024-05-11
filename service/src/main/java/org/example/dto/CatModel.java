package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.tables.Cat;

import java.time.OffsetDateTime;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
public class CatModel {
    private Long catId;
    private OffsetDateTime birthDate;
    private String breed;
    private String color;
    private Long ownerId;
    private Collection<Long> friends;
}
