package org.example.mappers;

import org.example.dto.CatModel;
import org.example.dto.OwnerModel;
import org.example.dto.UserModel;
import org.example.tables.Cat;
import org.example.tables.Owner;
import org.example.tables.User;
import org.example.util.Role;

import java.util.stream.Collectors;

public final class Mapper {
    private Mapper() {}

    public static Cat CatModelToDbCat(CatModel catModel) {
        if (catModel == null) {
            return null;
        }
        return Cat.builder()
                .catId(catModel.getCatId())
                .birthDate(catModel.getBirthDate())
                .ownerId(catModel.getOwnerId())
                .friends(catModel.getFriends().stream().map(id -> Cat.builder().catId(id).build()).collect(Collectors.toSet()))
                .breed(catModel.getBreed())
                .color(catModel.getColor())
                .build();
    }

    public static CatModel dbCatToCatModel(Cat cats) {
        if (cats == null) {
            return null;
        }
        return CatModel.builder()
                .catId(cats.getCatId())
                .birthDate(cats.getBirthDate())
                .ownerId(cats.getOwnerId())
                .friends(cats.getFriends().stream().map(Cat::getCatId).toList())
                .breed(cats.getBreed())
                .color(cats.getColor())
                .build();
    }

    public static OwnerModel dbOwnerToOwnerModel(Owner owners) {
        if (owners == null) {
            return null;
        }
        return OwnerModel.builder()
                .ownerId(owners.getOwnerId())
                .birthDate(owners.getBirthDate())
                .build();
    }

    public static Owner ownerModelToOwnerDb(OwnerModel owners) {
        if (owners == null) {
            return null;
        }
        return Owner.builder()
                .ownerId(owners.getOwnerId())
                .birthDate(owners.getBirthDate())
                .build();
    }

    public static User userModelToUserDb(UserModel model) {
        if (model == null) {
            return null;
        }
        return User.builder()
                .id(model.getId())
                .name(model.getName())
                .password(model.getPassword())
                .role(model.getRole().toString())
                .owners(Owner.builder().ownerId(model.getOwner()).build())
                .build();
    }

    public static UserModel userDbToUserModel(User model) {
        return UserModel.builder()
                .id(model.getId())
                .name(model.getName())
                .password(model.getPassword())
                .role(Role.valueOf(model.getRole()))
                .owner(model.getOwners().getOwnerId())
                .build();
    }
}
