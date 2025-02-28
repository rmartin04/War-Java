package guerreros;

public abstract class Guerreros {

	String nombre;
	String tipo;
	int fuerza;
	int resistencia;
	public Guerreros(String nombre, String tipo, int fuerza, int resistencia) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
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
