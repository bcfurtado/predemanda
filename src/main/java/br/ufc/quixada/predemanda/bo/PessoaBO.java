package br.ufc.quixada.predemanda.bo;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.exception.BusinessLogicException;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.model.Pessoa;
import br.ufc.quixada.predemanda.service.AlunoService;
import br.ufc.quixada.predemanda.service.CoordenadorService;
import br.ufc.quixada.predemanda.service.PessoaService;

public class PessoaBO {

	private PessoaService pessoaService;
	private CoordenadorService coordenadorService;
	private AlunoService alunoService;

	public PessoaBO() {
		this.pessoaService = new PessoaService();
		this.coordenadorService = new CoordenadorService();
		this.alunoService = new AlunoService();
	}
	
	public Pessoa autenticar(String login, String senha) throws BusinessLogicException, ConnectionException{
			List<Pessoa> pessoas = pessoaService.listarPessoas();
			for (Pessoa pessoa : pessoas) {
				if (pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)){
					pessoa.setCoordenador(coordenadorService.recuperarCoordenador(pessoa.getId()));
					pessoa.setAluno(alunoService.recuperarAluno(pessoa.getId()));
					return pessoa;
				}
			}
			throw new BusinessLogicException("Usuário ou senha incorreto.");
	}
	
}
