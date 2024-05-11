package org.example;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.mappers.ControllerMapper;
import org.example.services.JpaUserService;
import org.example.util.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final JpaUserService service;
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserDto createUser(@RequestBody UserDto dto) {
        dto.setRole(Role.BASE_USER);
        return ControllerMapper.userModelToUserDto(service.addUser(ControllerMapper.userDtoToUserModel(dto)));
    }
}
