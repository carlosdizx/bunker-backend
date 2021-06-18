package bunker.servicios.api;

import bunker.entidad.Person;

import java.util.List;

public interface IPersonService
{
    Person save(Person entity);

    void delete(Integer id);

    Person findByID(Integer id);

    List<Person> getAll();
}
