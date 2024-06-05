package alquileres;

import java.math.BigDecimal;
import java.util.Date;

public class alquiler {

	
	private int idalquiler;
	private Date fechaalquiler;
	private Date fechainicio;
	private Date fechafinal;
	private int precio;
	private int usuprestador;
	private int usuprestatario;
	private BigDecimal importetotal;
	private int idpro;
	
	
	
	
	
	public alquiler(
					
				Date fechaalquiler, Date fechainicio, Date fechafinal, int precio, int usuprestador, int usuprestatario, BigDecimal importetotal, int idpro) {  
		
		this.fechaalquiler=fechaalquiler;
		this.fechainicio=fechainicio;
		this.fechafinal=fechafinal;
		this.precio=precio;
		this.usuprestador=usuprestador;
		this.usuprestatario=usuprestatario;
		this.importetotal=importetotal;
		this.idpro=idpro;
		

		
	}





	public int getIdalquiler() {
		return idalquiler;
	}





	public void setIdalquiler(int idalquiler) {
		this.idalquiler = idalquiler;
	}


	
	public Date getFechaalquiler() {
		return fechaalquiler;
	}





	public void setFechaalquiler(Date fechaalquiler) {
		this.fechaalquiler = fechaalquiler;
	}
	
	



	public Date getFechainicio() {
		return fechainicio;
	}





	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}





	public Date getFechafinal() {
		return fechafinal;
	}





	public void setFechafinal(Date fechafinal) {
		this.fechafinal = fechafinal;
	}





	public int getPrecio() {
		return precio;
	}





	public void setPrecio(int precio) {
		this.precio = precio;
	}





	public int getUsuprestador() {
		return usuprestador;
	}





	public void setUsuprestador(int usuprestador) {
		this.usuprestador = usuprestador;
	}





	public int getUsuprestatario() {
		return usuprestatario;
	}





	public void setUsuprestatario(int usuprestatario) {
		this.usuprestatario = usuprestatario;
	}


	public int getIdpro() {
		return idpro;
	}





	public void setIdpro(int idpro) {
		this.idpro = idpro;
	}

	
	public BigDecimal getImportetotal() {
		return importetotal;
	}





	public void setImportetotal(BigDecimal importetotal) {
		this.importetotal = importetotal;
	}
		
}

