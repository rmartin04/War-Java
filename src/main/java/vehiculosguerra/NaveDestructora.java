package vehiculosguerra;

import java.util.List;

import guerreros.Guerreros;

public class NaveDestructora extends VehiculoGuerra {

    //Atributo
    private double velocidad;

    // Constructores
    public NaveDestructora(int vida, String nombre, String tipo, int fuerzaResistencia, List<Guerreros> guerreros,
            double velocidad) {
        super(vida, nombre, tipo, fuerzaResistencia, guerreros);
        this.velocidad = velocidad;
    }

    public NaveDestructora(int vida, String nombre, String tipo, int fuerzaResistencia, List<Guerreros> guerreros) {
        super(vida, nombre, tipo, fuerzaResistencia, guerreros);
    }
    
    // Getter Y Setters
    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "NaveDestructora [velocidad=" + velocidad + "]";
    }


    @Override
    public int atacar() {
        // TODO Auto-generated method stub
        return this.atacar();
    }

    @Override
    public int defender() {
        // TODO Auto-generated method stub
        return this.defender();
    }

    
    
    
}
