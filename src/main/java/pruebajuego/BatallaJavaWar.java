package pruebajuego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import excepciones.juego.war.EmbarcarExcepcion;
import excepciones.juego.war.FuerzaExcepcion;
import excepciones.juego.war.Utilidades;
import guerreros.Guerreros;
import guerreros.Humanos;
import vehiculosguerra.NaveDestructora;
import vehiculosguerra.Tanque;

public class BatallaJavaWar {

	private static final Logger logger = LoggerFactory.getLogger(BatallaJavaWar.class);

	public static void main(String[] args) throws FuerzaExcepcion {

		BatallaJavaWar prueba = new BatallaJavaWar();
		/* 
		Bienvenido a la guerra de los mundos
		"Vamos a crear una lista de guerreros, para ello debes llamar al método crearGuerreros, tanto alienígenas como humanos"
		"Vamos a crear un tanque y una nave destructora, para ello debes llamar a los métodos de creación, pasandole una lista de guerreros"
		"Vamos a simular una lucha entre el tanque y la nave destructora, para ello debes llamar al método simularLucha"
		"Buena suerte en la batalla" 
		*/
	

		prueba.ejecutarGuerreros(10);
	}

	/**
	 * metodo que ejecuta una lista de guerreros
	 * se utiliza para visualizar la lista de guerreros que se ha creado
	 * 
	 * @param listadoGuerreros
	 */
	private void ejecutarGuerreros(int numGuerreros) {
		try {
			List<Guerreros> listadoHumanos = crearGuerreros(numGuerreros);
			List<Guerreros> listadoAlienigenas = crearAlienigenas(numGuerreros);
			Tanque tanque = crearTanque(listadoHumanos);
			NaveDestructora nave = crearNave(listadoAlienigenas);
			simularLucha(tanque, nave);
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
	private Tanque crearTanque(List<Guerreros> guerreros) throws EmbarcarExcepcion {
		if (guerreros.size() > 10) {
			throw new EmbarcarExcepcion("El tanque no puede embarcar más de 10 humanos");
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
	private NaveDestructora crearNave(List<Guerreros> alienigenas) throws EmbarcarExcepcion {
		if (alienigenas.size() > 10) {
			throw new EmbarcarExcepcion("La nave no puede embarcar más de 10 alienigenas.");
		}

		NaveDestructora nave = new NaveDestructora(1000, "Nave de Guerra", "Acorazado", alienigenas);

		return nave;
	}

	/**
	 * metodo que simula una lucha entre un tanque y una nave
	 * 
	 * @param tanque
	 * @param naveAlienigena
	 */

	 public void simularLucha(Tanque tanque, NaveDestructora naveAlienigena) {
		// Logger para simular la batalla
		while (tanque.getResistencia() > 0 && naveAlienigena.getResistencia() > 0) {
			// El tanque ataca primero
			int danioTanque = tanque.atacar();
			int defensaNave = naveAlienigena.defender(danioTanque);
	
			// Log para el ataque del tanque
			logger.info("\n***Turno " + tanque.getNombre() + " Ataca***");
			if (danioTanque > defensaNave) {
				naveAlienigena.setResistencia(naveAlienigena.getResistencia() - (danioTanque - defensaNave));
				logger.info("\tEl " + tanque.getNombre() + " ha hecho " + (danioTanque - defensaNave) + " puntos de daño a la nave alienígena.");
	
				// Verificamos si la nave alienígena ha caído
				if (naveAlienigena.getResistencia() <= 0) {
					logger.info("\t¡La nave alienígena ha sido destruida! El tanque ha ganado.");
					break;
				}
			} else {
				logger.info("\tEl " + tanque.getNombre() + " ha atacado pero la nave alienígena ha defendido todo el daño.");
			}
	
			// Ahora la nave alienígena ataca
			int danioNave = naveAlienigena.atacar();
			int defensaTanque = tanque.defender(danioNave);
	
			// Log para el ataque de la nave
			logger.info("\n***Turno " + naveAlienigena.getNombre() + " Ataca***");
			if (danioNave > defensaTanque) {
				tanque.setResistencia(tanque.getResistencia() - (danioNave - defensaTanque));
				logger.info("\tLa nave alienígena ha hecho " + (danioNave - defensaTanque) + " puntos de daño al tanque.");
	
				if (tanque.getResistencia() <= 0) {
					logger.info("\t¡El tanque ha sido destruido! La nave alienígena ha ganado.");
					break;
				}
			} else {
				logger.info("\tLa nave alienígena ha atacado pero el tanque ha defendido todo el daño.");
			}
		}
	}
	
}
