package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ar.edu.unlam.diit.scaw.daos.TareaDao;
import ar.edu.unlam.diit.scaw.entities.Tarea;;

public class TareaDaoImpl implements TareaDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public TareaDaoImpl() {
		super();
	}

	@Override
	public void guardarTarea(Tarea tarea, Integer usuarioId) {
		String sql = "INSERT INTO Tareas (Titulo, Descripcion, EstadoId, Privacidad, TipoTarea, UsuarioAlta, UsuarioAsignado, FechaAlta) VALUES (:titulo, :descripcion, :estadoId, :privacidad, :tipoTarea, :usuarioAlta, :usuarioAsignado, :fechaAlta)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("titulo", tarea.getTitulo());
		params.put("descripcion", tarea.getDescripcion());
		params.put("estadoId", tarea.getEstadoId());
		params.put("privacidad", tarea.getPrivacidad());
		params.put("tipoTarea", tarea.getTipoTarea());
		params.put("usuarioAlta", usuarioId);
		params.put("usuarioAsignado", tarea.getUsuarioAsignado());
		params.put("fechaAlta", tarea.getFechaAlta());
		jdbcTemplate.update(sql, params);

	}

	@Override
	public List<Tarea> listarTareasCreadas(Integer usuarioId) {
		String sql = "SELECT * FROM Tareas WHERE usuarioAlta = :usuarioId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("usuarioId", usuarioId);
		List<Tarea> result = jdbcTemplate.query(sql, params, new TareaMapper());
		return result;
	}
	
	@Override
	public List<Tarea> listarTareasAsignadas(Integer usuarioId) {
		String sql = "SELECT * FROM Tareas WHERE usuarioAsignado = :usuarioId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("usuarioId", usuarioId);
		List<Tarea> result = jdbcTemplate.query(sql, params, new TareaMapper());
		return result;
	}

	@Override
	public void eliminarTarea(Integer tareaId) {
		String sql = "DELETE FROM Tareas WHERE tareaId LIKE :tareaId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tareaId", tareaId);
		jdbcTemplate.update(sql, params);		
	}
	
	@Override
	public void actualizarTarea(String tareaId, String titulo, String descripcion, Integer privacidad, Integer tipoTarea, Integer estadoId, Integer usuarioAsignado) {

		String sql = "UPDATE Tareas SET titulo = " + titulo + ", descripcion = " + descripcion + ", privacidad = " + privacidad + ", tipoTarea = " + tipoTarea + ", estadoId = " + estadoId + ",usuarioAsignado = " + usuarioAsignado + " WHERE tareaId = " + tareaId + "";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tareaId", Integer.parseInt(tareaId));
		params.put("titulo", titulo);
		params.put("descripcion", descripcion);
		params.put("privacidad", privacidad);
		params.put("tipoTarea", tipoTarea);
		params.put("estadoId", estadoId);		
		params.put("usuarioAsignado", usuarioAsignado);
		jdbcTemplate.update(sql, params);
	}
	
	@Override
	public List<Tarea> listarTareasAnonimo() {
		String sql = "SELECT * FROM Tareas WHERE privacidad=1 AND tipoTarea=2";
		Map<String, Object> params = new HashMap<String, Object>();
		List<Tarea> resultAno = jdbcTemplate.query(sql, params, new TareaMapper());
		return resultAno;
	}
	
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final class TareaMapper implements RowMapper<Tarea> {

		public Tarea mapRow(ResultSet rs, int rowNum) throws SQLException {
			Tarea tarea = new Tarea();
			tarea.setTareaId(rs.getInt("tareaId"));
			tarea.setTitulo(rs.getString("titulo"));
			tarea.setDescripcion(rs.getString("descripcion"));
			tarea.setEstadoId(rs.getInt("estadoId"));
			tarea.setPrivacidad(rs.getInt("privacidad"));
			tarea.setTipoTarea(rs.getInt("tipoTarea"));
			tarea.setUsuarioAlta(rs.getInt("usuarioAlta"));
			tarea.setUsuarioAsignado(rs.getInt("usuarioAsignado"));
			tarea.setFechaAlta(rs.getDate("fechaAlta"));
			return tarea;
		}
	}
}