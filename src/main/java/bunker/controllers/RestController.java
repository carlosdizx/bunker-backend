package bunker.controllers;

import bunker.service.api.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:8080"})
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController
{
    final static Map<String, Object> RESPONSE = new HashMap<>();

    @Autowired
    private IPersonService personService;

    @GetMapping("/person/all")
    public List<?> getAllPersons() {
        return personService.getAll();
    }
}
