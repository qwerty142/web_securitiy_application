package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserModel;
import org.example.mappers.Mapper;
import org.example.repositories.Jpa.JpaUserRepository;
import org.example.tables.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaUserService implements IUserService {
    private final JpaUserRepository repository;
    @Override
    public UserModel addUser(UserModel userModel) {
        userModel.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
        return Mapper.userDbToUserModel(repository.saveAndFlush(Mapper.userModelToUserDb(userModel)));
    }

    @Override
    public UserModel deleteUser(UserModel userModel) {
        repository.delete(Mapper.userModelToUserDb(userModel));
        return userModel;
    }

    @Override
    public UserModel getUser(Long id) {
        Optional<User> user = repository.findById(id);
        return user.map(Mapper::userDbToUserModel).orElse(null);
    }
}
