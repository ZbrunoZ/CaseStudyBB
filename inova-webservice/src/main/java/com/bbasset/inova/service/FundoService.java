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
			
			if(fundo.getDataEncerramento().isEmpty())
				fundosAtivos.add(fundo);
			
		}
		
		return fundosAtivos;
	}


	public Fundo getFundo(Long codigoFundo) throws IOException {
		
		return fundoDao.getFundo(codigoFundo);
	}

}
