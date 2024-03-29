package br.com.jonatan.principal.controlers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonatan.principal.DTO.ContactDTO;
import br.com.jonatan.principal.DTO.ContactRespostaDTO;
import br.com.jonatan.principal.model.modelo.Contact;
import br.com.jonatan.principal.model.repositorio.ContactRepository;
import br.com.jonatan.principal.servicos.ContactService;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {

   private ContactRepository repository;

   ContactController(ContactRepository contactRepository) {
       this.repository = contactRepository;
   }
   
   @Autowired
   private  ContactService contactService;
   
   
   
   
   //buscar todos registros no banco
   @GetMapping
   public List<Contact> findAll(){
      return repository.findAll();
   }
   
   
   
   //busca com id do registro
   @GetMapping(path = {"/{id}"})
   public ResponseEntity<?> findById(@PathVariable long id){
	   
      return repository.findById(id)
              .map(record -> ResponseEntity.ok().body(record))
              .orElse(ResponseEntity.notFound().build());
   }
   
   
   
   
        //salvar registro no banco
   @PostMapping
   public ResponseEntity<ContactRespostaDTO> salvar(@RequestBody @Valid ContactDTO dto) {
       Contact contact = contactService.salvar(dto.transformaParaObjeto());
       return new ResponseEntity<>(ContactRespostaDTO.transformaEmDTO(contact), HttpStatus.CREATED);
   }
   
   
   
     
   
          //atualizar registro do banco
   @PutMapping(value="/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Contact contact) {
	   
      return repository.findById(id)
              .map(record -> {
                  record.setName(contact.getName());
                  record.setEmail(contact.getEmail());
                  record.setPhone(contact.getPhone());
                  
                  Contact updated = repository.save(record);
                  return ResponseEntity.ok().body(updated);
              }).orElse(ResponseEntity.notFound().build());
   }
   
   
     //deletando registro do banco
   @DeleteMapping(path ={"/{id}"})
   public ResponseEntity<?> delete(@PathVariable long id) {
      return repository.findById(id)
              .map(record -> {
                  repository.deleteById(id);
                  return ResponseEntity.ok().build();
              }).orElse(ResponseEntity.notFound().build());
   }
   
   
   
} 