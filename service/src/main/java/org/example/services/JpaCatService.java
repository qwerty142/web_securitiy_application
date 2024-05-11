package org.example.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.dto.CatModel;
import org.example.mappers.Mapper;
import org.example.repositories.Jpa.JpaCatRepository;
import org.example.tables.Cat;

import java.io.InvalidObjectException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaCatService implements ICatsService {
    private final JpaCatRepository catsRepository;
    @Override
    @Transactional
    public CatModel addCat(CatModel cats) {
        return Mapper.dbCatToCatModel(
                catsRepository.save(Mapper.CatModelToDbCat(cats)));
    }

    @Override
    @Transactional
    public CatModel updateCat(CatModel cats) {
        return Mapper.dbCatToCatModel(
                catsRepository.save(Mapper.CatModelToDbCat(cats)));

    }

    @Override
    @Transactional
    public CatModel deleteCat(CatModel cats) throws InvalidObjectException {
        Optional<Cat> cat = catsRepository.findById(cats.getCatId());
        if (cat.isEmpty()) {
            throw new InvalidObjectException("No such cat in db");
        }

        catsRepository.delete(cat.get());
        return Mapper.dbCatToCatModel(cat.get());
    }

    @Override
    public CatModel findById(Long id) {
        return Mapper.dbCatToCatModel(
                catsRepository.findById(id).get());
    }

    @Override
    public List<CatModel> findAll() {
        return
                catsRepository.findAll().stream().map(Mapper::dbCatToCatModel).toList();
    }

    @Override
    @Transactional
    public CatModel addFriend(Long toId, Long friendId) {
        catsRepository.addFriend(friendId, toId);
        return Mapper.dbCatToCatModel(
                catsRepository.addFriend(toId, friendId));
    }

    @Override
    @Transactional
    public CatModel deleteFriend(Long toId, Long friendId) {
        return Mapper.dbCatToCatModel(
                catsRepository.deleteFriend(toId, friendId));
    }
}
