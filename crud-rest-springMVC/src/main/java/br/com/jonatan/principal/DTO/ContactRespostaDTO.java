package br.com.jonatan.principal.DTO;

import br.com.jonatan.principal.model.modelo.Contact;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ContactRespostaDTO {
	
    private String name;
    private String email;
    
    
    public static ContactRespostaDTO transformaEmDTO(Contact contact) {
        return new ContactRespostaDTO(contact.getName(),contact.getEmail());
    }

}
