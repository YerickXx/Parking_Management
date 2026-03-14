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
import java.util.Scanner;

// clase del menu principal al programa
public class Menu {

    Vehiculos vehiculo = new Vehiculos();
    Gestor_Parqueo gestor = new Gestor_Parqueo();
    Reportes reports = new Reportes();

    public void Main_menu() {
        boolean state = false;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("BIENVENIDO AL SISTEMA DE PARQUEO!");
                System.out.println("1. Registrar ingreso de vehiculo");
                System.out.println("2. Registrar salida de vehiculo");
                System.out.println("3. Ver espacios disponibles");
                System.out.println("4. Reportes");
                System.out.println("5. Salir del sistema");
                System.out.print("Seleccione una opcion: ");
                int ops = scanner.nextInt();

                switch (ops) {
                    case 1 -> {
                        vehiculo.Registrar_Vehiculo();
                        break;
                    }
                    case 2 -> {
                        vehiculo.Salida_vehiculo();
                        break;
                    }
                    case 3 -> {
                        gestor.CantidadEspacios();
                        break;
                    }
                    case 4 -> {
                        reports.SubMenuReportes();
                        break;
                    }
                    case 5 -> {
                        System.out.println("Gracias por usar nuestro sistema y por confiar en nuestro servicio!");
                        state = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Ingrese los datos que se le solicitan!");
            }
        } while (!state);
    }
}
