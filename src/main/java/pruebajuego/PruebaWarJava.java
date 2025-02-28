package pruebajuego;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import excepciones.juego.war.EmbarcarExcepcion;
import excepciones.juego.war.FuerzaExcepcion;
import guerreros.Guerreros;
import guerreros.Humanos;
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

	private List<Guerreros> crearGuerreros(int numGuerreros) throws FuerzaExcepcion {

			List<Guerreros> listadoGuerra = new ArrayList<>();
			for (int i = 0; i < numGuerreros; i++) {
				Guerreros guerrero = new Humanos("Humano" + (i + 1), "Soldado");
				listadoGuerra.add(guerrero);
			}
			return listadoGuerra;
	}


	private void ejecutarGuerreros(List<Guerreros> listadoGuerreros) {

		for (Guerreros guerreros : listadoGuerreros) {
			System.out.println(guerreros);
		}

	}

	private Tanque crearTanque(List<Guerreros> guerreros) {

		Tanque tanque = new Tanque(1000, "Tanque", "asalto", guerreros, 8);

		return tanque;

	}
}
