package bunker.dao;

import bunker.entidad.Sale;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SaleDao extends JpaRepository<Sale, Integer>
{

}
