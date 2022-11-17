package com.bbasset.inova.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bbasset.inova.model.CotaFundo;
import com.bbasset.inova.utils.CSVReader;

public class CotaFundoService {
	
	
	private CSVReader reader = new CSVReader();
	
	
	public List<CotaFundo> getHistoricoCotaTodosFundos() {


		List<CotaFundo> cotas = new ArrayList<>();

		try {
			
			cotas = reader.carregaCotasDoCSV();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
				
		
		return cotas;
	}
	
	
	public List<CotaFundo> getHistoricoCotaFundo(Long codigoFundo) {


		List<CotaFundo> historicoCotasFundo = new ArrayList<>();
		
		List<CotaFundo> historicoCotas = getHistoricoCotaTodosFundos();
		
		for (CotaFundo cotaFundo : historicoCotas) {
			
			if (cotaFundo.getFundo().getCodigo().equals(codigoFundo))
				historicoCotasFundo.add(cotaFundo);
			
		}
		
		

		return historicoCotasFundo;
	}

}
