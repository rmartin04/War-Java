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
	public int atacar() {
		List<Guerreros> guerreros = getGuerreros();
		// 1. Componente de ataque del vehículo con random(0,1)
		double factorVehiculo = Math.random(); // esto da un valor entre [0 y 1)
		double ataqueVehiculo = getAtaque() * factorVehiculo;
	
		// 2. Suma del ataque de los guerreros con random(0, 0.5)
		double factorGuerreros = Math.random() / 2; // esto da un valor entre [0 y 0.5)
		double ataqueTotalGuerreros = 0;
	
		for(Guerreros guerrero : guerreros) {
			// Se asume que getFuerza() devuelve puntos de fuerza (ataque)
			ataqueTotalGuerreros += guerrero.getFuerza();
		}
		// Se multiplica por el factor aleatorio (0,0.5)
		ataqueTotalGuerreros *= factorGuerreros;
	
		// 3. Suma de ambos componentes
		double ataqueTotal = ataqueVehiculo + ataqueTotalGuerreros;
	
		// Redondeamos para devolver entero
		return (int) Math.round( ataqueTotal );
	}

	@Override
	public int defender(int danioRecibido) {
		List<Guerreros> guerreros = getGuerreros();
		// 1. Componente de defensa del vehículo con random(0,1)
		double factorVehiculo = Math.random(); // [0,1)
		double defensaVehiculo = getResistencia() * factorVehiculo;
	
		// 2. Suma de la resistencia (defensa) de los guerreros con random(0,0.5)
		double factorGuerreros = Math.random() / 2; // [0,0.5)
		double defensaTotalGuerreros = 0;
	
		for (Guerreros guerrero : guerreros) {
			// Se asume getResistencia() = puntos de defensa del guerrero
			defensaTotalGuerreros += guerrero.getResistencia();
		}
		defensaTotalGuerreros *= factorGuerreros;
	
		// 3. Suma de ambos
		double defensaTotal = defensaVehiculo + defensaTotalGuerreros;
	
		// Se calcula el daño final y se actualizan los puntos de vida
		// (Si el daño es menor que la defensa total, el resultado será <= 0 y
		// por lo tanto no habrá reducción, pero queda a tu criterio si permites
		// daño negativo o lo limitas a 0).
		double danioFinal = danioRecibido - defensaTotal;
		if (danioFinal < 0) {
			danioFinal = 0;  // Evitamos sumar "vida" por tener más defensa
		}

		defensaTotal = getVida() - danioFinal;

		// Retorna la defensa efectuada por si quieres mostrarlo o registrarlo en logs
		return (int) Math.round(defensaTotal);
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
