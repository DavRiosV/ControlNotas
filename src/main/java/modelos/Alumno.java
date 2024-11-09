package modelos;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase creada para la representación y creación de un alumno.
 */

public class Alumno {
    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private List<Materia> materias;
    
    /**
     * Constructor para inicializar un nuevo alumno
     * @param rut
     * @param nombre
     * @param apellido
     * @param direccion
     */
    
    public Alumno(String rut, String nombre, String apellido, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.materias = new ArrayList<>(); // Asegura que no es null
    }
    
    // getters y setters

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
    
    
}
