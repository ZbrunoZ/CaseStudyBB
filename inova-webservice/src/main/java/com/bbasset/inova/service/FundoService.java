package com.bbasset.inova.service;

import java.io.IOException;
import java.util.List;

import com.bbasset.inova.dao.FundoDao;
import com.bbasset.inova.model.Fundo;

public class FundoService {

	private FundoDao fundoDao = new FundoDao();

	
	public List<Fundo> listaFundos() {

		return fundoDao.listaFundos();
	}

	public Fundo getFundo(Long codigoFundo) throws IOException {
		
		return fundoDao.getFundo(codigoFundo);
	}

}
