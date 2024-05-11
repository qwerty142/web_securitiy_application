package org.example.mappers;

import org.example.dto.*;

public class ControllerMapper {
    public static CatDto catModelToDto(CatModel model) {
        return CatDto.builder()
                .catId(model.getCatId())
                .breed(model.getBreed())
                .color(model.getColor())
                .friends(model.getFriends())
                .birthDate(model.getBirthDate())
                .ownerId_(model.getOwnerId())
                .build();
    }

    public static CatModel catDtoToModel(CatDto dto) {
        return CatModel.builder()
                .catId(dto.getCatId())
                .breed(dto.getBreed())
                .color(dto.getColor())
                .friends(dto.getFriends())
                .birthDate(dto.getBirthDate())
                .ownerId(dto.getOwnerId_())
                .build();
    }

    public static OwnerDto ownerModelToDto(OwnerModel model) {
        return OwnerDto.builder()
                .ownerId(model.getOwnerId())
                .birthDate(model.getBirthDate())
                .build();
    }

    public static OwnerModel ownerDtoToModel(OwnerDto dto) {
        return OwnerModel.builder()
                .ownerId(dto.getOwnerId())
                .birthDate(dto.getBirthDate())
                .build();
    }

    public static UserModel userDtoToUserModel(UserDto dto) {
        return UserModel.builder()
                .id(dto.getId())
                .name(dto.getName())
                .password(dto.getPassword())
                .role(dto.getRole())
                .owner(dto.getOwner())
                .build();
    }

    public static UserDto userModelToUserDto(UserModel dto) {
        return UserDto.builder()
                .id(dto.getId())
                .name(dto.getName())
                .password(dto.getPassword())
                .role(dto.getRole())
                .owner(dto.getOwner())
                .build();
    }
}
