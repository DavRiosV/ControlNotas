package servicios;

import modelos.Alumno;
import modelos.Materia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase que permite la creación el listado y la gestion de los alumnos.
 */

public class AlumnoServicio {
	private Map<String, Alumno> listaAlumnos = new HashMap<>();
	
	/**
	 * Agrega un nuevo alumno al sistema.
	 * @param alumno
	 */
	
	public void crearAlumno(Alumno alumno) {
		listaAlumnos.put(alumno.getRut(), alumno);
	}
	/**
	 * Agrega una materia a un alumno existente.
	 * @param rutAlumno
	 * @param materia
	 */
	public void agregarMateria(String rutAlumno, Materia materia) {
	    Alumno alumno = listaAlumnos.get(rutAlumno);
	    if (alumno != null && materia != null) {
	        alumno.getMaterias().add(materia);
	    }
	}

	
	public List<Materia> materiasPorAlumnos(String rutAlumno) {
		Alumno alumno = listaAlumnos.get(rutAlumno);
		return (alumno != null) ? alumno.getMaterias() : null;
	}
	/**
	 * Obtiene un mapa de los alumnos en sistema.
	 * @return MAP de alumnos
	 */
	public Map<String, Alumno> listarAlumnos() {
		return listaAlumnos;
	}
}
