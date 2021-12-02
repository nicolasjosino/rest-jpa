package br.edu.uni7.tecnicas.restjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uni7.tecnicas.restjpa.business.UsuarioBusinessImpl;
import br.edu.uni7.tecnicas.restjpa.entity.Usuario;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioBusinessImpl business;

	@PostMapping(path = "/usuario")
	public Usuario cadastrar(String login, String senha) {
		Usuario usuario = new Usuario(null, login, senha);
		
		business.salvar(usuario);
		
		return usuario;
	}
	
	@PostMapping(path = "/autenticar")
	public Boolean autenticar(@RequestParam String login, 
							  @RequestParam String senha) {
		return business.autenticar(login, senha);
	}
}
