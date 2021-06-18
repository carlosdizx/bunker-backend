package bunker.servicios.impl;

import bunker.dao.PersonDao;
import bunker.entidad.Person;
import bunker.servicios.api.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonService
{
    @Autowired
    private PersonDao dao;

    @Override
    public Person save(Person entity)
    {
        return dao.save(entity);
    }

    @Override
    public void delete(Integer id)
    {
        dao.deleteById(id);
    }

    @Override
    public Person findByID(Integer id)
    {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAll()
    {
        return dao.findAll();
    }
}
