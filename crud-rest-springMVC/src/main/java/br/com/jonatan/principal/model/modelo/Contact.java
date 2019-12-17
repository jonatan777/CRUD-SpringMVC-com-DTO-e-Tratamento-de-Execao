package br.com.jonatan.principal.model.modelo;

import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Contact {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String email;
   private String phone;
   
   
   public Contact(String name, String email, String phone) {
	    this.name = name;
	    this.email = email;
	    this.phone = phone;
	}
     
}
