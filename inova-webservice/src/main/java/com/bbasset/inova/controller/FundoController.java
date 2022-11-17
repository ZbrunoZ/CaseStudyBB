package com.bbasset.inova.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbasset.inova.model.Fundo;
import com.bbasset.inova.service.FundoService;

@RestController
@RequestMapping("/fundos")
@CrossOrigin(origins = "http://localhost:4200/")
public class FundoController {

	
	FundoService fundoService = new FundoService();
	
	@GetMapping("/")
	public List<Fundo> listaTodosFundos() {

		return fundoService.listaFundos();
	}
	
	@GetMapping("/ativos/")
	public List<Fundo> listaFundosAtivos() {

		return fundoService.listaFundosAtivos();
	}

	
	@GetMapping("/{codigoFundo}")
	public Fundo getFundo(@PathVariable Long codigoFundo) throws IOException {

		return fundoService.getFundo(codigoFundo);
		
	}

}