package bunker.service.api;

import bunker.entidad.Person;

import java.util.List;

public interface IProductService
{
    Person save(Person entity);

    void delete(Integer id);

    Person findByID(Integer id);

    List<Person> getAll();
}
