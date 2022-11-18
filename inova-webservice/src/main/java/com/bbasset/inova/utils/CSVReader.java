package com.bbasset.inova.utils;

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

public class CSVReader {

	private static final String CAMINHO_ARQUIVO = "src\\main\\resources\\arquivos\\";


	public List<Fundo> carregaFundosDoCSV() throws IOException {

		
		Path caminhoArquivo = Paths.get(CAMINHO_ARQUIVO + "fundos.csv");
		List<Fundo> fundos = new ArrayList<>();

		// create an instance of BufferedReader
		// using try with resource, Java 7 feature to close resources

		try (BufferedReader br = Files.newBufferedReader(caminhoArquivo, StandardCharsets.ISO_8859_1)) {

			// read the second line from the text file
			Stream<String> linhas = br.lines().skip(1);

			linhas.forEachOrdered(linha -> {

				String[] atributos = linha.split(";");

				try {

					Fundo fundo = instanciaFundo(atributos);
					fundos.add(fundo);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});

		}

		return fundos;

	}

	public Fundo instanciaFundo(String[] metadata) throws ParseException {

		Long codigo = Long.parseLong(metadata[0]);
		String nome = metadata[1];
		String cnpj = metadata[2];
		String dataAbertura = metadata[3];
		String dataEncerramento = metadata[4];
		String risco = metadata[5];

		return new Fundo(codigo, nome, cnpj, dataAbertura, dataEncerramento, risco);

	}
	
	public List<Cota> carregaCotasDoCSV() throws IOException {

		Path caminhoArquivo = Paths.get(CAMINHO_ARQUIVO + "cotas.csv");
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
		Fundo fundo = getFundo( Long.parseLong( metadata[1] ) );
		BigDecimal cota = new BigDecimal(metadata[2].replace(",", "."));

		return new Cota(data, fundo, cota);

	}
	
	private Fundo getFundo(Long codigoFundo) throws IOException {
		
		
		List<Fundo> fundos = carregaFundosDoCSV();
		
		for (Fundo fundo : fundos) {
			
			if(fundo.getCodigo().equals(codigoFundo))
				return fundo;
			
		}
		
		return null;
		
		
	}

	
}
