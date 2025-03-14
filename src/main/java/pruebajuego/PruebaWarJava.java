package pruebajuego;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import excepciones.juego.war.EmbarcarExcepcion;
import excepciones.juego.war.FuerzaExcepcion;
import guerreros.Alienigenas;
import guerreros.Guerreros;
import guerreros.Humanos;
import vehiculosguerra.NaveDestructora;
import vehiculosguerra.Tanque;

public class PruebaWarJava {

	private static final Logger logger = LoggerFactory.getLogger(PruebaWarJava.class);

	public static void main(String[] args) throws FuerzaExcepcion {

		PruebaWarJava prueba = new PruebaWarJava();
		List<Guerreros> listadoGuerreros = prueba.crearGuerreros(10);

		// prueba.ejecutarGuerreros(listadoGuerreros);

		Tanque tanque = prueba.crearTanque(listadoGuerreros);
		System.out.println(tanque);
		try {
			NaveDestructora nave = prueba.crearNave(listadoGuerreros);
			System.out.println(nave);
		} catch (EmbarcarExcepcion e) {
			logger.error(e.getMessage());
		}

	}

	/**
	 * metodo que ejecuta una lista de guerreros
	 * se utiliza para visualizar la lista de guerreros que se ha creado
	 * 
	 * @param listadoGuerreros
	 */
	private void ejecutarGuerreros(List<Guerreros> listadoGuerreros, int numGuerreros) {
		try {
			crearGuerreros(numGuerreros);
			crearAlienigenas(numGuerreros);
			crearNave(listadoGuerreros);
		} catch (Exception e) {
			logger.error("Ha habido un error al ejecutar, revisa: ", e);
		}

	}

	/**
	 * metodo que crea una lista de guerreros, a partir de un numero de guerreros
	 * 
	 * @param numGuerreros
	 * @return List<Guerreros> devuelve una lista de guerreros
	 * @throws FuerzaExcepcion
	 *                         lanza una excepcion si la fuerza mas la resistencia
	 *                         es mayor de 10
	 */

	private List<Guerreros> crearGuerreros(int numGuerreros) throws FuerzaExcepcion {

		List<Guerreros> listadoGuerra = new ArrayList<>();
		for (int i = 0; i < numGuerreros; i++) {
			Guerreros guerrero = new Humanos("Humano" + (i + 1), "Soldado");
			listadoGuerra.add(guerrero);
		}
		return listadoGuerra;
	}

	private List<Guerreros> crearAlienigenas(int numGuerreros) throws FuerzaExcepcion {

		List<Guerreros> listadoGuerra = new ArrayList<>();
		for (int i = 0; i < numGuerreros; i++) {
			Guerreros guerrero = new Humanos("Alienigena" + (i + 1), "Humanoide");
			listadoGuerra.add(guerrero);
		}
		return listadoGuerra;
	}

	/**
	 * metodo que crea un tanque a partir de una lista de guerreros
	 * 
	 * @param guerreros
	 * @return Tanque devuelve un tanque con una lista de guerreros
	 */
	private Tanque crearTanque(List<Guerreros> alienigenas) {
		if (alienigenas.size() > 10) {

		}
		Tanque tanque = new Tanque(1000, "Tanque", "asalto", 8, guerreros);
		return tanque;

	}

	/**
	 * metodo que crea una nave a partir de una lista de guerreros
	 * 
	 * @param guerreros
	 * @return
	 * @throws EmbarcarExcepcion
	 */
	private NaveDestructora crearNave(List<Alienigenas> alienigenas) throws EmbarcarExcepcion {
		if (alienigenas.size() > 10) {
			throw new EmbarcarExcepcion("La nave no puede embarcar más de 10 guerreros.");
		}
		NaveDestructora nave = new NaveDestructora(1000, "Nave de Guerra", "Acorazado", alienigenas);

		return nave;
	}
}
