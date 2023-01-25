package ec.prueba.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import ec.prueba.model.Person;

@ApplicationScoped
public class Repository implements PanacheRepository<Person> {


}
