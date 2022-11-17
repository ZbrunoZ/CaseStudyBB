package com.bbasset.inova.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bbasset.inova.model.Fundo;
import com.bbasset.inova.utils.CSVReader;

public class FundoService {
	
	
	private CSVReader reader = new CSVReader();
	
	
	public List<Fundo> listaFundos() {


		List<Fundo> fundos = new ArrayList<>();

		try {
			
			fundos = reader.carregaFundosDoCSV();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
				
		
		return fundos;
	}

}
