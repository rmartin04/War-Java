package pruebajuego;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import excepciones.juego.war.FuerzaExcepcion;
import guerreros.Guerreros;
import guerreros.Humanos;

public class PruebaWarJava {
	
	  private static final Logger logger = LoggerFactory.getLogger(PruebaWarJava.class);

	public static void main(String[] args) {

		PruebaWarJava prueba = new PruebaWarJava();

		List<Guerreros> guerrero = prueba.crearGuerreros(10);
	
		
	}

	private List<Guerreros> crearGuerreros(int numGuerreros) {
		List<Guerreros> guerreros = new ArrayList<>();
		try {
			for (int i = 0; i < numGuerreros; i++) {
				Guerreros guerrero = new Humanos("Humano" + (i + 1), "Soldado");
				guerreros.add(guerrero);

			}
		} catch (FuerzaExcepcion error) {
			
			 logger.info(error.getMessage());
		}
		return guerreros;
	}
}
