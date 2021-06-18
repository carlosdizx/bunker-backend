package bunker.dao;

import bunker.entidad.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDao extends JpaRepository<Invoice,Integer>
{

}
