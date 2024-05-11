package org.example.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.dto.CatModel;
import org.example.dto.OwnerModel;
import org.example.mappers.Mapper;
import org.example.repositories.Jpa.JpaOwnerRepository;
import org.example.tables.Owner;

import java.io.InvalidObjectException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaOwnerService implements IOwnersService {
    private final JpaOwnerRepository ownersRepository;
    @Override
    @Transactional
    public OwnerModel addOwner(OwnerModel owners) {
        return Mapper.dbOwnerToOwnerModel(
                ownersRepository.save(Mapper.ownerModelToOwnerDb(owners)));
    }

    @Override
    @Transactional
    public OwnerModel updateOwner(OwnerModel owners) {
        return Mapper.dbOwnerToOwnerModel(
                ownersRepository.save(Mapper.ownerModelToOwnerDb(owners)));
    }

    @Override
    @Transactional
    public OwnerModel deleteOwner(OwnerModel owners) throws InvalidObjectException {
        Optional<Owner> owner = ownersRepository.findById(owners.getOwnerId());

        if (owner.isEmpty()) {
            throw new InvalidObjectException("no such owner in db");
        }

        ownersRepository.delete(owner.get());
        return Mapper.dbOwnerToOwnerModel(
                owner.get());
    }

    @Override
    public OwnerModel findById(Long id) {
        return Mapper.dbOwnerToOwnerModel(
                ownersRepository.findById(id).get());
    }

    @Override
    public List<OwnerModel> findAll() {
        return
                ownersRepository.findAll().stream().map(Mapper::dbOwnerToOwnerModel).toList();
    }

    @Override
    public List<CatModel> findAllOwnedCats(Long ownerId) {
        return
                ownersRepository.findAllOwnedCats(ownerId).stream().map(Mapper::dbCatToCatModel).toList();
    }
}
