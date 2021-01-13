package com.vyjsoft.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @author jgomez
 * @date 12/01/2021
 */
 

@Entity
@Table(name = "DESARROLLO.PRE001")
public class Nomenclador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 
	@Column(name = "TNO_COD")
	private String codigo;
	
	@Column(name = "TNO_DES")
	private String descripcion;

	public Nomenclador() {}
	
	public Nomenclador(String codigo) {
		this.codigo = codigo;
	}

	public Nomenclador(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
