package vehiculosguerra;

import java.util.List;
import guerreros.Guerreros;

public class Tanque extends VehiculoGuerra {
	private int caniones;

	public Tanque(int vida, String nombre, String tipo, List<Guerreros> guerreros, int caniones) {
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


}
