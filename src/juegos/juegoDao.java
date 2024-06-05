package juegos;



public interface juegoDao {

	public boolean registrar(juego juego); 
	public boolean eliminar (int cod_juego);
	public int Conteo();
	
}
