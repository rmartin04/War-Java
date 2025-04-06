package clases.guerreros;

import excepciones.FuerzaGuerreroException;
import excepciones.FuerzaYResistenciaException;
import excepciones.ResistenciaGuerreroException;

public class Alienigenas extends Guerrero {

    public Alienigenas(String tipoGuerrero, int fuerzaBase, int resistencia)
            throws FuerzaYResistenciaException, FuerzaGuerreroException, ResistenciaGuerreroException {
        super(tipoGuerrero, fuerzaBase, resistencia);
    }

}
