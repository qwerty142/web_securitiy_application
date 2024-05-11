package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatDto {
    private Long catId;
    private OffsetDateTime birthDate;
    private String breed;
    private String color;
    private Long ownerId_;
    private Collection<Long> friends;
}
