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

import com.bbasset.inova.model.CotaFundo;
import com.bbasset.inova.model.Fundo;

public class CotaFundoDao {

	private static final String CAMINHO_ARQUIVO = "src\\main\\resources\\arquivos\\cotas.csv";
	
	private FundoDao fundoDao = new FundoDao();
	
	public List<CotaFundo> carregaCotasDoCSV() throws IOException {

		Path caminhoArquivo = Paths.get(CAMINHO_ARQUIVO);
		List<CotaFundo> cotas = new ArrayList<>();

		// create an instance of BufferedReader
		// using try with resource, Java 7 feature to close resources

		try (BufferedReader br = Files.newBufferedReader(caminhoArquivo, StandardCharsets.ISO_8859_1)) {

			// read the second line from the text file
			Stream<String> linhas = br.lines().skip(1);

			linhas.forEachOrdered(linha -> {

				String[] atributos = linha.split(";");

				try {

					CotaFundo cota = instanciaCota(atributos);
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
	
	private CotaFundo instanciaCota(String[] metadata) throws ParseException, NumberFormatException, IOException {

		String data = metadata[0];
		Fundo fundo = fundoDao.getFundo( Long.parseLong( metadata[1] ) );
		BigDecimal cota = new BigDecimal(metadata[2].replace(",", "."));

		return new CotaFundo(data, fundo, cota);

	}
	

	public List<CotaFundo> listaHistoricoCotaFundos() {

		List<CotaFundo> cotas = new ArrayList<>();

		try {

			cotas = this.carregaCotasDoCSV();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return cotas;
	}

}
