package vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
    private Scanner scanner = new Scanner(System.in);

    public void iniciarMenu() {
        int opcion = 0;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear Alumnos");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materias");
            System.out.println("4. Agregar Notas");
            System.out.println("5. Salir");
            System.out.println("6. Exportar Datos");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpia el buffer
            
            switch (opcion) {
                case 1:
                    crearAlumno();
                    break;
                case 2:
                    listarAlumnos();
                    break;
                case 3:
                    agregarMateria();
                    break;
                case 4:
                    agregarNotaPasoUno();
                    break;
                case 5:
                    terminarPrograma();
                    break;
                case 6:
                    exportarDatos();
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 5);
    }

    public abstract void crearAlumno();
    public abstract void listarAlumnos();
    public abstract void agregarMateria();
    public abstract void agregarNotaPasoUno();
    public abstract void exportarDatos();
    public abstract void terminarPrograma();
}

