package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Pessoa;
import com.example.demo.repository.PessoaRepository;


@Component
public class PessoaService {
	@Autowired
	PessoaRepository pessoaRepository;	
			

	public List<Pessoa> listarPessoas(){
		return this.pessoaRepository.findAll();
	}
	
	public Optional<Pessoa> findById(Long id) {
		return this.pessoaRepository.findById(id);
	}


	@Transactional
	public boolean excluir(Long idPessoa) {
		Optional<Pessoa> pessoa = this.pessoaRepository.findById(idPessoa);
		if (pessoa.isPresent()) {
			this.pessoaRepository.delete(pessoa.get());
			
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public Optional<Pessoa> salvar(Pessoa pessoa) {
		Optional<Pessoa> aPessoa = Optional.of(this.pessoaRepository.save(pessoa));
		return aPessoa;		
	}	
	
}

