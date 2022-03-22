package com.example.application.person;

import com.vaadin.flow.data.provider.CallbackDataProvider;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;

public interface LazyProvider {

    static <DTO> CallbackDataProvider.FetchCallback<DTO, Void> fromPagingService(LazyProviderService<DTO> service) {
        return query -> service.findAll(VaadinSpringDataHelpers.toSpringPageRequest(query)).stream();
    }
}
