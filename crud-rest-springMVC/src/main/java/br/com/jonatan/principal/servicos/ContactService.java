package br.com.jonatan.principal.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jonatan.principal.model.modelo.Contact;
import br.com.jonatan.principal.model.repositorio.ContactRepository;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact salvar(Contact contact) {
        return contactRepository.save(contact);
    }
}
