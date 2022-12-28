package com.lmar.gestion_req_api.model;

public class Requerimiento {
	private int id;
	private String nombre;
	private String descripcion;
	private String rutaAnexo;
	private String estado;

	public Requerimiento() {}
	
	public Requerimiento(int id, String nombre, String descripcion, String rutaAnexo, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rutaAnexo = rutaAnexo;
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRutaAnexo() {
		return rutaAnexo;
	}

	public void setRutaAnexo(String rutaAnexo) {
		this.rutaAnexo = rutaAnexo;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Requerimiento [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", rutaAnexo="
				+ rutaAnexo + ", estado=" + estado + "]";
	}
	
	
}
