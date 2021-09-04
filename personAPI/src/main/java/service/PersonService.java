package service;

import DTO.MessageResponseDTO;
import DTO.PersonDTO;
import entity.Person;
import lombok.AllArgsConstructor;
import mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import repository.PersonRepository;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {


        private PersonRepository personRepository;

        private final PersonMapper personMapper = PersonMapper.INSTANCE;

        public MessageResponseDTO createPerson(PersonDTO personDTO) {
            Person personToSave = personMapper.toModel(personDTO);

            Person savedPerson = personRepository.save(personToSave);
            return createMessageResponse(savedPerson.getId(), "Created person with ID ");
        }

        public List<PersonDTO> listAll() {
            List<Person> allPeople = personRepository.findAll();
            return allPeople.stream()
                    .map(personMapper::toDTO)
                    .collect(Collectors.toList());
        }

        public PersonDTO findById(Long id) throws PersonNotFoundException {
            Person person = verifyIfExists(id);

            return personMapper.toDTO(person);
        }

        public void delete(Long id) throws PersonNotFoundException {
            verifyIfExists(id);
            personRepository.deleteById(id);
        }

        public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
            verifyIfExists(id);

            Person personToUpdate = personMapper.toModel(personDTO);

            Person updatedPerson = personRepository.save(personToUpdate);
            return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
        }

        private Person verifyIfExists(Long id) throws PersonNotFoundException {
            return personRepository.findById(id)
                    .orElseThrow(() -> new PersonNotFoundException(id));
        }

        private MessageResponseDTO createMessageResponse(Long id, String message) {
            return MessageResponseDTO
                    .builder()
                    .message(message + id)
                    .build();
        }
    }
