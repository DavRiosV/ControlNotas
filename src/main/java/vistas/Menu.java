package vistas;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivoServicio;
import java.util.List;
import java.util.Scanner;


/**
 * Clase para manejar el menu de opciones.
 * Nos permite interactuar entre las distintas funcionalidades entre alumnos y materia
 */

public class Menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();
    private Scanner scanner = new Scanner(System.in);
    
    /**
     * Crea un alumno con los datos solicitados solo si el alumno no existe en el sistema
     */
    @Override
    public void crearAlumno() {
        System.out.println("--- Crear Alumno ---");
        System.out.print("Ingresa RUT: ");
        String rut = scanner.nextLine();

        // Verificar si el alumno ya existe
        if (alumnoServicio.listarAlumnos().containsKey(rut)) {
            System.out.println("El alumno con RUT " + rut + " ya existe en la base de datos.");
            return;
        }

        System.out.print("Ingresa nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingresa dirección: ");
        String direccion = scanner.nextLine();

        Alumno alumno = new Alumno(rut, nombre, apellido, direccion);
        alumnoServicio.crearAlumno(alumno);
        System.out.println("--- ¡Alumno agregado! ---");
    }

    @Override
    public void listarAlumnos() {
        System.out.println("--- Listar Alumnos ---");
        for (Alumno alumno : alumnoServicio.listarAlumnos().values()) {
            System.out.println("RUT: " + alumno.getRut());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Dirección: " + alumno.getDireccion());
            System.out.println("Materias:");
            for (Materia materia : alumno.getMaterias()) {
                System.out.println("  - " + materia.getNombre());
                System.out.println("    Notas: " + materia.getNotas());
            }
            System.out.println();
        }
    }
    
    /**
     * Agrega una materia a un alumno especifico
     * Se solicita el rut del alumno y que materia se desea agregar
     */

    @Override
    public void agregarMateria() {
        System.out.println("--- Agregar Materia ---");
        System.out.print("Ingresa el RUT del alumno: ");
        String rut = scanner.nextLine();

        Alumno alumno = alumnoServicio.listarAlumnos().get(rut);
        if (alumno == null) {
            System.out.println("No se encontró un alumno con el RUT especificado.");
            return;
        }

        System.out.println("Selecciona una Materia:");
        System.out.println("1. MATEMATICAS");
        System.out.println("2. LENGUAJE");
        System.out.println("3. CIENCIA");
        System.out.println("4. HISTORIA");
        System.out.println("5. TCG");
        System.out.println("6. JAVA");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        MateriaEnum materiaEnum;
        switch (opcion) {
            case 1:
                materiaEnum = MateriaEnum.MATEMATICAS;
                break;
            case 2:
                materiaEnum = MateriaEnum.LENGUAJE;
                break;
            case 3:
                materiaEnum = MateriaEnum.CIENCIA;
                break;
            case 4:
                materiaEnum = MateriaEnum.HISTORIA;
                break;
            case 5:
                materiaEnum = MateriaEnum.TCG;
                break;
            case 6:
                materiaEnum = MateriaEnum.JAVA;
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        // Verificar si la materia ya existe en la lista de materias del alumno
        for (Materia materia : alumno.getMaterias()) {
            if (materia.getNombre() == materiaEnum) {
                System.out.println("El alumno ya tiene asignada la materia " + materiaEnum + ".");
                return;
            }
        }

        // Si no existe, agrega la materia
        Materia nuevaMateria = new Materia(materiaEnum);
        alumnoServicio.agregarMateria(rut, nuevaMateria);
        System.out.println("--- ¡Materia agregada! ---");
    }

    @Override
    public void agregarNotaPasoUno() {
        System.out.println("--- Agregar Nota ---");
        System.out.print("Ingresa el RUT del alumno: ");
        String rut = scanner.nextLine();
        
        List<Materia> materias = alumnoServicio.materiasPorAlumnos(rut);
        if (materias == null || materias.isEmpty()) {
            System.out.println("No se encontraron materias para el alumno.");
            return;
        }

        System.out.println("Selecciona una Materia:");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println((i + 1) + ". " + materias.get(i).getNombre());
        }
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (opcion < 1 || opcion > materias.size()) {
            System.out.println("Opción no válida.");
            return;
        }

        Materia materiaSeleccionada = materias.get(opcion - 1);
        System.out.print("Ingresa la nota: ");
        try {
            double nota = Double.parseDouble(scanner.nextLine()); // Usar nextLine y convertir a double
            materiaSeleccionada.getNotas().add(nota);
            System.out.println("--- ¡Nota agregada a " + materiaSeleccionada.getNombre() + "! ---");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Asegúrate de ingresar un número válido para la nota.");
        }
    }

    @Override
    public void exportarDatos() {
        System.out.println("--- Exportar Datos ---");
        System.out.print("Ingresa un nombre para exportar el archivo: ");
        String ruta = scanner.nextLine();
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), ruta);
    }
    
    /**
     * Finaliza el programa.
     */

    @Override
    public void terminarPrograma() {
        System.out.println("Programa finalizado.");
        System.exit(0);
    }
}

