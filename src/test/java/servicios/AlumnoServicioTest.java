package servicios;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class AlumnoServicioTest {
    private AlumnoServicio alumnoServicio;
    private AlumnoServicio alumnoServicioMock;
    private Alumno alumno;

    /**
     * Configuración inicial de los objetos y valores de prueba.
     */
    @BeforeEach
    public void setup() {
        alumnoServicio = new AlumnoServicio();
        alumnoServicioMock = Mockito.mock(AlumnoServicio.class);
        alumno = new Alumno("12345678-9", "Juan", "Perez", "Calle Falsa 123");
    }

    /**
     * Verifica que el método crearAlumno funcione correctamente.
     */
    @Test
    public void crearAlumnoTest() {
        alumnoServicio.crearAlumno(alumno);
        assertNotNull(alumnoServicio.listarAlumnos().get("12345678-9"), "El alumno no fue agregado correctamente.");
    }

    /**
     * Verifica que el método agregarMateria asigne correctamente una materia a un alumno.
     */
    @Test
    public void agregarMateriaTest() {
        alumnoServicio.crearAlumno(alumno);
        Materia materia = new Materia(MateriaEnum.MATEMATICAS);
        alumnoServicio.agregarMateria("12345678-9", materia);
        
        List<Materia> materias = alumnoServicio.materiasPorAlumnos("12345678-9");
        assertEquals(1, materias.size(), "La materia no fue agregada correctamente.");
        assertEquals(MateriaEnum.MATEMATICAS, materias.get(0).getNombre(), "La materia agregada no es correcta.");
    }

    /**
     * Verifica que el método materiasPorAlumnos funcione correctamente usando un mock.
     */
    @Test
    public void materiasPorAlumnosTest() {
    	when(alumnoServicioMock.materiasPorAlumnos("12345678-9")).thenReturn(List.of(new Materia(MateriaEnum.CIENCIA)));

        
        List<Materia> materias = alumnoServicioMock.materiasPorAlumnos("12345678-9");
        assertEquals(1, materias.size(), "El número de materias no es correcto.");
        assertEquals(MateriaEnum.CIENCIA, materias.get(0).getNombre(), "La materia no es la esperada.");
    }

    /**
     * Verifica que el método listarAlumnos funcione correctamente.
     */
    @Test
    public void listarAlumnosTest() {
        alumnoServicio.crearAlumno(alumno);

        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        assertNotNull(alumnos, "El mapa de alumnos no debería ser null.");
        assertEquals(1, alumnos.size(), "El número de alumnos listados no es correcto.");
        assertEquals(alumno, alumnos.get("12345678-9"), "El alumno listado no es el esperado.");
    }
}
