package com.example.algamoneyapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoneyapi.Repository.Lancamento.LancamentoRepositoryQuery;
import com.example.algamoneyapi.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery{

}
