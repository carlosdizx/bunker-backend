package bunker.servicios.impl;

import bunker.dao.SaleDao;
import bunker.entidad.Invoice;
import bunker.entidad.Sale;
import bunker.servicios.api.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService
{
    @Autowired
    private SaleDao dao;

    @Override
    public Sale save(Sale entity)
    {
        return dao.save(entity);
    }

    @Override
    public void delete(Integer id)
    {
        dao.deleteById(id);
    }

    @Override
    public Sale findByID(Integer id)
    {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Sale> getAll()
    {
        return dao.findAll();
    }
}
