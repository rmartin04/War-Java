package vehiculosguerra;

import java.util.List;

import guerreros.Guerreros;
import interfazjuego.Tripulable;

public abstract class VehiculoGuerra implements Tripulable {

    // Atributos
    private int vida;
    private String nombre;
    private String tipo;
    private int fuerzaResistencia;
    private List<Guerreros> guerreros;

    //Constructores
    public VehiculoGuerra(int vida, String nombre, String tipo, int fuerzaResistencia, List<Guerreros> guerreros) {
        this.vida = vida;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerzaResistencia = fuerzaResistencia;
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

    public int getFuerzaResistencia() {
        return fuerzaResistencia;
    }

    public void setFuerzaResistencia(int fuerzaResistencia) {
        this.fuerzaResistencia = fuerzaResistencia;
    }

    public List<Guerreros> getGuerreros() {
        return guerreros;
    }

    public void setGuerreros(List<Guerreros> guerreros) {
        this.guerreros = guerreros;
    }

    @Override
    public String toString() {
        return "VehiculoGuerra [vida=" + vida + ", nombre=" + nombre + ", tipo=" + tipo + ", fuerzaResistencia="
                + fuerzaResistencia + ", guerreros=" + guerreros + "]";
    }

    
    
}
