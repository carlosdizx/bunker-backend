package bunker.controllers;

import bunker.entidad.Person;
import bunker.service.api.IPersonService;
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
        System.out.println("---->"+pPerson);
        System.out.println("---->"+pPerson);
        System.out.println("---->"+pPerson);
        System.out.println("---->"+pPerson);
        final Person person = personService.save(pPerson);
        if (person == null)
        {
            RESPONSE.put("Mensaje", "No se pudo agregar a la persona");
            return new ResponseEntity<>(RESPONSE, HttpStatus.NOT_FOUND);
        }
        RESPONSE.put("Mensaje", "Se agrego a la persona con exito!");
        return new ResponseEntity<>(RESPONSE, HttpStatus.OK);
    }

    //--------------------------- for Product ---------------------------

    //--------------------------- for Sale ---------------------------
}
