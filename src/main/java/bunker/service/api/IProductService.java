package bunker.service.api;

import bunker.entidad.Product;

import java.util.List;

public interface IProductService
{
    Product save(Product entity);

    void delete(Integer id);

    Product findByID(Integer id);

    List<Product> getAll();
}
