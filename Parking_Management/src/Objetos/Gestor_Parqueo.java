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
import java.util.List;
import java.util.ArrayList;

//clase para gestionar el flujo y almacenamiento de vehiculos en el parqueo
public class Gestor_Parqueo {

    public static int espacios_totales = 10; 
    static List<Vehiculos> nuevo_vehiculo = new ArrayList<>();

    // funcion para verificar si el parqueo tiene espacio
    public static void GestorEspacios(Vehiculos vehiculo) { 
        if (nuevo_vehiculo.size() < 10) {
            nuevo_vehiculo.add(vehiculo); // agregar vehiculo en la lista (parqueo)
        }
        else
        {
            System.out.println("El parqueo se encuentra en su maxima capacidad!");
        }
    }
    
    // funcion ver espacios disponibles en el parqueo
    public void CantidadEspacios() { // verificacion de espacios disponibles en el parqueo
        int espacios = espacios_totales - nuevo_vehiculo.size();
        if(espacios == 5) // verificacion si el parqueo se encuentra al 50%
        {
            System.out.println("ADVERTENCIA: quedan 5 espacios!");
        }
        System.out.println("Espacios disponibles en el parqueo: " + espacios);
    }

    // funcion verificacion de espacios en lista
    public boolean tieneEspacio() {
        return nuevo_vehiculo.size() < espacios_totales; 
    }
    
    // funcion para eliminar un vehiculo de la lista posterior al registrar la salida
    public void BorrarVehiculo(String placa)
    { 
           for(Vehiculos v : nuevo_vehiculo)
           {
               if(v.getPlate().equals(placa))
               {
                   nuevo_vehiculo.remove(v);
               }
           }
        
    }

}
