package modelos;

import java.util.List;
import java.util.ArrayList; 

/**
 * 	Clase creado para representar las materias de cada alumno.
 * Cada materia tiene su nombre propio y una lista de notas para cada alumno regitrado
 */

public class Materia {
	private MateriaEnum nombre;
	private List<Double> notas;
	
	/**
	 * Constructor para inicializar la materia utilizando el param nombre.
	 * @param nombre
	 */
	
	public Materia(MateriaEnum nombre) {
		this.nombre = nombre;
		this.notas = new ArrayList<>(); // inicializa la lista de notas
	}
	
	// getters y setters

	public MateriaEnum getNombre() {
		return nombre;
	}

	public void setNombre(MateriaEnum nombre) {
		this.nombre = nombre;
	}

	public List<Double> getNotas() {
		return notas;
	}

	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
}
