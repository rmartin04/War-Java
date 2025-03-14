package excepciones.juego.war;

public class LimitesException extends Exception {
	
	/**
	 * Esta excepcion se lanza cuando se superan los limites de un vehiculo
	 * o `de las características de fuerza mas resistencia de un guerrero
	 * Esta excepcion es de la que heredan las demas excepciones
     */
	public LimitesException(String mensaje) {

		super(mensaje);

	}

}
