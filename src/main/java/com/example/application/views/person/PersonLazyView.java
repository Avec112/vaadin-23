package com.example.application.views.person;

import com.example.application.person.*;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@RouteAlias(value = "", layout = MainLayout.class)
@Route(value = "person-lazy", layout = MainLayout.class)
@PageTitle("Person lazy load")
public class PersonLazyView extends VerticalLayout {


    public PersonLazyView(PersonService service) {
        setSizeFull();

        Grid<PersonDto> grid = new Grid<>();
        grid.setItems(LazyProvider.fromPagingService(service)); // lazy loading

        grid.addColumn(PersonDto::getFirstName, "firstName").setHeader("First name");
        grid.addColumn(PersonDto::getLastName, "lastName").setHeader("Last name");

        add(grid);
    }
}
