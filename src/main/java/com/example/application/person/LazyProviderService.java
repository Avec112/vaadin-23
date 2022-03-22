package com.example.application.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface LazyProviderService<DTO> {
    Page<DTO> findAll(PageRequest pageRequest);
}
