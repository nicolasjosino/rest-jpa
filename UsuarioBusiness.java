package br.edu.uni7.tecnicas.restjpa;

import org.springframework.stereotype.Service;

@Service
public interface UsuarioBusiness {
	public boolean autenticar(String login, String senha);
	public void salvar(Usuario usuario);
}
