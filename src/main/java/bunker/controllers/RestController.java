package bunker.controllers;

import bunker.entidad.Person;
import bunker.entidad.Product;
import bunker.entidad.Sale;
import bunker.service.api.IPersonService;
import bunker.service.api.IProductService;
import bunker.service.api.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"*"})
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/")
public class RestController
{
    //--------------------------- CONST ---------------------------
    final static Map<String, Object> RESPONSE = new HashMap<>();

    //--------------------------- Attributes ---------------------------

    @Autowired
    private IPersonService personService;

    @Autowired
    private IProductService productService;

    @Autowired
    private ISaleService saleService;

    //--------------------------- for Person ---------------------------

    @GetMapping("person/all")
    public List<Person> getAllPersons()
    {
        return personService.getAll();
    }
    
    @GetMapping("person/get/{id}")
    public ResponseEntity<Map<String, Object>> findPersonById(@PathVariable Integer id)
    {
        RESPONSE.clear();
        try
        {
            final Person person = personService.findByID(id);
            if (person == null)
            {
                RESPONSE.put("Mensaje", "Persona no encontrada");
                return new ResponseEntity<>(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Persona", person);
            return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("person/all")
    public ResponseEntity<Map<String, Object>> savePerson(@RequestBody Person pPerson)
    {
        RESPONSE.clear();
        try
        {
            final Person person = personService.save(pPerson);
            if (person == null)
            {
                RESPONSE.put("Mensaje", "No se pudo agregar a la persona");
                return new ResponseEntity<>(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Mensaje", "Se agrego a la persona con exito!");
            return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("person/get/{id}")
    public ResponseEntity<Map<String, Object>> updatePerson(@PathVariable Integer id,@RequestBody Person pPerson)
    {
        RESPONSE.clear();
        try
        {
            final Person person = personService.findByID(id);
            if (person == null)
            {
                RESPONSE.put("Mensaje", "Persona no encontrada, no se puede actualizar!");
                return new ResponseEntity<>(RESPONSE, HttpStatus.NOT_FOUND);
            }
            person.setName( pPerson.getName() );
            person.setType( pPerson.getType() );
            person.setAddress( pPerson.getAddress() );
            person.setPhone( pPerson.getPhone() );
            person.setEmail( pPerson.getEmail() );
            personService.save(person);
            RESPONSE.put("Mensaje", "Se actualizo a la persona con exito!");
            return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("person/get/{id}")
    public ResponseEntity<Map<String, Object>> removePerson(@PathVariable Integer id)
    {
        RESPONSE.clear();
        try
        {
            final Person person = personService.findByID(id);
            if (person == null)
            {
                RESPONSE.put("Mensaje", "Persona no encontrada, no se puede eliminar!");
                return new ResponseEntity<>(RESPONSE, HttpStatus.NOT_FOUND);
            }
            personService.delete(id);
            RESPONSE.put("Mensaje", "Persona eliminada");
            return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //--------------------------- for Product ---------------------------

    @GetMapping("product/all")
    public List<Product> getAllProducts()
    {
        return productService.getAll();
    }

    @GetMapping("product/get/{id}")
    public ResponseEntity<Map<String, Object>> findProdcutById(@PathVariable Integer id)
    {
        RESPONSE.clear();
        try
        {
            final Product product = productService.findByID(id);
            if (product == null)
            {
                RESPONSE.put("Mensaje", "Producto no encontrado");
                return new ResponseEntity<>(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Producto", product);
            return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("product/all")
    public ResponseEntity<Map<String, Object>> saveProduct(@RequestBody Product pProduct)
    {
        RESPONSE.clear();
        try
        {
            final Product product = productService.save(pProduct);
            if (product == null)
            {
                RESPONSE.put("Mensaje", "No se pudo agregar el producto");
                return new ResponseEntity<>(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Mensaje", "Se agrego el producto con exito!");
            return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("product/get/{id}")
    public ResponseEntity<Map<String, Object>> updateProduct(@PathVariable Integer id,@RequestBody Product pProduct)
    {
        RESPONSE.clear();
        try
        {
            final Product product = productService.findByID(id);
            if (product == null)
            {
                RESPONSE.put("Mensaje", "Producto no encontrado, no se puede actualizar!");
                return new ResponseEntity<>(RESPONSE, HttpStatus.NOT_FOUND);
            }
            product.setName( pProduct.getName() );
            product.setCostPrice( pProduct.getCostPrice() );
            product.setSalePrice( pProduct.getSalePrice() );
            productService.save(product);
            RESPONSE.put("Mensaje", "Se actualizo el producto con exito!");
            return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("product/get/{id}")
    public ResponseEntity<Map<String, Object>> removeProduct(@PathVariable Integer id)
    {
        RESPONSE.clear();
        try
        {
            final Product product = productService.findByID(id);
            if (product == null)
            {
                RESPONSE.put("Mensaje", "Producto no encontrado, no se puede eliminar!");
                return new ResponseEntity<>(RESPONSE, HttpStatus.NOT_FOUND);
            }
            productService.delete(id);
            RESPONSE.put("Mensaje", "Producto eliminado");
            return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //--------------------------- for Sale ---------------------------

    @GetMapping("sale/all")
    public List<Sale> getAllSales()
    {
        return saleService.getAll();
    }

    @GetMapping("sale/get/{id}")
    public ResponseEntity<Map<String, Object>> findSaletById(@PathVariable Integer id)
    {
        RESPONSE.clear();
        try
        {
            final Sale sale = saleService.findByID(id);
            if (sale == null)
            {
                RESPONSE.put("Mensaje", "Venta no encontrada");
                return new ResponseEntity<>(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Venta", sale);
            return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("sale/all")
    public ResponseEntity<Map<String, Object>> saveSale(@RequestBody Sale pSale)
    {
        RESPONSE.clear();
        try
        {
            final Sale sale = saleService.save(pSale);
            if (sale == null)
            {
                RESPONSE.put("Mensaje", "No se pudo agregar la venta");
                return new ResponseEntity<>(RESPONSE, HttpStatus.NOT_FOUND);
            }
            RESPONSE.put("Mensaje", "Se agrego la venta con exito!");
            return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
        }
        catch (DataAccessException e)
        {
            RESPONSE.put("Mensaje", "No se ha logrado realizar la consulta en la base de datos");
            RESPONSE.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity(RESPONSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
