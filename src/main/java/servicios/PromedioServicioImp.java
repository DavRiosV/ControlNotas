package servicios;

import java.util.List;

/**
 * Formula para el calculo del promedio
 */

public class PromedioServicioImp {
    public double calcularPromedio(List<Double> notas) {
        if (notas == null || notas.isEmpty()) {
            return 0.0; 
            // Si el alumno no tiene notas, retorna 0
        }
        
        double suma = 0;
        for (Double nota : notas) {
            suma += nota;
        }
        return suma / notas.size(); // Promedio de las notas del alumno
    }
}