package vehiculosguerra;

import java.util.List;
import java.util.Random;

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
	public int atacar(int ataque, List<Guerreros> guerreros) {
        Random random = new Random();

        // Generar un valor aleatorio para el ataque del vehículo entre 0 y 1
        int ataqueVehiculoFinal = ataque * (random.nextInt());

        // Calcular la suma de los ataques de los guerreros
        int sumaAtaquesGuerreros = 0;
        for (int ataque : guerreros) {
            // Generar un valor aleatorio para cada ataque de guerrero entre 0 y 0.5
            sumaAtaquesGuerreros += ataque * (random.nextDouble() * 0.5);
        }

        // Sumar ambos valores
        int ataqueTotal = ataqueVehiculoFinal + sumaAtaquesGuerreros;

        return ataqueTotal;

		
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
