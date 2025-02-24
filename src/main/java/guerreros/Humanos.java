package guerreros;

import java.util.ArrayList;
import java.util.List;

public class Humanos extends Guerreros {
	
	String raza;

	public Humanos(String nombre, String tipo, int fuerza, int resistencia, String raza) {
		super(nombre, tipo, fuerza, resistencia);
		this.raza = raza;
	}


	public Humanos(String nombre, String tipo, int fuerza, int resistencia) {
		super(nombre, tipo, fuerza, resistencia);
	}


	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

//	@Override
//	public String toString() {
//		return "\nHumanos  "+ super.toString()+"\nraza = " + raza ;
//	}
	
	public List<Guerreros> crearGuerreros(int numGuerreros) {

		List<Guerreros> guerreros = new ArrayList<>();

		for (int i = 0; i < numGuerreros; i++) {

			Guerreros guerrero = new Humanos("Humano" + (i + 1), "Soldado", (int) (Math.random() * 10), 0,"Humano");
			int resis = 10 - (guerrero.getFuerza());
			guerrero.setResistencia(resis);
			guerreros.add(guerrero);

		}
		return guerreros;

	}

     
	
}
