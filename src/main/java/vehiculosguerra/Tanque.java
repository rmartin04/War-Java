package vehiculosguerra;

import java.util.List;

import excepciones.juego.war.EmbarcarExcepcion;
import guerreros.Guerreros;

public class Tanque extends VehiculoGuerra {
	private int caniones;

	public Tanque(int vida, String nombre, String tipo, int caniones, List<Guerreros> guerreros) {
		super(vida, nombre, tipo, guerreros);
		this.caniones = caniones;
	}

	// G y S

	public int getCaniones() {
		return caniones;
	}

	public void setCaniones(int caniones) {
		this.caniones = caniones;
	}

	@Override
	public void embarcarGuerreros(Guerreros guerrero) throws EmbarcarExcepcion {
		if (guerrero.getTipo().equalsIgnoreCase("Alienigenas")) {
			System.out.println("No se pueden embarcar alienigenas en la nave");
			return;
		}

		super.embarcarGuerreros(guerrero);
	}
}
