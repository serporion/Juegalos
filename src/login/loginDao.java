package login;



public interface loginDao {
	
	public boolean comprobar(login login);
	public boolean eliminar (int id_cli);
	public int Conteo();
	public boolean registrar(login login);
	public int BuscaId(String idusunuevo);
	
	
	
}
