package br.ufc.quixada.predemanda.bo;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.exception.BusinessLogicException;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.model.Pessoa;
import br.ufc.quixada.predemanda.service.AlunoService;
import br.ufc.quixada.predemanda.service.CoordenadorService;
import br.ufc.quixada.predemanda.service.PessoaService;

@Component
public class PessoaBO {

	private PessoaService pessoaService;
	private CoordenadorService coordenadorService;
	private AlunoService alunoService;

	public PessoaBO(PessoaService pessoaService, CoordenadorService coordenadorService, AlunoService alunoService) {
		this.pessoaService = pessoaService;
		this.coordenadorService = coordenadorService;
		this.alunoService = alunoService;
	}
	
	public Pessoa autenticar(String email, String senha) throws BusinessLogicException, ConnectionException{
			List<Pessoa> pessoas = pessoaService.listarPessoas();
			Logger logger = Logger.getLogger(PessoaBO.class);
			logger.debug("Email e Senha digitados: " + email + " - " + senha);
			for (Pessoa pessoa : pessoas) {
				if (pessoa.getEmail().equals(email) && pessoa.getSenha().equals(senha)){
					pessoa.setCoordenador(coordenadorService.recuperarCoordenador(pessoa.getId()));
					pessoa.setAluno(alunoService.recuperarAluno(pessoa.getId()));
					return pessoa;
				}
			}
			throw new BusinessLogicException("Usuário ou senha incorreto.");
	}
	
}
