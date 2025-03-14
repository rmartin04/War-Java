package guerreros;

import excepciones.juego.war.FuerzaExcepcion;

public abstract class Guerreros {

	String nombre;
	String tipo;
	int fuerza;
	int resistencia;

	public Guerreros(String nombre, String tipo) throws FuerzaExcepcion {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.fuerza = (int) (Math.random() * 11);
		this.resistencia = 10 - fuerza;
		if ((fuerza + resistencia) > 10) {
			throw new FuerzaExcepcion("La suma de fuerza y resistencia no puede ser mayor de 10");
		} else if ((fuerza + resistencia) < 0) {
			throw new FuerzaExcepcion("La fuerza ni la resitencia pueden ser negativas");
		}
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

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append("*** Guerrero ***").append("\n");
		sb.append("Nombre: ").append(nombre).append("\n");
		sb.append("Tipo: ").append(tipo).append("\n");
		sb.append("Fuerza: ").append(fuerza).append("\n");
		sb.append("Resistencia: ").append(resistencia);
		return sb.toString();
	}

	public void mostrarInfo() {
		System.out.println("==============");
		System.out.println(this.toString());
	}

}
