package Netum.harjoitustyo.person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public List<Person> allPersons() {
        return personRepository.findAll();
    }

    @PostMapping("/person")
    public ResponseEntity<Person> newPerson(@RequestBody Person person) {
        try {
            return new ResponseEntity<>(personRepository.save(
                    new Person(
                            person.getFirstname(),
                            person.getLastname(),
                            person.getAge())),
                    HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        try {
            Person person = personRepository.findById(id).get();
            return new ResponseEntity<>(person, HttpStatus.FOUND);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        try {
            Person person = personRepository.findById(id).get();
            personRepository.deleteById(id);
            return new ResponseEntity<>(person, HttpStatus.FOUND);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}

