package guerreros;

public class Alienigenas extends Guerreros {

	String planeta;

	public Alienigenas(String nombre, String tipo, int fuerza, int resistencia, String planeta) {
		super(nombre, tipo, fuerza, resistencia);
		this.planeta = planeta;
	}

	public String getPlaneta() {
		return planeta;
	}

	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}

	@Override
	public String toString() {
		return "Alienigenas planeta = " + planeta;
	}
	
	

}
