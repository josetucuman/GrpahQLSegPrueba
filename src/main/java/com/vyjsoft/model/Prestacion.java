package com.vyjsoft.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "REINTEGROS.PRESTACIONES")
public class Prestacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_NOMENCLADOR", referencedColumnName = "TNO_COD", insertable = false, updatable = false)
	private Nomenclador nomencladores;

	@Column(name = "CODIGO")
	private String codigo;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Basic(optional = false)
	@NotNull
	@Column(name = "CAPITULO")
	private Integer capitulo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "SUBCAPITULO")
	private Integer subcapitulo;

	public Prestacion() {}

	public Prestacion(Long id, Nomenclador nomencladores, String codigo, String descripcion, @NotNull Integer capitulo,
			@NotNull Integer subcapitulo) {
		 
		this.id = id;
		this.nomencladores = nomencladores;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.capitulo = capitulo;
		this.subcapitulo = subcapitulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Nomenclador getNomencladores() {
		return nomencladores;
	}

	public void setNomencladores(Nomenclador nomencladores) {
		this.nomencladores = nomencladores;
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

	public Integer getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Integer capitulo) {
		this.capitulo = capitulo;
	}

	public Integer getSubcapitulo() {
		return subcapitulo;
	}

	public void setSubcapitulo(Integer subcapitulo) {
		this.subcapitulo = subcapitulo;
	}
	
	

	
}
