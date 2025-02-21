package pruebajuego;

import java.util.ArrayList;
import java.util.List;

import guerreros.Guerreros;
import guerreros.Humanos;

public class PruebaWarJava {

	public static void main(String[] args) {

		PruebaWarJava prueba = new PruebaWarJava();
		List<Guerreros> guerrero = prueba.crearGuerreros(10);
		System.out.println(guerrero);

	}

	private List<Guerreros> crearGuerreros(int numGuerreros) {

		List<Guerreros> guerreros = new ArrayList<>();

		for (int i = 0; i < numGuerreros; i++) {

			Guerreros guerrero = new Humanos("H" + (i + 1), "Humano", (int) (Math.random() * 10), 0);
			int resis = 10 - (guerrero.getFuerza());
			guerrero.setResistencia(resis);
			guerreros.add(guerrero);

		}
		return guerreros;

	}
}
