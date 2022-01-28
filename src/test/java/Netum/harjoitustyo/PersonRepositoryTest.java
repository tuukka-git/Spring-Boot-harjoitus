package Netum.harjoitustyo;

import Netum.harjoitustyo.person.Person;
import Netum.harjoitustyo.person.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void add() {
        personRepository.save(new Person("Tuukka", "Lahtinen", 22));
        System.out.println(personRepository.findAll());

    }
}
