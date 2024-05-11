package com.example.app;

import org.example.CatsController;
import org.example.dto.CatDto;
import org.example.dto.CatModel;
import org.example.mappers.ControllerMapper;
import org.example.services.JpaCatService;
import org.example.util.HibernateSessionFactoryUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class IntegrationTestsCats {
    private static final CatsController catsController = new CatsController(new JpaCatService(new CatsRepository()));

    @AfterEach
    void dropSessions() {
        if (HibernateSessionFactoryUtil.getSessionFactory() != null) {
            HibernateSessionFactoryUtil.getSessionFactory().close();
        }
    }

    @Test
    void addCat() {
        CatModel catModel = new CatModel(null, OffsetDateTime.now(), "street", "orange", null, List.of());
        CatDto res = catsController.add(ControllerMapper.catModelToDto(catModel));
        assertThat(res).isNotNull();
        assertThat(res.getCatId()).isNotNull();
        assertThat(res.getBirthDate()).isEqualTo(catModel.getBirthDate());
        assertThat(res.getBreed()).isEqualTo(catModel.getBreed());
    }

    @Test
    void updateCat() {
        CatModel catModel = new CatModel(null, OffsetDateTime.now(), "street", "orange", null, List.of());
        CatDto res = catsController.add(ControllerMapper.catModelToDto(catModel));
        CatModel updated = new CatModel(res.getCatId(), OffsetDateTime.now(), "ad", "ad", null, List.of());
        res = catsController.updateCat(ControllerMapper.catModelToDto(updated));
        assertThat(res).isNotNull();
        assertThat(res.getCatId()).isNotNull();
        assertThat(res.getBirthDate()).isEqualTo(updated.getBirthDate());
        assertThat(res.getBreed()).isEqualTo(updated.getBreed());
        assertThat(res.getColor()).isEqualTo(updated.getColor());
    }

    @Test
    void findByIdTest() {
        CatModel catModel = new CatModel(null, OffsetDateTime.now(), "street", "orange", null, List.of());
        CatDto res = catsController.add(ControllerMapper.catModelToDto(catModel));
        catModel.setCatId(res.getCatId());
        res = catsController.findById(res.getCatId());
        assertThat(res).isNotNull();
        assertThat(res.getCatId()).isEqualTo(catModel.getCatId());

    }

    @Test
    void deleteTest() {
        CatModel catModel = new CatModel(null, OffsetDateTime.now(), "street", "orange", null, List.of());
        CatDto res = catsController.add(ControllerMapper.catModelToDto(catModel));
        catModel.setCatId(res.getCatId());
        catsController.deleteCat(res);
        res = catsController.findById(catModel.getCatId());
        assertThat(res).isNull();
    }
}
