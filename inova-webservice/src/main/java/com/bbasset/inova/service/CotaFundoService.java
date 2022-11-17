package com.bbasset.inova.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bbasset.inova.model.CotaFundo;
import com.bbasset.inova.utils.CSVReader;

public class CotaFundoService {
	
	
	private CSVReader reader = new CSVReader();
	
	
	public List<CotaFundo> listaCotaFundos() {


		List<CotaFundo> cotas = new ArrayList<>();

		try {
			
			cotas = reader.carregaCotasDoCSV();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
				
		
		return cotas;
	}

}
