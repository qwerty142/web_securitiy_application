package org.example.services;

import org.example.dto.CatModel;

import java.io.InvalidObjectException;
import java.util.List;

public interface ICatsService {
    CatModel addCat(CatModel cats);
    CatModel updateCat(CatModel cats);
    CatModel deleteCat(CatModel cats) throws InvalidObjectException;
    CatModel findById(Long id);
    List<CatModel> findAll();
    CatModel addFriend(Long toId, Long friendId);
    CatModel deleteFriend(Long toId, Long friendId);
}
