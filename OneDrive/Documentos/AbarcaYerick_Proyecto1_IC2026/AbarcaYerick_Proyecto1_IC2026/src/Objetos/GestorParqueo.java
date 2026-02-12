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
    List<Vehiculo> vehiculos_en_parqueo = new LinkedList<>(); // almacenamiento de los medios de transporte
    ServicioParqueo services = new ServicioParqueo();
    Scanner scanner = new Scanner(System.in);
    boolean state = false;
    boolean validacion_espacios = services.VerificacionEspacios(vehiculos_en_parqueo);
    public void Register_Vehicle() {

        if (validacion_espacios) {

            do { // ciclo de validacion de la placa

                System.out.print("Ingrese la placa del vehiculo (formato: abc123): ");

                String ops = scanner.next();

                for (int i = 0; i <= ops.length(); i++) // loop de validacion para un largo de cadena de 6 caracteres
                {
                    if (i == 6) {

                        if (ops.matches("^[a-zA-Z]{3}[0-9]+$") && !vehiculo.getPlate().equalsIgnoreCase(ops)) // Expresion regular para validar el valor AlphaNumerico de la placa
                        {
                            vehiculo.setPlate(ops.toUpperCase());
                            state = true;// estado cambia a verdadero para salir del loop de validacion
                        }
                    } else {
                        System.out.println("Se produjo un error en el ingreso de datos intente nuevamente!");
                    }
                }
            } while (!state);
        } else {
            System.out.println("El parqueo esta lleno! regrese mas tarde, gracias por su preferencia");
        }

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

            System.out.println("Seleccione el tipo de servicio que desea adquirir: ");
            System.out.println("1. Servicio por hora");
            System.out.println("2. Servicio por dia");
            System.out.print("Seleccione su opcion: ");
            Integer service = scanner.nextInt();
            try {
                switch (service) {
                    case 1 -> {
                        vehiculo.setService("Por Hora");
                        services.Calculo_Pago_Hora(type);
                        break;
                    }
                    case 2 -> {
                        vehiculo.setService("Por dia");
                        services.Calculo_Pago_dia(type);
                        break;
                    }
                }
            } catch (InputMismatchException error) {
                System.out.println("Debe seleccionar solamente las opciones 1 o 2");
            }
            String Service_type = vehiculo.getService();

            // Setteo automatico de fecha y hora de registro
            LocalDateTime Enter_Date = LocalDateTime.now();
            DateTimeFormatter Format_Date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // formato de fecha y hora
            String formattedDate = Format_Date.format(Enter_Date);
            vehiculo.setEnter_Time(formattedDate);
            String enter = vehiculo.getEnter_Time();

            Vehiculo vehiculo2 = new Vehiculo(plate, type, enter, "Saliendo", Service_type);
            vehiculos_en_parqueo.add(vehiculo2);

            String registro = services.Opciones_Tiempo(vehiculo2);

            System.out.println("=======================");
            System.out.println("          RECIBO         ");
            System.out.println("=======================");
            System.out.println("Matricula registrada......." + plate);
            System.out.println("Tipo de vehiculo......." + type);
            System.out.println("Fecha y hora de ingreso al recinto......." + enter);
            System.out.println("Servicio solicitado......." + Service_type);
            System.out.println(registro);

        } catch (InputMismatchException error) {
            System.out.println("Debe ingresar solamente los datos que le solicitan intente de nuevo!");
        }
    }

    public void Salida_Vehiculo() {
        List<Vehiculo> vehiculos = GestorParqueo.this.vehiculos_en_parqueo;
        System.out.print("Ingrese la matricula de su vehiculo: ");
        String matricula = scanner.nextLine();
        if (matricula.matches("^[a-zA-Z]{3}[0-9]{3}$"))
        {
            for(Vehiculo vehiculoh: vehiculos){
                if(vehiculoh.getPlate().equalsIgnoreCase(matricula))
                {
                   vehiculos.removeIf(v -> v.getPlate().equalsIgnoreCase(matricula));
                }}
        }
        DateTimeFormatter form_date = DateTimeFormatter.ofPattern("DD/MM/YYYY");
        DateTimeFormatter form_hour = DateTimeFormatter.ofPattern("HH:MM");
        System.out.print("Ingrese el dia en la que esta haciendo su salida del parqueo: ");
        String input_date = scanner.nextLine();
        System.out.print("Ingrese la hora en la que esta haciendo su salida del parqueo: ");
        String input_hour = scanner.nextLine();
        try {
            LocalDateTime date = LocalDateTime.parse(input_date, form_date);
            LocalDateTime hour = LocalDateTime.parse(input_hour, form_hour);
            System.out.println("Fecha ingresada: " + date + " " + hour);
        } catch (Exception e) {
            System.out.println("Formato no valida por favor intente nuevamente!");
        }
    }

    public void EspaciosParqueo() {
        String f = services.EspaciosParqueo(vehiculos_en_parqueo);
        System.out.println(f);
    }
}
