package com.example.application.views.person;

import com.example.application.person.Person;
import com.example.application.person.PersonRepository;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;

@Route(value = "person", layout = MainLayout.class)
@PageTitle("Person")
public class PersonView extends VerticalLayout {


    public PersonView(PersonRepository repository) {
        setSizeFull();

        Grid<Person> grid = new Grid<>();
        grid.setItems(VaadinSpringDataHelpers.fromPagingRepository(repository));

        grid.addColumn(Person::getId, "id").setHeader("Id");
        grid.addColumn(Person::getFirstName, "firstName").setHeader("First name");
        grid.addColumn(Person::getLastName, "lastName").setHeader("Last name");

        add(grid);
    }
}
