package org.example;

import lombok.RequiredArgsConstructor;
import org.example.dto.CatDto;
import org.example.dto.CatModel;
import org.example.dto.OwnerDto;
import org.example.dto.OwnerModel;
import org.example.mappers.ControllerMapper;
import org.example.services.IOwnersService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidObjectException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/owners")
public class OwnersController {
    private final IOwnersService service;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public OwnerDto addOwner(@RequestBody OwnerDto owners) {
        return ControllerMapper.ownerModelToDto(service.addOwner(ControllerMapper.ownerDtoToModel(owners)));
    }

    @PatchMapping
    @PreAuthorize("hasAuthority('ADMIN') || principal.owners.ownerId == #owners.ownerId")
    public OwnerDto updateOwner(@RequestBody OwnerDto owners) {
        return ControllerMapper.ownerModelToDto(service.updateOwner(ControllerMapper.ownerDtoToModel(owners)));
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public OwnerDto deleteOwner(@RequestBody OwnerDto owners) throws InvalidObjectException {
        return ControllerMapper.ownerModelToDto(service.deleteOwner(ControllerMapper.ownerDtoToModel(owners)));
    }

    @GetMapping("/{id}")
    @PreAuthorize("principal.owners.ownerId == #id")
    public OwnerDto findById(@PathVariable("id") Long id) {
        return ControllerMapper.ownerModelToDto(service.findById(id));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<OwnerDto> findAll() {
        return service.findAll().stream().map(ControllerMapper::ownerModelToDto).toList();
    }
    @GetMapping("/getCats/{ownerId}")
    @PostFilter("filterObject.ownerId == principal.owners.ownerId")
    public List<CatDto> findAllOwnedCats(@PathVariable("ownerId") Long ownerId) {
        return service.findAllOwnedCats(ownerId).stream().map(ControllerMapper::catModelToDto).toList();
    }
}
