package com.bbasset.inova.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bbasset.inova.dao.FundoDao;
import com.bbasset.inova.model.Fundo;

public class FundoService {

	private FundoDao fundoDao = new FundoDao();

	public List<Fundo> listaFundos() {

		return fundoDao.listaFundos();
	}

	public List<Fundo> listaFundosAtivos() {

		List<Fundo> fundos = this.listaFundos();

		List<Fundo> fundosAtivos = new ArrayList<>();

		for (Fundo fundo : fundos) {

			if (fundo.getDataEncerramento().isEmpty())
				fundosAtivos.add(fundo);

		}

		return fundosAtivos;
	}

	public Fundo getFundo(Long codigoFundo) throws IOException {

		return fundoDao.getFundo(codigoFundo);
	}

	public List<String> listaFundosSugeridos(String perfil) {

		List<String> nomesFundos = new ArrayList<>();

		List<Fundo> fundos = this.listaFundosAtivos();

		switch (perfil) {
		case "conservador":
			
			nomesFundos = getFundosConservadores(fundos);
			break;
		case "moderado":
			
			nomesFundos = getFundosModerados(fundos);
			break;
		case "arrojado":
			
			nomesFundos = getFundosArrojados(fundos);
			break;

		default:
			break;
		}
		
		


		return nomesFundos;
	}

	private List<String> getFundosConservadores(List<Fundo> fundos) {

		List<String> nomesFundos = new ArrayList<>();

		for (Fundo fundo : fundos) {

			if (fundos.indexOf(fundo) <= 2)
				nomesFundos.add(fundo.getNome());

		}

		return nomesFundos;

	}
	
	private List<String> getFundosModerados(List<Fundo> fundos) {

		List<String> nomesFundos = new ArrayList<>();

		for (Fundo fundo : fundos) {

			if (fundos.indexOf(fundo) >= 1 && fundos.indexOf(fundo) <= 3)
				nomesFundos.add(fundo.getNome());

		}

		return nomesFundos;

	}
	
	private List<String> getFundosArrojados(List<Fundo> fundos) {

		List<String> nomesFundos = new ArrayList<>();

		for (Fundo fundo : fundos) {

			if (fundos.indexOf(fundo) >= 2 && fundos.indexOf(fundo) <= 4)
				nomesFundos.add(fundo.getNome());

		}

		return nomesFundos;

	}

}
