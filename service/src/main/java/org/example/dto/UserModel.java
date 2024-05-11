package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.tables.Owner;
import org.example.util.Role;

@Data
@Builder
@AllArgsConstructor
public class UserModel {
    private Long id;
    private String name;
    private String password;
    private Role role;
    private Long owner;
}
