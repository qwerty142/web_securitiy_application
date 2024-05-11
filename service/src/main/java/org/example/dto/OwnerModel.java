package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
public class OwnerModel {
    private Long ownerId;
    private OffsetDateTime birthDate;
}
