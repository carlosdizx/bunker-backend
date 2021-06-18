package bunker.servicios.api;


import bunker.entidad.Sale;

import java.util.List;

public interface ISaleService
{
    Sale save(Sale entity);

    void delete(Integer id);

    Sale findByID(Integer id);

    List<Sale> getAll();
}
