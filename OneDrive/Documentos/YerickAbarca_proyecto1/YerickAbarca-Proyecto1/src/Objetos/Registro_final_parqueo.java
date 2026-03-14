/*
 * Yerick Fauricio Abarca
 * Programacion intermedia
 *  Grupo 03
 * Primer Cuatrimestre 2026
 * Tutor:AMADOR SALAZAR OSCAR ANDRES
 */
package Objetos;
/**
 * @author yeric
 */
 // clase intermedia que se encarga de obtener datos de otras clases para utilizarlo en la seccion reportes
public class Registro_final_parqueo {

    private final Vehiculos vehiculo;
    private final double duracion;
    private final double montoPagado;

    public Registro_final_parqueo(Vehiculos vehiculo, double duracion, double montoPagado) {
        this.vehiculo = vehiculo;
        this.duracion = duracion;
        this.montoPagado = montoPagado;
    }

        public Vehiculos getVehiculo() {
            return vehiculo;
        }

        public double getDuracion() {
            return duracion;
        }

        public double getMontoPagado() {
            return montoPagado;
        }

}
