package bunker.servicios.impl;

import bunker.dao.InvoiceDao;
import bunker.entidad.Invoice;
import bunker.servicios.api.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements IInvoiceService
{
    @Autowired
    private InvoiceDao dao;

    @Override
    public Invoice save(Invoice entity)
    {
        return dao.save(entity);
    }

    @Override
    public List<Invoice> getAll()
    {
        return dao.findAll();
    }
}
