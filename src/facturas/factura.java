package facturas;

import java.util.Date;

public class factura {

	
	private int idfact;
	private Date fecha;
	private int cliente;
	private String descripcion;
	private int importealquiler;
	private double importeservicio;
	private double iva;
	private double importetotal;
	private int idalquiler;
	private String abono;

	public factura(
					
				Date fecha, int cliente, String descripcion, int importealquiler, double importeservicio, double iva, double importetotal, int idalquiler, String abono ) {  
				
		this.fecha=fecha;
		this.cliente=cliente;
		this.descripcion=descripcion;
		this.importealquiler=importealquiler;
		this.importeservicio=importeservicio;
		this.iva=iva;
		this.importetotal=importetotal;
		this.idalquiler=idalquiler;
		this.abono=abono;

		
	}

	public int getIdfact() {
		return idfact;
	}

	public void setIdfact(int idfact) {
		this.idfact = idfact;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getImportealquiler() {
		return importealquiler;
	}

	public void setImportealquiler(int importealquiler) {
		this.importealquiler = importealquiler;
	}

	public double getImporteservicio() {
		return importeservicio;
	}

	public void setImporteservicio(double importeservicio) {
		this.importeservicio = importeservicio;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getImportetotal() {
		return importetotal;
	}

	public void setImportetotal(double importetotal) {
		this.importetotal = importetotal;
	}

	public int getIdalquiler() {
		return idalquiler;
	}

	public void setIdalquiler(int idalquiler) {
		this.idalquiler = idalquiler;
	}

	public String getAbono() {
		return abono;
	}

	public void setAbono(String abono) {
		this.abono = abono;
	}

		
		
}

