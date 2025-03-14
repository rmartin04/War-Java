package pruebajuego;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import excepciones.juego.war.EmbarcarExcepcion;
import excepciones.juego.war.FuerzaExcepcion;
import guerreros.Guerreros;
import guerreros.Humanos;
import vehiculosguerra.NaveDestructora;
import vehiculosguerra.Tanque;

public class PruebaWarJava {

	private static final Logger logger = LoggerFactory.getLogger(PruebaWarJava.class);

	public static void main(String[] args)  {

		PruebaWarJava prueba = new PruebaWarJava();
		try {
		List<Guerreros> listadoGuerreros = prueba.crearGuerreros(5);
		prueba.ejecutarGuerreros(listadoGuerreros);
		for (Guerreros guerreros : listadoGuerreros) {
			System.out.println(guerreros);
		}
		}catch(FuerzaExcepcion error) {
			logger.info(error.getMessage());
		}

	}

	/**
	 *metodo que crea una lista de guerreros, a partir de un numero de guerreros
	 * @param numGuerreros
	 * @return List<Guerreros> decuelve una lista de guerreros
	 * @throws FuerzaExcepcion
	 * lanza una excepcion si la fuerza mas la resistencia es mayor de 10
	 */

	private List<Guerreros> crearGuerreros(int numGuerreros) throws FuerzaExcepcion {

			List<Guerreros> listadoGuerra = new ArrayList<>();
			for (int i = 0; i < numGuerreros; i++) {
				Guerreros guerrero = new Humanos("Humano" + (i + 1), "Soldado");
				listadoGuerra.add(guerrero);
			}
			return listadoGuerra;
	}

	/**
	 * metodo que ejecuta una lista de guerreros
	 * se utiliza para visualizar la lista de guerreros que se ha creado
	 * 
	 * @param listadoGuerreros
	 */
	private void ejecutarGuerreros(List<Guerreros> listadoGuerreros) {

		for (Guerreros guerreros : listadoGuerreros) {
			System.out.println(guerreros);
		}

	}
	
	/**
	 * metodo que crea un tanque a partir de una lista de guerreros
	 * 
	 * @param guerreros
	 * @return Tanque devuelve un tanque con una lista de guerreros
	 */
	private Tanque crearTanque(List<Guerreros> guerreros) {

		Tanque tanque = new Tanque(1000, "Tanque", "asalto", guerreros, 8);

		return tanque;

	}
	/**
	 * metodo que crea una nave a partir de una lista de guerreros
	 * 
	 * @param guerreros
	 * @return
	 * @throws EmbarcarExcepcion
	 */
	  private NaveDestructora crearNave(List<Guerreros> guerreros) throws EmbarcarExcepcion {
	        if (guerreros.size() > 10) {
	            throw new EmbarcarExcepcion("La nave no puede embarcar más de 10 guerreros.");
	        }
	        NaveDestructora nave = new NaveDestructora(10, "Nave de Guerra", null, 0, guerreros);
	        return nave;
	    }
}
