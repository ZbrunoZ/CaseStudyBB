package com.bbasset.inova.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbasset.inova.model.CotaFundo;
import com.bbasset.inova.service.CotaFundoService;

@RestController
public class CotaFundoController {

	
	@GetMapping("/cotas")
	public List<CotaFundo> listaTodosFundos() {

		CotaFundoService cotaFundoService = new CotaFundoService();
		
		return cotaFundoService.listaCotaFundos();
	}
}