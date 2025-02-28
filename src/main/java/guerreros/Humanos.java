package guerreros;

import java.util.ArrayList;
import java.util.List;

import excepciones.juego.war.FuerzaExcepcion;

public class Humanos extends Guerreros {
	
	String raza;

	public Humanos(String nombre, String tipo, String raza) throws FuerzaExcepcion {
		super(nombre, tipo );
		this.raza = raza;
	}


	public Humanos(String nombre, String tipo) throws FuerzaExcepcion {
		super(nombre, tipo);
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
	
	public List<Guerreros> crearGuerreros(int numGuerreros) throws FuerzaExcepcion {

		List<Guerreros> guerreros = new ArrayList<>();

		for (int i = 0; i < numGuerreros; i++) {

			Guerreros guerrero = new Humanos("Humano" + (i + 1), "Soldado", "Humano");
			int resis = 10 - (guerrero.getFuerza());
			guerrero.setResistencia(resis);
			guerreros.add(guerrero);

		}
		return guerreros;

	}

     
	
}
