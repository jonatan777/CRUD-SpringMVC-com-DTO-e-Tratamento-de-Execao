package br.com.jonatan.principal.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.jonatan.principal.model.modelo.Contact;
import lombok.Getter;

@Getter
public class ContactDTO {
		
	    private Long id;
	    
	    @NotBlank(message = "{name.not.blank}")
        private String name;
	    
	    @Email(message = "{email.not.valid}")
	    @NotBlank(message = "{email.not.blank}")
	    private String email;
	    
	    @NotBlank(message = "{phone.not.blank}")
	    private String phone;

	    
	    public Contact transformaParaObjeto(){
	        return new Contact(name, email, phone);
	    }
	    
	    
}




