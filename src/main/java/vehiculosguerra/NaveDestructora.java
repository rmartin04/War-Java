package vehiculosguerra;

import java.util.List;

import excepciones.juego.war.EmbarcarExcepcion;
import guerreros.Guerreros;

public class NaveDestructora extends VehiculoGuerra {

	// Atributo
	private double velocidad;

	// Constructores
	public NaveDestructora(int vida, String nombre, String tipo, List<Guerreros> guerreros,
			double velocidad) {
		super(vida, nombre, tipo, guerreros);
		this.velocidad = velocidad;
	}

	public NaveDestructora(int vida, String nombre, String tipo, List<Guerreros> guerreros) {
		super(vida, nombre, tipo, guerreros);
	}

	// Getter Y Setters
	public double getVelocidad() {
		return velocidad;
	}

	@Override
	public String toString() {
		super.toString();
		StringBuilder sb = new StringBuilder();
		sb.append("Velocidad Nave destructora: ").append(velocidad);
		return sb.toString();
	}

	@Override
	public void embarcarGuerreros(Guerreros guerrero) throws EmbarcarExcepcion {
		if (guerrero.getTipo().equalsIgnoreCase("Humanos")) {
			System.out.println("No se pueden embarcar humanos en la nave");
			return;
		}

		super.embarcarGuerreros(guerrero);
	}

}
