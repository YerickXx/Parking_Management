/*
 * Yerick Fauricio Abarca Nunez
 * Grupo 03
 * Programacion Intermedia
 * Primer Cuatrimestre 2026
 * Each line should be prefixed with  * 
 */

// metodos  para el control de ocupacion del parqueo, administrar flujo vehicular
package Objetos;

/**
 *
 * @author yeric
 */
import java.util.InputMismatchException; 
import java.util.Scanner;
import java.time.LocalDateTime; // paquete para trabajar de manera automatica la fecha y hora
import java.time.format.DateTimeFormatter; // paquete para formatear la hora y dia
import java.util.List;
import java.util.LinkedList;

public class GestorParqueo {

    Vehiculo vehiculo = new Vehiculo();
    List<Vehiculo> autos = new LinkedList<>(); // almacenamiento de los medios de transporte

    public void Register_Vehicle() {
        Scanner scanner = new Scanner(System.in);
        boolean state = false; // estado para comprobar la placa del vehiculo

        do { // ciclo de validacion de la placa
            System.out.print("Ingrese la placa del vehiculo (formato: abc123): ");
            String ops = scanner.next();

                    for (int i = 0; i <= ops.length(); i++) // loop de validacion para un largo de cadena de 6 caracteres
                    {
                        if (i == 6) {
                            if (ops.matches("^[a-zA-Z]{3}[0-9]+$") && !ops.equals(vehiculo.getPlate())) // Expresion regular para validar el valor AlphaNumerico de la placa
                            {
                                    vehiculo.setPlate(ops.toUpperCase());
                                    state = true; // estado cambia a verdadero para salir del loop de validacion
                               
                            } else {
                                System.out.println("Se produjo un error en el ingreso de datos intente nuevamente!");
                            }
                        }
                    }
        
        } while (!state);

        String plate = vehiculo.getPlate();
        try {

            // Seleccion tipo de vehiculo
            System.out.println("Seleccione el tipo de vehiculo: ");
            System.out.println("1. Automovil");
            System.out.println("2. Motocicleta");
            System.out.println("3. Camion");
            System.out.print("Seleccione su opcion: ");
            Integer op = scanner.nextInt();
            switch (op) {
                case 1 -> {
                    vehiculo.setType("Automovil");
                    break;
                }
                case 2 -> {
                    vehiculo.setType("Motocicleta");
                    break;
                }
                case 3 -> {
                    vehiculo.setType("Camion");
                    break;
                }
            }
            String type = vehiculo.getType();

            // Setteo automatico de fecha y hora de registro
            LocalDateTime Enter_Date = LocalDateTime.now();
            DateTimeFormatter Format_Date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // formato de fecha y hora
            String formattedDate = Format_Date.format(Enter_Date);
            vehiculo.setEnter_Time(formattedDate);
            String enter = vehiculo.getEnter_Time();

            Vehiculo vehiculo2 = new Vehiculo(plate, type, enter, "Saliendo");
            autos.add(vehiculo2);
            for (Vehiculo auto : autos) {
                System.out.println(auto);
            }

        } catch (InputMismatchException error) {
            System.out.println("Debe ingresar solamente los datos que le solicitan intente de nuevo!");
            //scanner.next();
        }
    }
}