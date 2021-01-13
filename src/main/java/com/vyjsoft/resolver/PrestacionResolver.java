package com.vyjsoft.resolver;

import org.springframework.stereotype.Component;

import com.vyjsoft.model.Nomenclador;
import com.vyjsoft.model.Prestacion;
import com.vyjsoft.repository.NomencladorRepository;

@Component
public class PrestacionResolver {

	private NomencladorRepository nRepo;

	public PrestacionResolver(NomencladorRepository nRepo) {
		 
		this.nRepo = nRepo;
	}
	
	public Nomenclador getNomenclador(Prestacion pres) {
		return nRepo.findById(pres.getNomencladores().getCodigo()).orElseThrow(null);
	}
}
