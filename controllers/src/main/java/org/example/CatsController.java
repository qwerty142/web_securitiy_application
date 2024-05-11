package org.example;

import lombok.RequiredArgsConstructor;
import org.example.dto.CatDto;
import org.example.dto.CatModel;
import org.example.mappers.ControllerMapper;
import org.example.services.ICatsService;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;
import java.util.List;

//TODO add Mappers and Make Ent Like Body

@RequiredArgsConstructor
@RestController
@RequestMapping("/cats")
public class CatsController {
    private final ICatsService service;
    @PostMapping
    @PreAuthorize("#catDto.getOwnerId_() == principal.owners.ownerId")
    public CatDto add(@RequestBody CatDto catDto) {
        System.out.println(catDto.getOwnerId_());
        System.out.println("---------------------------------------------------------------------");
        return ControllerMapper.catModelToDto(service.addCat(ControllerMapper.catDtoToModel(catDto)));
    }

    @PatchMapping
    @PreAuthorize("principal.owners.ownerId == #catDto.ownerId_")
    public CatDto updateCat(@RequestBody CatDto catDto) {
        return ControllerMapper.catModelToDto(service.updateCat(ControllerMapper.catDtoToModel(catDto)));
    }
    @DeleteMapping
    @PreAuthorize("principal.owners.ownerId == #catDto.ownerId_")
    public CatDto deleteCat(@RequestBody CatDto catDto) throws InvalidObjectException {
        return ControllerMapper.catModelToDto(service.deleteCat(ControllerMapper.catDtoToModel(catDto)));
    }
    @GetMapping("/{id}")
    @PreAuthorize("principal.owners.ownerId == #id")
    public CatDto findById(@PathVariable("id") Long id) {
        return ControllerMapper.catModelToDto(service.findById(id));
    }
    @GetMapping
    @PostFilter("principal.owners.ownerId == filterObject.ownerId_")
    public List<CatDto> findAll() {
        return service.findAll().stream().map(ControllerMapper::catModelToDto).toList();
    }
    @PostMapping("/friend/{toId}/{friendId}")
    public CatDto addFriend(@PathVariable("toId") Long toId, @PathVariable("friendId") Long friendId) {
        return ControllerMapper.catModelToDto(service.addFriend(toId, friendId));
    }
    @DeleteMapping("/friend/{toId}/{friendId}")
    public CatDto deleteFriend(Long toId, Long friendId) {
        return ControllerMapper.catModelToDto(service.deleteFriend(toId, friendId));
    }
}
