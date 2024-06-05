package alquileres;



public interface alquilerDao {
	
	public boolean registrar(alquiler alquiler);
	public boolean eliminar (int cod_alqui);
	public int Conteo();
	
	
}
