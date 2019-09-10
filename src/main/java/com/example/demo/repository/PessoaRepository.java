package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
