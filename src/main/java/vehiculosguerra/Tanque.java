package vehiculosguerra;

import java.util.List;
import guerreros.Guerreros;

public class Tanque extends VehiculoGuerra {
	private int canones;

	public Tanque(int vida, String nombre, String tipo, int fuerzaResistencia, List<Guerreros> guerreros, int canones) {
		super(vida, nombre, tipo, guerreros);
		this.canones = canones;
	}

	// G y S

	public int getCanones() {
		return canones;
	}

	public void setCanones(int canones) {
		this.canones = canones;
	}


}
