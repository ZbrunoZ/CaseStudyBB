package com.bbasset.inova.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.bbasset.inova.model.Cota;
import com.bbasset.inova.model.Fundo;

public class CotaDao {

	private static final String CAMINHO_ARQUIVO = "src\\main\\resources\\arquivos\\cotas.csv";
	
	private FundoDao fundoDao = new FundoDao();
	
	public List<Cota> carregaCotasDoCSV() throws IOException {

		Path caminhoArquivo = Paths.get(CAMINHO_ARQUIVO);
		List<Cota> cotas = new ArrayList<>();

		// create an instance of BufferedReader
		// using try with resource, Java 7 feature to close resources

		try (BufferedReader br = Files.newBufferedReader(caminhoArquivo, StandardCharsets.ISO_8859_1)) {

			// read the second line from the text file
			Stream<String> linhas = br.lines().skip(1);

			linhas.forEachOrdered(linha -> {

				String[] atributos = linha.split(";");

				try {

					Cota cota = instanciaCota(atributos);
					cotas.add(cota);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});

		}

		return cotas;

	}
	
	private Cota instanciaCota(String[] metadata) throws ParseException, NumberFormatException, IOException {

		String data = metadata[0];
		Fundo fundo = fundoDao.getFundo( Long.parseLong( metadata[1] ) );
		BigDecimal cota = new BigDecimal(metadata[2].replace(",", "."));

		return new Cota(data, fundo, cota);

	}
	

	public List<Cota> listaHistoricoCotaFundos() {

		List<Cota> cotas = new ArrayList<>();

		try {

			cotas = this.carregaCotasDoCSV();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return cotas;
	}
	
	public List<Cota> getHistoricoCotaFundo(Long codigoFundo) throws IOException {


		List<Cota> historicoCotasFundo = new ArrayList<>();
		
		List<Cota> historicoCotas = this.carregaCotasDoCSV();
		
		for (Cota cota : historicoCotas) {
			
			if (cota.getFundo().getCodigo().equals(codigoFundo))
				historicoCotasFundo.add(cota);
			
		}
		
		

		return historicoCotasFundo;
	}

}
