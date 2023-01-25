package ec.prueba.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import ec.prueba.model.Person;
import ec.prueba.repository.Repository;
import ec.prueba.service.ImplService;

@ApplicationScoped
public class Servico implements ImplService {
    @Inject
    Repository repository;



    @Override
    public List<Person> listaPerson() {
        List<Person> persons = Person.listAll();
        return persons;
    }

    @Override
    public Person guardarClientes(Person person) {

        return person;
    }

    @Override
    public Person modificarClientes(Person person, Long id) {

        return null;
    }

    @Override
    public Person buscarClientes(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Person> listPersonAge(Integer age) {
        List<Person> personList = Person.listAll();

        return personList.stream()
                .filter(p -> p.age > age).collect(Collectors.toList());
    }
}
