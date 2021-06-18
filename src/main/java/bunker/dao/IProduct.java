package bunker.dao;

import bunker.entidad.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduct extends JpaRepository<Product, Integer>
{

}
