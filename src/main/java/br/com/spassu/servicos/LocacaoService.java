package br.com.spassu.servicos;

import static br.com.spassu.utils.DataUtils.adicionarDias;

import java.util.Date;

import br.com.spassu.entidades.Filme;
import br.com.spassu.entidades.Locacao;
import br.com.spassu.entidades.Usuario;
import br.com.spassu.utils.DataUtils;

public class LocacaoService {	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar m�todo para salvar
		
		return locacao;
	}
	
	public static void main(String[] args) {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		//acao		
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//verificacao
		System.out.println(locacao.getValor() == 0);
		System.out.println(locacao.getValor());
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(locacao.getDataLocacao());
		System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		System.out.println(locacao.getDataRetorno());
	}
}