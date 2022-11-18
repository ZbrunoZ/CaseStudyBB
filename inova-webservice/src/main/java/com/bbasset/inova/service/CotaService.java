package com.bbasset.inova.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bbasset.inova.model.Cota;
import com.bbasset.inova.utils.CSVReader;

public class CotaService {
	
	
	private CSVReader reader = new CSVReader();
	
	
	public List<Cota> getHistoricoCotaTodosFundos() {


		List<Cota> cotas = new ArrayList<>();

		try {
			
			cotas = reader.carregaCotasDoCSV();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
				
		
		return cotas;
	}
	
	
	public List<Cota> getHistoricoCotaFundo(Long codigoFundo) {


		List<Cota> historicoCotasFundo = new ArrayList<>();
		
		List<Cota> historicoCotas = getHistoricoCotaTodosFundos();
		
		for (Cota cota : historicoCotas) {
			
			if (cota.getFundo().getCodigo().equals(codigoFundo))
				historicoCotasFundo.add(cota);
			
		}
		
		

		return historicoCotasFundo;
	}

}
