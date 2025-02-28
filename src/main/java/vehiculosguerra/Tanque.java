package vehiculosguerra;

import java.util.List;

import excepciones.juego.war.EmbarcarExcepcion;
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

	@Override
	public int atacar() {
		// TODO Auto-generated method stub
		return this.atacar();
	}

	@Override
	public int defender() {

		return this.defender();
	}

	@Override
	public void embarcarGuerreros(Guerreros guerrero) throws EmbarcarExcepcion {
		if (guerrero.getTipo().equalsIgnoreCase("Alienigenas")) {
			System.out.println("No se pueden embarcar alienigenas en el tanque");
			return;
		}
		List<Guerreros> listaGuerreros = getGuerreros();
		listaGuerreros.add(guerrero);
		if (listaGuerreros.size() > 10) {
			throw new EmbarcarExcepcion("No se pueden embarcar más de 10 guerreros en el tanque");

		}
	}
}
