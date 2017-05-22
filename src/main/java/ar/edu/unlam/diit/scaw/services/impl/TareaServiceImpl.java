package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.diit.scaw.daos.TareaDao;
import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.services.TareaService;

public class TareaServiceImpl implements TareaService {

	@Autowired
	TareaDao tareaDao;
	
	@Override
	public void guardarTarea(Tarea tarea, Integer usuarioId) {
		tareaDao.guardarTarea(tarea, usuarioId);
	}

	@Override
	public List<Tarea> listarTareasCreadas(Integer usuarioId) {
		return tareaDao.listarTareasCreadas(usuarioId);
	}
	
	@Override
	public List<Tarea> listarTareasAsignadas(Integer usuarioId) {
		return tareaDao.listarTareasAsignadas(usuarioId);
	}
	
	@Override
	public List<Tarea> listarTareasAnonimo() {
		return tareaDao.listarTareasAnonimo();
	}
	
	@Override
	public void eliminarTarea(Integer tareaId) {
		tareaDao.eliminarTarea(tareaId);
	}
	
	public void actualizarTarea(String tareaId, String titulo, String descripcion, Integer privacidad, Integer tipoTarea, Integer estadoId, Integer usuarioAsignado) {
		tareaDao.actualizarTarea(tareaId, titulo, descripcion, privacidad, tipoTarea, estadoId, usuarioAsignado);
	}

	public TareaDao getTareaDao() {
		return tareaDao;
	}

	public void setTareaDao(TareaDao tareaDao) {
		this.tareaDao = tareaDao;
	}	
}