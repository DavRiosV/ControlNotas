package servicios;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase que prueba el funcionamiento de PromedioServicioImp.
 */

public class PromedioServicioTest {
	private PromedioServicioImp promedioServicio = new PromedioServicioImp();
	
	/**
	 * Verifca que calcularPromedio funciona.
	 */
	
	@Test 
	public void calcularPromedioTest_conNotas() {
		double promedio = promedioServicio.calcularPromedio(Arrays.asList(5.0, 4.0, 6.0));
		assertEquals(5.0, promedio, "El promedio calculado es incorrecto.");
	}
	
	/**
	 * Verifca que el metodo calcularPromedio retorne 0 cuando la lista de notas esta vacia.
	 */
	
	@Test 
	public void calcularPromedioTest_sinNotas() {
		double promedio = promedioServicio.calcularPromedio(Collections.emptyList());
		assertEquals(0.0, promedio, "El promedio debe ser 0 para listas vacías.");
	}
}
