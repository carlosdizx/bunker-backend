package bunker.servicios.api;

import bunker.entidad.Invoice;

import java.util.List;

public interface IInvoiceService
{
    Invoice save(Invoice entity);

    List<Invoice> getAll();
}
