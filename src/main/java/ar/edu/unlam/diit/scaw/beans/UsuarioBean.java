package ar.edu.unlam.diit.scaw.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.UsuarioService;

@ManagedBean(name = "usuarioBean", eager = true)
@RequestScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre = null;
	private String apellido = null;
	private String email = null;
	private String password = null;
	private Integer rolId = 2;
	private Boolean activo = false;
	private Date fechaAlta = new Date();

	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
	UsuarioService service = (UsuarioService) context.getBean("usuarioService");
	
	public UsuarioBean() {
		super();
	}
	
	public String guardarUsuario() {
		Usuario usuario = buildUsuario();
		service.guardarUsuario(usuario);
		return "login";
	}
	
       public List<Usuario> listarUsuarios() {
		List<Usuario> list = service.listarUsuarios();
	    
			return list;
	}
	
	public List<Usuario> listarUsuariosInactivos() {
		List<Usuario> list = service.listarUsuariosInactivos();
	
			return list;
	}
	
	public String eliminarUsuario(Integer usuarioId) {
		this.logout();
		service.eliminarUsuario(usuarioId);				
		return "login";
	}
	
	public String activarUsuario(Integer usuarioId, Boolean activo) {
		activo = false;
		if (activo == false) {
			service.activarUsuario(usuarioId, activo);				
		}
		return "usuarios";
	}
	
	public String login(String email, String password) {
        Usuario usuario = service.crearSesion(email, password);
        FacesContext context = FacesContext.getCurrentInstance();
        if (usuario == null) {
            context.addMessage("loginForm", new FacesMessage("El Email o Contraseña ingresados no existen o su Usuario se encuentra Inactivo"));
            email = null;
            password = null;
            return "";
        } else {
            context.getExternalContext().getSessionMap().put("usuario", usuario);
            if (((Usuario) usuario).getRolId() == 1) {
				return "usuarios";	// Administrador muestro usuarios					
			} else {
				return "tareas";	// Usuarios muestro tareas
            }
        }
    }
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login";
	}
	
	public void verificarSesion() throws IOException{
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") == null) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		}
	}
	
	private Usuario buildUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombre(this.nombre);
		usuario.setApellido(this.apellido);
		usuario.setEmail(this.email);
		usuario.setPassword(this.password);
		usuario.setRolId(this.rolId);
		usuario.setActivo(this.activo);
		usuario.setFechaAlta(this.fechaAlta);
		
		return usuario;
	}

	public UsuarioBean(String nombre, String apellido, String email, String password, Integer rolId, Boolean activo, Date fechaAlta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.rolId = rolId;
		this.activo = activo;
		this.fechaAlta = fechaAlta;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRolId() {
		return rolId;
	}
	
	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public Boolean getActivo() {
		return activo;
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
}
