package bunker.dao;

import bunker.entidad.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person,Integer>
{
}
