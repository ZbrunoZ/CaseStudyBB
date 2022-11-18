package com.bbasset.inova.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bbasset.inova.dao.CotaDao;
import com.bbasset.inova.model.Cota;

public class CotaService {
	
	
	private CotaDao cotaDao = new CotaDao();

	
	
	public List<Cota> getHistoricoCotaTodosFundos() {


		List<Cota> cotas = new ArrayList<>();

		try {
			
			cotas = cotaDao.carregaCotasDoCSV();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
				
		
		return cotas;
	}
	
	
	public List<Cota> getHistoricoCotaFundo(Long codigoFundo) throws IOException {

		return cotaDao.getHistoricoCotaFundo(codigoFundo);
	}

}
