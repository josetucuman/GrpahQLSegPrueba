package com.vyjsoft.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.vyjsoft.model.Nomenclador;
import com.vyjsoft.model.Prestacion;
import com.vyjsoft.repository.NomencladorRepository;
import com.vyjsoft.repository.PrestacionRepository;

@Component
public class Query implements GraphQLQueryResolver {

	private NomencladorRepository nRepo;
	private PrestacionRepository pRepo;
	
	@Autowired
	public Query(NomencladorRepository nRepo, PrestacionRepository pRepo) {
		
		this.nRepo = nRepo;
		this.pRepo = pRepo;
	}
	
	public Iterable<Nomenclador> findAllNomenclador(){
		return nRepo.findAll();
	}
	
	public Iterable<Prestacion> findAllPrestaciones(){
		return pRepo.findAll();
	}
	
	public Prestacion findPrestacionId(Long idPres) {
		return pRepo.findById(idPres).orElseGet(null);
	}
	
	public Long countNomenclador() {
		return nRepo.count();
	}
	
	public Long countPrestaciones() {
		return pRepo.count();
	}
}
