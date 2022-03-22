package com.example.application.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonService implements LazyProviderService<PersonDto> {
    private final PersonRepository repository;

    @Override
    public Page<PersonDto> findAll(PageRequest pageRequest) {
        Page<Person> all = repository.findAll(pageRequest);
        log.debug("Size {}", all.getSize());
        log.debug("Number {}", all.getNumber());

//        log.debug("Total elements {}", all.getTotalElements());
//        log.debug("Total pages {}", all.getTotalPages());

        return all.map(this::toDto);
    }

    private PersonDto toDto(Person person) {
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        return dto;
    }
}
