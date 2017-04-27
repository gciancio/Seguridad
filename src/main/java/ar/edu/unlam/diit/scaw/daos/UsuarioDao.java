package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Usuario;;

public interface UsuarioDao {

	public void guardarUsuario(Usuario usuario);

	public List<Usuario> listarUsuarios();
	
	public void eliminarUsuario(Integer usuarioId);
	
	public void activarUsuario(Integer usuarioId, Boolean activo);
	
	public Usuario buscarUsuario(String email, String password);
	
	public List<Usuario> crearSesion(String email, String password);

}
