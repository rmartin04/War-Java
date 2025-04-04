package excepciones.juego.war;

import java.util.Scanner;

public class Utilidades {
	
	public static final String ELIGE_OPCION = "Elige una opcion ";

	public static int pideDatoNumerico(String texto) {

		System.out.println(texto);

		Scanner teclado = new Scanner(System.in);

		int numero = teclado.nextInt();

		return numero;

	}

	public static String pideDatoCadena(String texto) {

		Scanner teclado = new Scanner(System.in);

		System.out.println(texto);

		String cadena = teclado.nextLine();

		return cadena;

	}
/**
 * Función que sirve para pintar las opciones de un menú
 * que llegan en un array de Strings
 * @param texto  Array de String con las opciones del menú
 * @author Ricardo Martin
 * @since 1.0 
 */
	public static void pintarMenu(String[] texto) {
		
		pintarMenu(texto,"Introduce una opcion");
	}

		
	
	public static void pintarMenu(String[] texto,String cadena) {

		for (int i = 0; i < texto.length; i++) {

			System.out.println(texto[i]);

		}
		System.out.println(cadena);
	}
	
	public static void pintaMenu(String texto) {
	
		String []opciones = texto.split(texto);
		pintarMenu(opciones);
	}

	public static double pideDatoDouble(String texto) {
		System.out.println(texto);

		Scanner teclado = new Scanner(System.in);

		double numero = teclado.nextDouble();

		return numero;

	}

	public static boolean pideDatoBoolean(String texto) {
		System.out.println(texto);
		Scanner teclado = new Scanner(System.in);
		boolean respuesta = teclado.nextBoolean();
		return respuesta;
	}
}
