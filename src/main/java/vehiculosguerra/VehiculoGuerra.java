package vehiculosguerra;

import java.util.List;

import excepciones.juego.war.EmbarcarExcepcion;
import guerreros.Guerreros;
import interfazjuego.Tripulable;

public abstract class VehiculoGuerra implements Tripulable {

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

	public void embarcarGuerreros(Guerreros guerrero) throws EmbarcarExcepcion {
		List<Guerreros> listaGuerreros = getGuerreros();
		listaGuerreros.add(guerrero);
		if (listaGuerreros.size() > 10) {
			throw new EmbarcarExcepcion("No pueden embarcar más de 10 guerreros");

		}

	}
}
