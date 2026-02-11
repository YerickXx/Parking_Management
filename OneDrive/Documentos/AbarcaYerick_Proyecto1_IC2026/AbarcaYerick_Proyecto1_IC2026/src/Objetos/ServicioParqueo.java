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

public class ServicioParqueo { // Objeto servicio de parqueo
    private double Day_Price;
    private double Hour_Price;
    
    
    public ServicioParqueo() // constructor vacio del objeto Servicio parqueo
    {
        this.Day_Price = 0.0;
        this.Hour_Price = 0.0;
    }
    
    // Constructor sobrecargado de la clase
    public ServicioParqueo(double pDay_Price, double pHour_Price)
    {
        this.Day_Price = pDay_Price;
        this.Hour_Price = pHour_Price;
    }

    public double getDay_Price() {
        return Day_Price;
    }

    public void setDay_Price(double Day_Price) {
        this.Day_Price = Day_Price;
    }

    public double getHour_Price() {
        return Hour_Price;
    }

    public void setHour_Price(double Hour_Price) {
        this.Hour_Price = Hour_Price;
    }
    
    
    public void Calculo_Pago_dia(String Type)
    {
        switch(Type)
        {
            case "Automovil" ->
            {
             ServicioParqueo.this.setDay_Price(5000.00);
            }
            case "Motocicleta" ->
            {
                ServicioParqueo.this.setDay_Price(3000.00);
                break;
            }
            case "Camion" ->
            {
                ServicioParqueo.this.setDay_Price(5000.00);
                break;
            }
        }
    }
    
    public void Calculo_Pago_Hora (String Type)
    {
        switch(Type)
        {
            case "Automovil" ->
            {
             ServicioParqueo.this.setHour_Price(600.00);
            }
            case "Motocicleta" ->
            {
                ServicioParqueo.this.setDay_Price(500.00);
                break;
            }
            case "Camion" ->
            {
                ServicioParqueo.this.setDay_Price(600.00);
                break;
            }
        }
    }
    
    
}
