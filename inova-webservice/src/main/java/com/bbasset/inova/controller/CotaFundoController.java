package com.bbasset.inova.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbasset.inova.model.CotaFundo;
import com.bbasset.inova.service.CotaFundoService;

@RestController
@RequestMapping("/cotas")
public class CotaFundoController {
	
	CotaFundoService cotaFundoService = new CotaFundoService();

	
	@GetMapping("/historico")
	public List<CotaFundo> getHistoricoCotaTodosFundos() {

		return cotaFundoService.getHistoricoCotaTodosFundos();
	}
	
	@GetMapping("/historico/{codigoFundo}")
	public List<CotaFundo> getHistoricoCotaFundo(@PathVariable Long codigoFundo) {

		return cotaFundoService.getHistoricoCotaFundo(codigoFundo);
	}
	
}