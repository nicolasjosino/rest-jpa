package br.edu.uni7.tecnicas.restjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;
	
	@PostMapping(path = "/produtos")
	public Produto criarProduto(
			@RequestParam(name="nome") String nome,
			@RequestParam(name = "preco") Double preco) {
		Produto produto = new Produto(null, nome, preco);
		
		//1 - Salvar no banco
		repository.save(produto);
		
		//2 - Retornar o produto
		return produto;
	}
	
	@GetMapping(path = "/produtos")
	public List<Produto> listarProdutos() {
		return repository.findAll();
	}
	
	@DeleteMapping(path = "/produtos/{id}")
	public Integer removerProduto(@PathVariable(name = "id") Integer id) {		
		repository.deleteById(id);
		return id;		
	}
}
