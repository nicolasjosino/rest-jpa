package br.edu.uni7.tecnicas.restjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uni7.tecnicas.restjpa.Usuario.StatusType;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
	public Usuario findByLogin(String login);
	public Usuario findByLoginAndStatus(String login, StatusType status);
}
