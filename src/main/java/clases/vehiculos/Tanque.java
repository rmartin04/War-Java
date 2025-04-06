package clases.vehiculos;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import clases.guerreros.Guerrero;
import excepciones.AtaqueDefensaException;
import excepciones.AtaqueMuyPoderosoException;
import excepciones.DefensaMuyPoderosaException;
import excepciones.EmbarcarGuerrerosDiferentesException;
import excepciones.EmbarcarGuerrerosException;
import excepciones.VidaMaximaPermitidaException;

public class Tanque extends VehiculosGuerra {
    private static final Logger logger = LoggerFactory.getLogger(Tanque.class);

    // Constructores
    public Tanque(String nombreVehiculo, String tipoVehiculo, int ataqueBase, int defensaBase, List<Guerrero> guerreros)
            throws VidaMaximaPermitidaException, AtaqueDefensaException, AtaqueMuyPoderosoException,
            DefensaMuyPoderosaException, EmbarcarGuerrerosException {
        super(nombreVehiculo, tipoVehiculo, ataqueBase, defensaBase, guerreros);
    }

    // Métodos
    public void embarcarGuerreros() throws EmbarcarGuerrerosException, EmbarcarGuerrerosDiferentesException {
        for (Guerrero guerrero : getGuerreros()) {
            if ("Soldado".equalsIgnoreCase(guerrero.getTipoGuerrero())) {
                logger.info("Se ha embarcado al Guerrero " + guerrero.getTipoGuerrero() + " correctamente.");
                logger.info(guerrero.toString());
            } else {
                throw new EmbarcarGuerrerosDiferentesException("No se pueden embarcar otro tipo de guerreros en el " + this.getNombreVehiculo());
            }
        }
    }

}
