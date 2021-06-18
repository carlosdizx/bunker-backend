package bunker.service.impl;

import bunker.dao.ProductDao;
import bunker.entidad.Product;
import bunker.service.api.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService
{
    @Autowired
    private ProductDao dao;

    @Override
    public Product save(Product entity)
    {
        return dao.save(entity);
    }

    @Override
    public void delete(Integer id)
    {
        dao.deleteById(id);
    }

    @Override
    public Product findByID(Integer id)
    {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll()
    {
        return dao.findAll();
    }
}
