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
	public void guardarTarea(Tarea tarea) {
		String sql = "INSERT INTO Tareas (Titulo, Descripcion, EstadoId, TipoTarea, Editable, UsuarioAlta, FechaAlta) VALUES (:titulo, :descripcion, :estadoId, :tipoTarea, :editable, :usuarioAlta, :fechaAlta)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("titulo", tarea.getTitulo());
		params.put("descripcion", tarea.getDescripcion());
		params.put("estadoId", tarea.getEstadoId());
		params.put("tipoTarea", tarea.getTipoTarea());
		params.put("editable", tarea.getEditable());
		params.put("usuarioAlta", tarea.getUsuarioAlta());
		params.put("fechaAlta", tarea.getFechaAlta());
		jdbcTemplate.update(sql, params);

	}

	@Override
	public List<Tarea> listarTareas() {
		String sql = "SELECT * FROM Tareas";
		Map<String, Object> params = new HashMap<String, Object>();
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
			tarea.setTipoTarea(rs.getInt("tipoTarea"));
			tarea.setEditable(rs.getBoolean("editable"));
			tarea.setUsuarioAlta(rs.getInt("usuarioAlta"));
			tarea.setFechaAlta(rs.getDate("fechaAlta"));
			return tarea;
		}
	}

}