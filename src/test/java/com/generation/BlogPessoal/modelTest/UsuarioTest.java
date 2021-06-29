package com.generation.BlogPessoal.modelTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.BlogPessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {

	Usuario user;
	
	@Autowired
	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@BeforeEach
	void start() {
		user = new Usuario("Renato Nakamura","Ryon30","12345678");
	}
	
	@Test
	void validacaoDosAtributos() {
		Set<ConstraintViolation<Usuario>> falhas = validator.validate(user);
		assertTrue(falhas.isEmpty());
	}
}
