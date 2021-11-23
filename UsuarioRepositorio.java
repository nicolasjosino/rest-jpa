package br.edu.uni7.tecnicas.restjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
	public Usuario findByLogin(String login);
}
