package com.example.demo.controller;


import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Pessoa;
import com.example.demo.exception.SaveUpdateException;
import com.example.demo.exception.ContentNotFoundException;
import com.example.demo.service.PessoaService;
import com.example.demo.util.Const;
import com.example.demo.util.Help;


@CrossOrigin
@RestController
@RequestMapping(Const.ROOT + "pessoa")
public class PessoaController {
	
	@Autowired
	private Help help;

	@Autowired
	PessoaService pessoaService;
	
	// API
	// http://localhost:8088/api/pessoa/
	
	@GetMapping(value = "/{id}", headers = { Const.ACCEPT_JSON })
	public ResponseEntity<?> consultarPorId(HttpServletRequest request, @PathVariable("id") Long id) {
		Optional<Pessoa> pessoa = this.pessoaService.findById(id);
		pessoa.orElseThrow(() -> new ContentNotFoundException("Cadastro com id " + id + " não foi localizada"));
		return new ResponseEntity<>(pessoa, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/todas/", headers = { Const.ACCEPT_JSON })
	public ResponseEntity<?> consultarTodas() {
		return new ResponseEntity<>(this.pessoaService.listarPessoas(), HttpStatus.OK);		
	}

	// Cadastrar e alterar um usuario
	@PostMapping(value = "/cadastrar", headers = { Const.ACCEPT_JSON })
	public ResponseEntity<?> cadastrar(@RequestBody Pessoa pessoa) {
		try {
			return new ResponseEntity<>(pessoaService.salvar(pessoa), HttpStatus.OK);
		} catch (Exception ex) {
			throw new SaveUpdateException("Erro ao cadastrar: " + ex.getMessage());
		}
	}

	// Deletar um usuario passando o id dele
	@DeleteMapping(value = "/deletar/{id}", headers = Const.ACCEPT_JSON)
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(pessoaService.excluir(id), HttpStatus.OK);
		} catch (Exception ex) {
			throw new SaveUpdateException(ex.getMessage());
		}
	}

	@GetMapping(value = "/", headers = "Accept=text/html")
	public ResponseEntity<String> serviceIndex() {
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<String>(help.html("Esse conteúdo não pode ser acessado diretamente pelo navegador"), responseHeaders, HttpStatus.OK);
	}

}
