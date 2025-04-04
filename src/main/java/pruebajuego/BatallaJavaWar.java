package pruebajuego;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import excepciones.juego.war.EmbarcarExcepcion;
import excepciones.juego.war.FuerzaExcepcion;
import guerreros.Guerreros;
import guerreros.Humanos;
import vehiculosguerra.NaveDestructora;
import vehiculosguerra.Tanque;
import vehiculosguerra.VehiculoGuerra;

public class BatallaJavaWar {

    private static final Logger logger = LoggerFactory.getLogger(BatallaJavaWar.class);

    public static void main(String[] args) {
        BatallaJavaWar prueba = new BatallaJavaWar();

        try {
            // Llamada al método para ejecutar la simulación.
            prueba.ejecutarSimulacion();
        } catch (Exception e) {
            logger.error("Ha ocurrido un error al iniciar la simulación.", e);
        }
    }

    /**
     * Método que ejecuta la simulación de batalla.
     */
    private void ejecutarSimulacion() {
        try {
            // Ejemplo de cómo el profesor puede crear sus vehículos y guerreros
            List<Guerreros> guerrerosHumanos = crearGuerreros(10);  // Guerreros humanos
            Tanque tanque = crearTanque(guerrerosHumanos); // Crear tanque
            NaveDestructora nave = crearNave(); // Crear nave alienígena

            // Llamada al método de batalla, pasando solo el vehículo del profesor
            simularLucha(tanque); // O simularLucha(nave); dependiendo del vehículo
        } catch (FuerzaExcepcion | EmbarcarExcepcion e) {
            logger.error("Excepción al crear guerreros o vehículos: ", e);
        } catch (Exception e) {
            logger.error("Error general en la simulación: ", e);
        }
    }

    /**
     * Método que simula una lucha entre un tanque y un vehículo genérico (puede ser cualquier tipo de VehiculoGuerra).
     *
     * @param barco El vehículo que luchará contra el tanque
     */
    public void simularLucha(VehiculoGuerra barco) {
        List<Guerreros> guerrerosHumanos;
        Tanque tanque = null;

        try {
            // Crear el tanque con una lista de guerreros humanos
            guerrerosHumanos = crearGuerreros(10);
            tanque = crearTanque(guerrerosHumanos);
        } catch (FuerzaExcepcion | EmbarcarExcepcion e) {
            logger.error("Error al crear los guerreros o el tanque", e);
            return;
        }

        // Simulación de la batalla entre el tanque y el barco
        try {
            while (tanque.getResistencia() > 0 && barco.getResistencia() > 0) {
                // El tanque ataca primero
                int danioTanque = tanque.atacar();
                int defensaNave = barco.defender(danioTanque);
        
                logger.info("\n***Turno " + tanque.getNombre() + " Ataca***");
                if (danioTanque > defensaNave) {
                    barco.setResistencia(barco.getResistencia() - (danioTanque - defensaNave));
                    logger.info("\tEl " + tanque.getNombre() + " ha hecho " + (danioTanque - defensaNave) + " puntos de daño a la nave alienígena.");
        
                    // Verificamos si el barco ha caído
                    if (barco.getResistencia() <= 0) {
                        logger.info("\t¡La nave alienígena ha sido destruida! El tanque ha ganado.");
                        break;
                    }
                } else {
                    logger.info("\tEl " + tanque.getNombre() + " ha atacado pero la nave alienígena ha defendido todo el daño.");
                }
        
                // Ahora la nave alienígena ataca
                int danioNave = barco.atacar();
                int defensaTanque = tanque.defender(danioNave);
        
                logger.info("\n***Turno " + barco.getNombre() + " Ataca***");
                if (danioNave > defensaTanque) {
                    tanque.setResistencia(tanque.getResistencia() - (danioNave - defensaTanque));
                    logger.info("\tLa nave alienígena ha hecho " + (danioNave - defensaTanque) + " puntos de daño al tanque.");
        
                    if (tanque.getResistencia() <= 0) {
                        logger.info("\t¡El tanque ha sido destruido! La nave alienígena ha ganado.");
                        break;
                    }
                } else {
                    logger.info("\tLa nave alienígena ha atacado pero el tanque ha defendido todo el daño.");
                }
            }
        } catch (Exception e) {
            logger.error("Error durante la simulación de la lucha: ", e);
        }
    }

    /**
     * Método que crea guerreros humanos.
     *
     * @param numGuerreros El número de guerreros a crear
     * @return Lista de guerreros creados
     * @throws FuerzaExcepcion Si la fuerza más la resistencia es mayor a 10
     */
    private List<Guerreros> crearGuerreros(int numGuerreros) throws FuerzaExcepcion {
        List<Guerreros> listadoGuerra = new ArrayList<>();
        for (int i = 0; i < numGuerreros; i++) {
            Guerreros guerrero = new Humanos("Humano" + (i + 1), "Soldado");
            listadoGuerra.add(guerrero);
        }
        return listadoGuerra;
    }

    /**
     * Método que crea un tanque a partir de una lista de guerreros.
     *
     * @param guerreros Lista de guerreros para el tanque
     * @return Un objeto Tanque creado
     * @throws EmbarcarExcepcion Si hay un error con el número de guerreros
     */
    private Tanque crearTanque(List<Guerreros> guerreros) throws EmbarcarExcepcion {
        if (guerreros.size() > 10) {
            throw new EmbarcarExcepcion("El tanque no puede embarcar más de 10 humanos.");
        }
        return new Tanque(1000, "Tanque", "Asalto", 8, guerreros);
    }

    /**
     * Método que crea una nave destructora de alienígenas.
     *
     * @return Un objeto NaveDestructora
     */
    private NaveDestructora crearNave() {
        try {
            // Aquí podemos añadir la creación de alienígenas si es necesario
            return new NaveDestructora(1000, "Nave de Guerra", "Acorazado", new ArrayList<>());
        } catch (Exception e) {
            logger.error("Error al crear la nave destructora.", e);
            throw new RuntimeException("Error al crear la nave destructora.", e);
        }
    }
}
