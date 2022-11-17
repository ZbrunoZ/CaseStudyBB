package com.bbasset.inova.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.bbasset.inova.model.Fundo;

public class FundoDao {

	private static final String CAMINHO_ARQUIVO = "src\\main\\resources\\arquivos\\fundos.csv";

	
	public List<Fundo> listaFundos() {

		List<Fundo> fundos = new ArrayList<>();

		try {

			fundos = this.carregaFundosDoCSV();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return fundos;
	}

	public Fundo getFundo(Long codigoFundo) throws IOException {

		List<Fundo> fundos = listaFundos();

		for (Fundo fundo : fundos) {

			if (fundo.getCodigo().equals(codigoFundo))
				return fundo;

		}

		return null;

	}

	public List<Fundo> carregaFundosDoCSV() throws IOException {

		Path caminhoArquivo = Paths.get(CAMINHO_ARQUIVO);
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

}
