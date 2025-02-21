package guerreros;

public class Humanos extends Guerreros {
	
	String raza;

	public Humanos(String nombre, String tipo, int fuerza, int resistencia, String raza) {
		super(nombre, tipo, fuerza, resistencia);
		this.raza = raza;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	@Override
	public String toString() {
		return "Humanos raza = " + raza ;
	}
	
	

     
	
}
