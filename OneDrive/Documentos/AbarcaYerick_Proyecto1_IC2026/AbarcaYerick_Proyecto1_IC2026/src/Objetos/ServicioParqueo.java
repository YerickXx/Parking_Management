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
    private double Hour_Price;
    private double Day_Price;
    
    
    public ServicioParqueo() // constructor vacio del objeto Servicio parqueo
    {
        this.Hour_Price = 0.0;
        this.Day_Price = 0.0;
    }
    
    // Constructor sobrecargado de la clase
    public ServicioParqueo(double sHour_Price, double sDay_Price)
    {
        this.Hour_Price = sHour_Price;
        this.Day_Price = sDay_Price;
    }

    public double getHour_Price() {
        return Hour_Price;
    }

    public void setHour_Price(double Hour_Price) {
        this.Hour_Price = Hour_Price;
    }

    public double getDay_Price() {
        return Day_Price;
    }

    public void setDay_Price(double Day_Price) {
        this.Day_Price = Day_Price;
    }
    
    
}
