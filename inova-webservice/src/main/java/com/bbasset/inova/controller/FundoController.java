package com.bbasset.inova.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbasset.inova.model.Fundo;
import com.bbasset.inova.service.FundoService;

@RestController
public class FundoController {

	
	@GetMapping("/fundos")
	public List<Fundo> listaTodosFundos() {

		FundoService fundoService = new FundoService();
		
		return fundoService.listaFundos();
	}
}