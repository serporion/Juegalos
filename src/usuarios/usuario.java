package usuarios;

import java.util.Date;

public class usuario {

	// Definición de la clase. Sus atributos
	// Aquí creamos los atributos privados que va a tener nuestra clase, definidos y que no se permitirá modificar.
		
		private int idcli;
		private Date fechaalta;
		private String dni;
		private String nombre;
		private String apellidos;
		private String direccion;
		private String cp;
		private String telefono;
		private String poblacion;
		private String provincia;
		private String formapago;
		private String tarjeta;
		
		public usuario() {
			
		}
		
		public usuario(
				
				// Definición, creación del objeto
				// Esto de arriba es ya la creación del objeto. Crea la estructura. En C se hacía con Struct.
				// Refunde todos los campos salvo el codigo, y referenciamos la estructura de la clase
				
				//String cod_usuario, 
				
				Date fechaalta, String dni, String nombre, String apellidos, String direccion, String cp, String telefono, String poblacion, String provincia, String formapago, String tarjeta) {  
			
			this.fechaalta=fechaalta;
			this.dni=dni;
			this.nombre=nombre;
			this.apellidos=apellidos;
			this.direccion=direccion;
			this.cp=cp;
			this.telefono=telefono;
			this.poblacion=poblacion;
			this.provincia=provincia;
			this.formapago=formapago;
			this.tarjeta=tarjeta;
			
		}

		
		
		public Date getFechaalta() {
			return fechaalta;
		}



		public void setFechaalta(Date fechaalta) {
			this.fechaalta = fechaalta;
		}

		public int getIdcli() {
			return idcli;
		}


		public void setIdcli(int idcli) {
			this.idcli = idcli;
		}


		
		public String getDni() {
			return dni;
		}


		public void setDni(String dni) {
			this.dni = dni;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getApellidos() {
			return apellidos;
		}


		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}


		public String getDireccion() {
			return direccion;
		}


		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}


		public String getCp() {
			return cp;
		}


		public void setCp(String cp) {
			this.cp = cp;
		}


		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}


		public String getPoblacion() {
			return poblacion;
		}


		public void setPoblacion(String poblacion) {
			this.poblacion = poblacion;
		}


		public String getProvincia() {
			return provincia;
		}


		public void setProvincia(String provincia) {
			this.provincia = provincia;
		}


		public String getFormapago() {
			return formapago;
		}


		public void setFormapago(String formapago) {
			this.formapago = formapago;
		}
		
		public String getTarjeta() {
			return tarjeta;
		}


		public void setTarjeta(String tarjeta) {
			this.tarjeta = tarjeta;
		}
		
		
		
		
	}


