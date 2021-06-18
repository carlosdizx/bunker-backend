package bunker.dao;

import bunker.entidad.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer>
{

}
