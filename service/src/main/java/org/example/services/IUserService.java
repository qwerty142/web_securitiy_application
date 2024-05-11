package org.example.services;

import org.example.dto.UserModel;

public interface IUserService {
    public UserModel addUser(UserModel userModel);
    public UserModel deleteUser(UserModel userModel);
    public UserModel getUser(Long id);
}
