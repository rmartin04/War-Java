package excepciones.juego.war;

public class EmbarcarExcepcion extends LimitesException{
	
	/**
	 * Esta excepcion se lanza cuando se intenta embarcar mas guerreros de los que puede llevar un vehiculo
	 * el límite es de 10
	 */

	public EmbarcarExcepcion(String mensaje) {
		
		super(mensaje);
		
	}
	

}
