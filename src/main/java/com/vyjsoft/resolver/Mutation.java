package com.vyjsoft.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.vyjsoft.model.Nomenclador;
import com.vyjsoft.model.Prestacion;
import com.vyjsoft.repository.NomencladorRepository;
import com.vyjsoft.repository.PrestacionRepository;

import javassist.NotFoundException;


@Component
public class Mutation implements GraphQLMutationResolver {

	private NomencladorRepository nRepo;
	private PrestacionRepository pRepo;
	
	@Autowired
	public Mutation(NomencladorRepository nRepo, PrestacionRepository pRepo) {
		 
		this.nRepo = nRepo;
		this.pRepo = pRepo;
	}
	
	public Nomenclador createNomenclador(String codigo , String descripcion) {
		
		Nomenclador nomen = new Nomenclador();
		nomen.setCodigo(codigo);
		nomen.setDescripcion(descripcion);
		nRepo.save(nomen);
		return nomen;
	}
	
	public Prestacion createPrestacion(String codigo, String descripcion, 
			Integer capitulo, Integer subcapitulo, Nomenclador nom) {
		
		Prestacion pres = new Prestacion();
		pres.setCodigo(codigo);
		pres.setDescripcion(descripcion);
		pres.setCapitulo(capitulo);
		pres.setSubcapitulo(subcapitulo);
		pres.setNomencladores(nom);
		
		pRepo.save(pres);
		return pres;
	}
	
	public boolean deletePrestacion(Long idPres) {
		pRepo.deleteById(idPres);
		return true;
	}
	
	public Prestacion updatePrestacion (Long id, String codigo, String descripcion, 
			Integer capitulo, Integer subcapitulo, Nomenclador nom) throws NotFoundException{
		
		Optional<Prestacion> optPrestacion = pRepo.findById(id);
		
		if(optPrestacion.isPresent()) {
			
			Prestacion pres = optPrestacion.get();
			
			if(codigo != null)
				pres.setCodigo(codigo);
			if(descripcion != null)
				pres.setDescripcion(descripcion);
			if(capitulo != null)
				pres.setCapitulo(capitulo);
			if(subcapitulo != null)
				pres.setSubcapitulo(subcapitulo);
			if(nom != null)
				pres.setNomencladores(nom);
			pRepo.save(pres);
			
			return pres;
		}
		
		throw new NotFoundException("La prestacion no existe");
	}
}
