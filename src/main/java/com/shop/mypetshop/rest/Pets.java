package com.shop.mypetshop.rest;

import com.shop.mypetshop.domain.Pet;
import com.shop.mypetshop.repo.PetRepository;
import com.shop.mypetshop.rest.dto.PetDto;
import com.shop.mypetshop.rest.dto.PetDtoConverter;
import com.shop.mypetshop.rest.dto.PetInsertDto;
import com.shop.mypetshop.usecase.PetInsertUseCase;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;


/**
 * Rest controller used to expose REST endpoints for operations with {@link Pet} objects.
 */
@CrossOrigin
@RestController
@RequestMapping("/pets")
public class Pets
{
    private final PetRepository repo;

    private final PetInsertUseCase petInsertUseCase;

    public Pets(final PetRepository repo, PetInsertUseCase petInsertUseCase)
    {
        this.repo = repo;
        this.petInsertUseCase = petInsertUseCase;
    }

    @GetMapping
    public Stream<PetDto> getAll()
    {
        return repo.findAll().stream()
                .map(PetDtoConverter::toPetDto);
    }

    @PostMapping
    public PetDto insert(@RequestBody PetInsertDto pet) {

        PetInsertUseCase.Response response = petInsertUseCase.insertPet(new PetInsertUseCase.Request(
                pet.getName(),
                pet.getBreedId()
        ));

        return PetDtoConverter.toPetDto(response.getPet());
    }
}
