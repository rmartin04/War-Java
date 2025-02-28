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
		this.fuerza = (int) (Math.random() * 10);
		this.resistencia = (int) (Math.random() * 10);
		if((fuerza+resistencia)>10) {
			throw new FuerzaExcepcion("La suma de fuerza y resistencia no puede ser mayor de 10");
			
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
		sb.append("Nombre: ").append(nombre + "\n");
		sb.append("Tipo: ").append(tipo + "\n");
		sb.append("Fuerza: ").append(fuerza);	
		sb.append("Resistencia: ").append(resistencia);	
		return sb.toString();
	}
	
	public void mostrarInfo() {
		System.out.println("==============");
		System.out.println(this.toString());
	}
	

}
