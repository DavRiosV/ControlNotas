package servicios;

import modelos.Alumno;
import modelos.Materia;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Servicio que maneja la exportacion de datos a un archivo txt.
 * Exporta la información de los alumnos y da el promedio de cada materia registrada con notas.
 */

public class ArchivoServicio {
    private PromedioServicioImp promedioServicio = new PromedioServicioImp();

    public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
        try (FileWriter writer = new FileWriter(ruta)) {
            for (Alumno alumno : alumnos.values()) {
                writer.write("Alumno: " + alumno.getRut() + " - " + alumno.getNombre() + "\n");
                
                // Exportar cada materia y su promedio
                for (Materia materia : alumno.getMaterias()) {
                    double promedio = promedioServicio.calcularPromedio(materia.getNotas());
                    writer.write("  Materia: " + materia.getNombre() + " - Promedio: " + promedio + "\n");
                }
                writer.write("\n"); // Agregar un salto de línea entre alumnos
            }
            System.out.println("Datos exportados correctamente a la ruta especificada.");
        } catch (IOException e) {
            System.out.println("Error al exportar los datos: " + e.getMessage());
        }
    }
}
