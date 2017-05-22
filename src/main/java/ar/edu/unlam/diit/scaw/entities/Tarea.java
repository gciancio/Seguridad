package ar.edu.unlam.diit.scaw.entities;

import java.util.Date;

public class Tarea {
	
	private Integer tareaId;
	private String titulo;
	private String descripcion;
	private Integer estadoId;
	private Integer privacidad;
	private Integer tipoTarea;
	private Integer usuarioAlta;
	private Integer usuarioAsignado;
	private Date fechaAlta = new Date();
	
	public Tarea(){
	}
	
	public Integer getTareaId(){
		return tareaId;
	}
	
	public void setTareaId(Integer tareaId){
		this.tareaId = tareaId;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public Integer getEstadoId(){
		return estadoId;
	}
	
	public void setEstadoId(Integer estadoId){
		this.estadoId = estadoId;
	}
	
	public Integer getPrivacidad(){
		return privacidad;
	}
	
	public void setPrivacidad(Integer privacidad){
		this.privacidad = privacidad;
	}
	
	public Integer getTipoTarea(){
		return tipoTarea;
	}
	
	public void setTipoTarea(Integer tipoTarea){
		this.tipoTarea = tipoTarea;
	}
	
	public Integer getUsuarioAlta(){
		return usuarioAlta;
	}
	
	public void setUsuarioAlta(Integer usuarioAlta){
		this.usuarioAlta = usuarioAlta;
	}
	
	public Integer getUsuarioAsignado(){
		return usuarioAsignado;
	}
	
	public void setUsuarioAsignado(Integer usuarioAsignado){
		this.usuarioAsignado = usuarioAsignado;
	}
	
	public Date getFechaAlta(){
		return fechaAlta;
	}
	
	public void setFechaAlta(Date fechaAlta){
		this.fechaAlta = fechaAlta;
	}
}
