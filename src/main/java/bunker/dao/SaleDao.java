package bunker.dao;

import bunker.entidad.Invoice;
import bunker.entidad.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleDao extends JpaRepository<Sale, Integer>
{
}
