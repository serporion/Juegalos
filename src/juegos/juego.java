package juegos;

import java.util.Date;

public class juego {
	
	
	private int idpro;
	private String nombre;
	private Date fechaalta;
	private String categoria;
	private String plataforma;
	private String descripcion;
	private String edicion;
	private int precio;
	private int sesion;

	
	
	public juego() {
		
	}
	


	public juego (
	
			String nombre, Date fechaalta, String categoria, String plataforma, String descripcion, String edicion, int precio, int sesion) {  
		
		
		this.nombre=nombre;
		this.fechaalta=fechaalta;
		this.categoria=categoria;
		this.plataforma=plataforma;
		this.descripcion=descripcion;
		this.edicion=edicion;
		this.precio=precio;
		this.sesion=sesion;
		

		
	}



	public int getIdpro() {
		return idpro;
	}



	public void setIdpro(int idpro) {
		this.idpro = idpro;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Date getFechaalta() {
		return fechaalta;
	}



	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getPlataforma() {
		return plataforma;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getEdicion() {
		return edicion;
	}



	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}



	public int getPrecio() {
		return precio;
	}



	public void setPrecio(int precio) {
		this.precio = precio;
	}

	
	public int getSesion() {
		return sesion;
	}



	public void setSesion(int sesion) {
		this.sesion = sesion;
	}
	
	
	
}
