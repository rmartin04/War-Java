package pruebajuego;

import java.util.ArrayList;
import java.util.List;

import excepciones.juego.war.FuerzaExcepcion;
import guerreros.Guerreros;
import guerreros.Humanos;

public class PruebaWarJava {

	public static void main(String[] args)  {

		PruebaWarJava prueba = new PruebaWarJava();
		try {
		List<Guerreros> guerrero  = prueba.crearGuerreros(10);
		
			
		} catch (FuerzaExcepcion error) {
			
			error.getMessage();
		}
		

	}

	private List<Guerreros> crearGuerreros(int numGuerreros) throws FuerzaExcepcion {

		List<Guerreros> guerreros = new ArrayList<>();

		for (int i = 0; i < numGuerreros; i++) {

			Guerreros guerrero = new Humanos("Humano" + (i + 1), "Soldado");
			int resis = 10 - (guerrero.getFuerza());
			guerrero.setResistencia(resis);
			guerreros.add(guerrero);

		}
		return guerreros;

	}
}
