package vehiculosguerra;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import excepciones.juego.war.EmbarcarExcepcion;
import guerreros.Alienigenas;
import guerreros.Guerreros;
import guerreros.Humanos;
import interfazjuego.Tripulable;

public abstract class VehiculoGuerra implements Tripulable {
	private static final Logger logger = LoggerFactory.getLogger(VehiculoGuerra.class);

	// Atributos
	private int vida;
	private String nombre;
	private String tipo;
	private int resistencia;
	private int ataque;
	private List<Guerreros> guerreros;

	// Constructores
	public VehiculoGuerra(int vida, String nombre, String tipo, List<Guerreros> guerreros) {
		this.vida = vida;
		this.nombre = nombre;
		this.tipo = tipo;
		this.ataque = (int) (Math.random() * 20);
		this.resistencia = 50 - ataque;
		this.guerreros = guerreros;
	}

	// Getters & Setters
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getResistencia() {
		return resistencia;
	}

	public int getAtaque() {
		return ataque;
	}

	public List<Guerreros> getGuerreros() {
		return guerreros;
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Vehiculo " + getNombre()).append("\n");
		sb.append("=====================").append("\n");
		sb.append("Vida: ").append(vida).append("\n");
		sb.append("Nombre: ").append(nombre).append("\n");
		sb.append("Tipo: ").append(tipo).append("\n");
		sb.append("Resistencia: ").append(resistencia).append("\n");
		sb.append("Ataque: ").append(ataque).append("\n");
		sb.append("Guerreros: ").append(guerreros.toString());
		return sb.toString();
	}

	@Override
	public int atacar() {
		// Obtenemos la lista de guerreros
		List<Guerreros> guerreros = getGuerreros();

		// 1. Componente de ataque del vehículo con random(0,1)
		double factorVehiculo = Math.random(); // valor en [0,1)
		double ataqueVehiculo = getAtaque() * factorVehiculo;

		// 2. Suma del ataque de los guerreros con random(0,0.5)
		double factorGuerreros = Math.random() / 2; // valor en [0,0.5)
		double ataqueTotalGuerreros = 0;

		for (Guerreros guerrero : guerreros) {
			ataqueTotalGuerreros += guerrero.getFuerza();
		}
		ataqueTotalGuerreros *= factorGuerreros;

		// 3. Suma de ambos componentes
		double ataqueTotal = ataqueVehiculo + ataqueTotalGuerreros;

		// Redondeamos para devolver un entero
		return (int) Math.round(ataqueTotal);
	}

	@Override
	public int defender(int danioRecibido) {
		// Obtenemos la lista de guerreros
		List<Guerreros> guerreros = getGuerreros();

		// 1. Componente de defensa del vehículo con random(0,1)
		double factorVehiculo = Math.random(); // valor en [0,1)
		double defensaVehiculo = getResistencia() * factorVehiculo;

		// 2. Suma de la resistencia de los guerreros con random(0,0.5)
		double factorGuerreros = Math.random() / 2; // valor en [0,0.5)
		double defensaTotalGuerreros = 0;

		for (Guerreros guerrero : guerreros) {
			defensaTotalGuerreros += guerrero.getResistencia();
		}
		defensaTotalGuerreros *= factorGuerreros;

		// 3. Suma de ambos valores de defensa
		double defensaTotal = defensaVehiculo + defensaTotalGuerreros;

		// Calculamos el daño final y actualizamos la vida del tanque
		double danioFinal = danioRecibido - defensaTotal;
		if (danioFinal < 0) {
			danioFinal = 0;
		}

		double nuevaVida = getVida() - danioFinal;
		setVida((int) Math.round(nuevaVida));

		// Retorna la defensa efectuada (o podrías retornar la nueva vida, según
		// prefieras)
		return (int) Math.round(defensaTotal);
	}

	/**
	 * Metodo que embarca guerreros en el vehiculo
	 * 
	 * @param guerrero
	 * @throws EmbarcarExcepcion
	 */

	public void embarcarGuerreros(Guerreros guerrero) throws EmbarcarExcepcion {
		// Verificamos si la lista de guerreros ya está llena
		if (this.guerreros.size() > 10) {
			throw new EmbarcarExcepcion("No se pueden embarcar más de 10 guerreros en el vehículo.");
		}

		// Agregamos el nuevo guerrero a la lista del vehículo
		this.guerreros.add(guerrero);

		logger.info("Guerrero embarcado con éxito: " + guerrero.getNombre());
	}

}
