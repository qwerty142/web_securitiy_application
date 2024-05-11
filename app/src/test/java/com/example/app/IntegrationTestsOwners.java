package com.example.app;

import org.example.OwnersController;
import org.example.dto.OwnerDto;
import org.example.dto.OwnerModel;
import org.example.mappers.ControllerMapper;
import org.example.services.JpaOwnerService;
import org.example.util.HibernateSessionFactoryUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTestsOwners {
    private final OwnersController controller = new OwnersController(new JpaOwnerService(new OwnersRepository()));

    @AfterEach
    void closeSession() {
        if(HibernateSessionFactoryUtil.getSessionFactory() != null) {
            HibernateSessionFactoryUtil.getSessionFactory().close();
        }
    }

    @Test
    void addOwnerTest() {
        OwnerModel dto = new OwnerModel(null, OffsetDateTime.now());
        OwnerDto res = controller.addOwner(ControllerMapper.ownerModelToDto(dto));
        assertThat(res).isNotNull();
        assertThat(res.getOwnerId()).isNotNull();
    }

    @Test
    void updateOwnerTest() {
        OwnerModel dto = new OwnerModel(null, OffsetDateTime.now());
        OwnerDto res = controller.addOwner(ControllerMapper.ownerModelToDto(dto));
        dto.setOwnerId(res.getOwnerId());
        OwnerModel updated = new OwnerModel(res.getOwnerId(), OffsetDateTime.now().plusDays(2));
        res = controller.updateOwner(ControllerMapper.ownerModelToDto(updated));

        assertThat(res.getBirthDate()).isEqualTo(updated.getBirthDate());
    }

    @Test
    void findByIdTest() {
        OwnerModel dto = new OwnerModel(null, OffsetDateTime.now());
        OwnerDto res = controller.addOwner(ControllerMapper.ownerModelToDto(dto));
        dto.setOwnerId(res.getOwnerId());
        res = controller.findById(res.getOwnerId());
        assertThat(res).isNotNull();
        assertThat(res.getOwnerId()).isEqualTo(dto.getOwnerId());
    }

    @Test
    void deleteTest() {
        OwnerModel dto = new OwnerModel(null, OffsetDateTime.now());
        OwnerDto res = controller.addOwner(ControllerMapper.ownerModelToDto(dto));
        dto.setOwnerId(res.getOwnerId());
        controller.deleteOwner(res);
        res = controller.findById(dto.getOwnerId());
        assertThat(res).isNull();
    }
}
