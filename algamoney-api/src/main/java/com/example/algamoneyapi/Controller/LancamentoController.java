package com.example.algamoneyapi.Controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoneyapi.Repository.LancamentoRepository;
import com.example.algamoneyapi.Repository.filter.LancamentoFilter;
import com.example.algamoneyapi.evento.RecursoCriadoEvent;
import com.example.algamoneyapi.exceptionhandler.AlgamoneyExceptionHandler.Erro;
import com.example.algamoneyapi.model.Lancamento;
import com.example.algamoneyapi.service.LancamentoService;
import com.example.algamoneyapi.service.Exception.PessoaInexistenteOuInativaException;


@RestController
@RequestMapping("/lancamento")
public class LancamentoController {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public Page<Lancamento> pesquisar(LancamentoFilter lancamentoFilter, Pageable pageable){
		return lancamentoRepository.filtrar(lancamentoFilter, pageable);
	}
	@PostMapping
	public ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response){
		Lancamento lancamentoSalvo = lancamentoService.salvar(lancamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}
	@ExceptionHandler({PessoaInexistenteOuInativaException.class})
	public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException ex){
	String mensagemUsuario = messageSource.getMessage("pessoa.inexistente-ou-inativa", null,LocaleContextHolder.getLocale());
	String mensagemDesenvolvedor = ex.toString();
	List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
	return ResponseEntity.badRequest().body(erros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Lancamento> buscarPeloId(@PathVariable Long id) {
		return lancamentoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		lancamentoRepository.deleteById(id);
	}
	
}
