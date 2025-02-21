package vehiculosguerra;

import java.util.List;

import guerreros.Guerreros;

public class Tanque extends VehiculoGuerra {
    private int canones;
    

    public Tanque(int vida, String nombre, String tipo, int fuerzaResistencia, List<Guerreros> guerreros, int canones) {
        super(vida, nombre, tipo, fuerzaResistencia, guerreros);
        this.canones = canones;
    }

    // G y S

    public int getCanones() {
        return canones;
    }

    public void setCanones(int canones) {
        this.canones = canones;
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
