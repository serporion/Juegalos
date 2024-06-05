package usuarios;

import java.util.List;

public interface usuarioDao {

	public boolean registrar(usuario usuario); // le pasamos la clase y el objeto que en ese momento se crea cuando Controller nos lo diga.
	public boolean actualizar(String an, String mode, int indicee);
	public int Conteo ();
	
	
	public usuario obtener_usuario(int idcli);
	public List<usuario> obtener();
	
	
	
	
	

}
