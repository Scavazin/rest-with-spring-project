package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter : AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id : Long): Person{
        logger.info("Finding one person!")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Victor"
        person.lastName = "Siqueira"
        person.address = "Osasco - São Paulo - Brasil"
        person.gender = "Male"
        return  person
    }

    fun findAll(): List<Person>{
        logger.info("Finding all people!")

        val persons: MutableList<Person> = ArrayList()
        for (i in 0 ..7) {
        val person = mockPerson(i)
        persons.add(person)
        }
        return persons
    }

    private fun mockPerson(i:Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person Name $i"
        person.lastName = "Last name $i"
        person.address = "Some Address in Brazil"
        person.gender = "Male"
        return  person
    }
}