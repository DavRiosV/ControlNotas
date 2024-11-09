package utilidades;

public class Utilidad {
	public static void limpiarPantalla() {
		System.out.println("\033[H\033[2J");
		System.out.println();
	}
	
	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
