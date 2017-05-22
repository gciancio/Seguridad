package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Tarea;;

public interface TareaDao {

	public void guardarTarea(Tarea tarea, Integer usuarioId);

	public List<Tarea> listarTareas();
	
	public void eliminarTarea(Integer tareaId);
	
	public void actualizarTarea(String tareaId, String titulo, String descripcion, Integer privacidad, Integer tipoTarea, Integer estadoId, Integer usuarioAsignado);

	public List<Tarea> listarTareasAnonimo();

}