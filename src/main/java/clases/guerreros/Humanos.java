package clases.guerreros;

import excepciones.FuerzaGuerreroException;
import excepciones.FuerzaYResistenciaException;
import excepciones.ResistenciaGuerreroException;


public class Humanos extends Guerrero {

    public Humanos(String tipoGuerrero, int fuerzaBase, int resistencia)
            throws FuerzaYResistenciaException, FuerzaGuerreroException, ResistenciaGuerreroException {
        super(tipoGuerrero, fuerzaBase, resistencia);
    }
    
}
