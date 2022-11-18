package com.bbasset.inova.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbasset.inova.model.Cota;
import com.bbasset.inova.service.CotaService;

@RestController
@RequestMapping("/cotas")
public class CotaController {
	
	CotaService cotaService = new CotaService();

	
	@GetMapping("/historico")
	public List<Cota> getHistoricoCotaTodosFundos() {

		return cotaService.getHistoricoCotaTodosFundos();
	}
	
	@GetMapping("/historico/{codigoFundo}")
	public List<Cota> getHistoricoCotaFundo(@PathVariable Long codigoFundo) {

		return cotaService.getHistoricoCotaFundo(codigoFundo);
	}
	
}