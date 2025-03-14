package vehiculosguerra;

import java.util.List;

import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import excepciones.juego.war.EmbarcarExcepcion;
import guerreros.Guerreros;
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
		this.resistencia = (int) (Math.random() * 10);
		this.ataque = (int) (Math.random() * 10);
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public List<Guerreros> getGuerreros() {
		return guerreros;
	}

	public void setGuerreros(List<Guerreros> guerreros) {
		this.guerreros = guerreros;
	}
	
	@Override
	public String toString() {
		return "VehiculoGuerra [vida=" + vida + ", nombre=" + nombre + ", tipo=" + tipo + ", resistencia=" + resistencia
				+ ", ataque=" + ataque + ", guerreros=" + guerreros + "]";
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
	
		// Retorna la defensa efectuada (o podrías retornar la nueva vida, según prefieras)
		return (int) Math.round(defensaTotal);
	}
	
	public void embarcarGuerreros(Guerreros guerrero) throws EmbarcarExcepcion {
		if (guerrero.getTipo().equalsIgnoreCase("Alienigenas")) {
			logger.error("No se pueden embarcar alienigenas en el tanque");
			return;
		}
		List<Guerreros> listaGuerreros = getGuerreros();
		listaGuerreros.add(guerrero);
		if (listaGuerreros.size() > 10) {
			throw new EmbarcarExcepcion("No se pueden embarcar más de 10 guerreros en el tanque");

		}
	}

}
