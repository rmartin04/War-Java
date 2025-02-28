package guerreros;

import excepciones.juego.war.FuerzaExcepcion;

public class Alienigenas extends Guerreros {

	String planeta;

	public Alienigenas(String nombre, String tipo, String planeta) throws FuerzaExcepcion {
		super(nombre, tipo);
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
