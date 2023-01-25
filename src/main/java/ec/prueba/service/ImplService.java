package ec.prueba.service;

import java.util.List;

import ec.prueba.model.Person;

public interface ImplService {

    List<Person> listaPerson();
    Person guardarClientes(Person person);
    Person modificarClientes(Person person,Long id);
    Person buscarClientes(Long id);
    List<Person> listPersonAge(Integer age);

}
