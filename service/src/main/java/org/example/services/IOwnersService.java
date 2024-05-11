package org.example.services;

import org.example.dto.CatModel;
import org.example.dto.OwnerModel;

import java.io.InvalidObjectException;
import java.util.List;

public interface IOwnersService {
    OwnerModel addOwner(OwnerModel owners);
    OwnerModel updateOwner(OwnerModel owners);
    OwnerModel deleteOwner(OwnerModel owners) throws InvalidObjectException;
    OwnerModel findById(Long id);
    List<OwnerModel> findAll();
    List<CatModel> findAllOwnedCats(Long ownerId);
}
