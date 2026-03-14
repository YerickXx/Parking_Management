/*
 * Yerick Fauricio Abarca
 * Programacion intermedia
 *  Grupo 03
 * Primer Cuatrimestre 2026
 * Tutor:AMADOR SALAZAR OSCAR ANDRES
 */
package Objetos;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author yeric
 */

// clase Calculo_tarifas encargada de calcular pagos
public class Calculo_tarifas {

    public static ArrayList<Registro_final_parqueo> listaAtendidos = new ArrayList<>();

    private int Pago_hora;
    private int Pago_dia;
    private Duration tiempo_parqueo;

    public Calculo_tarifas() {
        this.Pago_hora = 0;
        this.Pago_dia = 0;
        this.tiempo_parqueo = Duration.ZERO;
    }

    //Constructor sobrecargado 
    public Calculo_tarifas(int tPago_hora, int tPago_dia, Duration ttiempo_parqueo) {
        this.Pago_hora = tPago_hora;
        this.Pago_dia = tPago_dia;
        this.tiempo_parqueo = ttiempo_parqueo;
    }

    public Duration getTiempo_parqueo() {
        return tiempo_parqueo;
    }

    public void setTiempo_parqueo(Duration tiempo_parqueo) {
        this.tiempo_parqueo = tiempo_parqueo;
    }

    public int getPago_hora() {
        return Pago_hora;
    }

    public void setPago_hora(int Pago_hora) {
        this.Pago_hora = Pago_hora;
    }

    public int getPago_dia() {
        return Pago_dia;
    }

    public void setPago_dia(int Pago_dia) {
        this.Pago_dia = Pago_dia;
    }
 
    // funcion encargada de hacer el calculo de la tarifa
   public void Calculo_tarifa_final(Vehiculos vehiculo) { 

    DateTimeFormatter format_time = DateTimeFormatter.ofPattern("HH:mm"); // formato que se espera ingrese el usuario
    Scanner scanner = new Scanner(System.in);
    String types = vehiculo.getType();
    String service = vehiculo.getService();

    // Lógica de asignación de tarifas base
    if ((types.equalsIgnoreCase("Automovil") || types.equalsIgnoreCase("Camion")) && service.equalsIgnoreCase("Por hora")) {
        this.setPago_hora(600);
    } else if (types.equalsIgnoreCase("Motocicleta") && service.equalsIgnoreCase("Por hora")) {
        this.setPago_hora(500);
    } else if ((types.equalsIgnoreCase("Automovil") || types.equalsIgnoreCase("Camion")) && service.equalsIgnoreCase("Por dia")) {
        this.setPago_dia(5000);
    } else {
        this.setPago_dia(3000);
    }

    String tiempo = vehiculo.getEnter_Time();
    
    // Solo si el servicio es por hora entramos a la lógica de pedir hora y validar
    if (service.equalsIgnoreCase("Por hora")) { 
        try {
            LocalTime formato_temporal = LocalTime.parse(tiempo);
            LocalTime time = null;
            boolean horaValida = false;

            // bucle de digitacion de la hora de salida solo en caso que el servicio en el registro de entrada sea por hora
            do {
                System.out.print("Ingrese la hora de salida en formato(HH:mm): "); 
                String ops = scanner.next();
                time = LocalTime.parse(ops, format_time);

                // Validación de que la salida sea posterior a la entrada
                if (time.isAfter(formato_temporal)) {
                    horaValida = true;
                } else {
                    System.out.println("Error: La hora de salida debe ser posterior a la de entrada (" + tiempo + ")");
                }
            } while (!horaValida);

            Duration tiempo_transcurrido = Duration.between(formato_temporal, time); // se calcula el tiempo entre la entrada y salida del vehiculo
            
            this.setTiempo_parqueo(tiempo_transcurrido); // seteo del tiempo en parqueo
            Duration oferta = Duration.ofHours(8);
             
            // conversion de horas
            long minutosTotales = tiempo_transcurrido.toMinutes();
            double horasDecimales = minutosTotales / 60.0;

            if (tiempo_transcurrido.compareTo(oferta) >= 0) { // si son 8 o mas horas dentro del parqueo

                // calculo del pago con el descuento
                double totalSinDescuento = horasDecimales * this.getPago_hora();
                double montoDescuento = totalSinDescuento * 0.10;
                double tarifaFinal = totalSinDescuento - montoDescuento;

                vehiculo.recibo();  // llamado de la funcion del recibo
                System.out.println("Tiempo en parqueo: ----------" + horasDecimales + " horas");
                System.out.println("El monto con descuento aplicado (10%) es de: " + tarifaFinal);
                listaAtendidos.add(new Registro_final_parqueo(vehiculo, horasDecimales, tarifaFinal));

            } else {
                long horasRedondeadas = tiempo_transcurrido.toHours();
                if(horasRedondeadas == 0 && minutosTotales > 0) horasRedondeadas = 1;
                
                double result = horasRedondeadas * this.getPago_hora();
                vehiculo.recibo();
                System.out.println("Tiempo en parqueo: ----------" + horasRedondeadas + " horas");
                System.out.println("No se aplico descuento");
                System.out.println("Monto total a pagar----------" + result);
                listaAtendidos.add(new Registro_final_parqueo(vehiculo, (double)horasRedondeadas, result));
            }

        } catch (DateTimeException e) {
            System.out.println("La hora de salida debe tener un formato de: HH:mm además en formato 24 horas");
        }
    } else {
        // Lógica por día no se pide ingreso de hora de salida ya que si el servicio es de un dia es de 24 horas
        vehiculo.recibo();
        System.out.println("Servicio: Por día ");
        System.out.println("Monto a pagar: " + this.getPago_dia());

        listaAtendidos.add(new Registro_final_parqueo(vehiculo, 24.0, (double)this.getPago_dia()));
    }
}
    }
