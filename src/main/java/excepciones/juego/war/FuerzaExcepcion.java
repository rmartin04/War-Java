package excepciones.juego.war;

public class FuerzaExcepcion extends LimitesException {
	
	/**
	 * Esta excepcion se lanza cuando la fuerza de un guerrero
	 * más la resistencia  es mayor a 10
	 */

	public FuerzaExcepcion(String mensaje) {

		super(mensaje);

	}

}
