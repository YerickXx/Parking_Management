/*
 * Yerick Fauricio Abarca
 * Programacion intermedia
 *  Grupo 03
 * Primer Cuatrimestre 2026
 * Tutor:AMADOR SALAZAR OSCAR ANDRES
 */
package Objetos;

import java.util.Scanner;

/**
 * @author yeric
 */

//clase para el manejo de reportes
public class Reportes {
//Atencion: Los formatos para mostrar la informacion fueron apoyados por IA es decir solo los printf fueron los que tuvieron ese apoyo
    
    public void vehiculosAtendidos() { // funcion encargada de mostrar los vehiculos atendidos posterior a la salida de los mismos
        for (Registro_final_parqueo register : Calculo_tarifas.listaAtendidos) {
            Vehiculos v = register.getVehiculo();
            System.out.println("Tamaño de la lista: " + Calculo_tarifas.listaAtendidos.size());

            //formato de muestreo de informacion
            System.out.println("╔════════════════════════════════════╗");
            System.out.printf("║ PLACA:      %-22s ║%n", v.getPlate());
            System.out.printf("║ TIPO:      %-22s ║%n", v.getType());
            System.out.printf("║ SERVICIO:      %-22s ║%n", v.getService());
            System.out.printf("║ TIEMPO:     %-22s ║%n", register.getDuracion());
            System.out.printf("║ TOTAL:      ₡%-21.2f ║%n", register.getMontoPagado());
            System.out.println("╚════════════════════════════════════╝");
        }

    }

    public void PorcentajeUso() { // funcion para ver el porcentaje de uso del parqueo
        int atendidos = Calculo_tarifas.listaAtendidos.size();
        int max = 10;
        double porcentaje = (atendidos / (double) max) * 100; // calculo para sacar el porcentaje por lo mismo se trabaja en double
        System.out.println("----------------------------------------------");
        System.out.printf(" Ocupación total: %d de %d espacios %n", atendidos, max);
        System.out.printf(" Porcentaje de uso: %.0f%% %n", porcentaje);
        System.out.println("----------------------------------------------");

    }

    // Funcion para ver los pagos totales 
    public void PagosTotales() {
        double acumulado = 0;

        for (Registro_final_parqueo reg : Calculo_tarifas.listaAtendidos) {
            acumulado += reg.getMontoPagado();
        }

        System.out.println("╔════════════════════════════════════╗");
        System.out.printf("║ TOTAL RECAUDADO:  ₡%-15.2f ║%n", acumulado);
        System.out.println("╚════════════════════════════════════╝");
    }
    
    public void HorasTotales() { // funcion para ver las horas totales de uso del parqueo
        double totalHoras = 0;

        for (Registro_final_parqueo reg : Calculo_tarifas.listaAtendidos) {
            totalHoras += reg.getDuracion();
        }

        System.out.println("╔════════════════════════════════════╗");
        System.out.printf("║ HORAS TOTALES DE USO:  %-11.2f ║%n", totalHoras);
        System.out.println("╚════════════════════════════════════╝");
    }

    public void SubMenuReportes() { // sub menu que se encarga de los reportes 
        boolean state = false;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("BIENVENIDO A LA SECCION DE REPORTES!");
                System.out.println("1. Vehiculos atendidos");
                System.out.println("2. Horas totales de uso");
                System.out.println("3. Porcentaje de uso");
                System.out.println("4. Total recaudado");
                System.out.println("5. Volver al menu principal");
                System.out.print("Ingrese su respuesta: ");
                int ops = scanner.nextInt();

                switch (ops) {
                    case 1 -> {
                        this.vehiculosAtendidos();
                        break;
                    }
                    case 2 -> {
                        this.HorasTotales();
                        break;
                    }
                    case 3 -> {
                        this.PorcentajeUso();
                        break;
                    }
                    case 4 -> {
                        this.PagosTotales();
                        break;
                    }
                    case 5 -> {
                        state = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Debe digitar una opcion entre 1 y 5 solamente!!");
            }
        } while (!state);
    }

}
