package br.edu.uni7.tecnicas.restjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.uni7.tecnicas.restjpa.Usuario.StatusType;

@Component
public class UsuarioBusinessImpl implements UsuarioBusiness {
	@Autowired
	private UsuarioRepositorio repository;
	
	@Override
	public boolean autenticar(String login, String senha) {
		boolean result = false;
		
//		Usuario usuario = repository.findByLogin(login);
		Usuario usuario = repository.findByLoginAndStatus(login, StatusType.Ativo);
		
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
