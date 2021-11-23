package br.edu.uni7.tecnicas.restjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioBusinessImpl implements UsuarioBusiness {
	@Autowired
	private UsuarioRepositorio repository;
	
	@Override
	public boolean autenticar(String login, String senha) {
		boolean result = false;
		
		Usuario usuario = repository.findByLogin(login);
		
		if (usuario != null) {
			if (usuario.getSenha().equals(senha)) {
				result = true;
			}
		}
		
		return result;
	}

	@Override
	public void salvar(Usuario usuario) {
		repository.save(usuario);
		
	}	

}
