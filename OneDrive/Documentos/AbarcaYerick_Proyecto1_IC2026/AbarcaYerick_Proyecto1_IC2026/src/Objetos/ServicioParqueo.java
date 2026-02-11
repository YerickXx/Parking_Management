/*
 * Yerick Fauricio Abarca Nunez
 * Grupo 03
 * Programacion Intermedia
 * Primer Cuatrimestre 2026
 * Each line should be prefixed with  * 
 */
package Objetos;

/*
 * @author yeric
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class ServicioParqueo { // Objeto servicio de parqueo

    private int Day_Price;
    private int Hour_Price;

    public ServicioParqueo() // constructor vacio del objeto Servicio parqueo
    {
        this.Day_Price = 0;
        this.Hour_Price = 0;
    }

    // Constructor sobrecargado de la clase
    public ServicioParqueo(int pDay_Price, int pHour_Price) {
        this.Day_Price = pDay_Price;
        this.Hour_Price = pHour_Price;
    }

    public double getDay_Price() {
        return Day_Price;
    }

    public void setDay_Price(int Day_Price) {
        this.Day_Price = Day_Price;
    }

    public double getHour_Price() {
        return Hour_Price;
    }

    public void setHour_Price(int Hour_Price) {
        this.Hour_Price = Hour_Price;
    }

    public void Calculo_Pago_dia(String Type) {
        switch (Type) {
            case "Automovil" -> {
                ServicioParqueo.this.setDay_Price(5000);
            }
            case "Motocicleta" -> {
                ServicioParqueo.this.setDay_Price(3000);
                break;
            }
            case "Camion" -> {
                ServicioParqueo.this.setDay_Price(5000);
                break;
            }
        }
    }

    public void Calculo_Pago_Hora(String Type) {
        switch (Type) {
            case "Automovil" -> {
                ServicioParqueo.this.setHour_Price(600);
            }
            case "Motocicleta" -> {
                ServicioParqueo.this.setHour_Price(500);
                break;
            }
            case "Camion" -> {
                ServicioParqueo.this.setHour_Price(600);
                break;
            }
        }
    }

    public String Opciones_Tiempo(Vehiculo vehiculo) 
    {
        Scanner scanner = new Scanner(System.in);
        try {
            
            System.out.print("Cuantas horas o dias estara el vehiculo en el recinto(ej: 2): ");
            String ops = scanner.next();
             int num = Integer.parseInt(ops);
             
                    if (vehiculo.getService().equalsIgnoreCase("por hora")) {
                        double result = ServicioParqueo.this.getHour_Price() * num;
                        return "El total a pagar es de: " + result;
                    }
                
                    if (vehiculo.getService().equalsIgnoreCase("por dia")) {
                        double result = ServicioParqueo.this.getDay_Price() * num;
                        return "El total a pagar es de: " + result;
                    }

        } catch (InputMismatchException e) {
            System.out.println("Solamente puede digitar un numero no letras ni caracteres, intente de nuevo!");
        }
        return "";
    }

}
