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

// clase principal del objeto vehiculo
public class Vehiculo 
        
{
    private String Plate;
    private String Type;
    private String Enter_Time;
    private String Exit_Time;
    
    
    // constructor vacio del ocjeto vehiculo
    public Vehiculo() 
    {
        this.Plate = "";
        this.Type = "";
        this.Enter_Time = "";
        this.Exit_Time = "";  
    }
    
    //Constructor sobrecargado 
    public Vehiculo(String vPlate,String vType,String vEnter_Time,
     String vExit_Time)
    {
        this.Plate = vPlate;
        this.Type = vType;
        this.Enter_Time = vEnter_Time;
        this.Exit_Time = vExit_Time;
    }

    
    //Getters y Setters de los atributos
    
    public String getPlate() {
        return Plate;
    }

    public void setPlate(String Plate) {
        this.Plate = Plate;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getEnter_Time() {
        return Enter_Time;
    }

    public void setEnter_Time(String Enter_Time) {
        this.Enter_Time = Enter_Time;
    }

    public String getExit_Time() {
        return Exit_Time;
    }

    public void setExit_Time(String Exit_Time) {
        this.Exit_Time = Exit_Time;
    }

    @Override
    public String toString() 
    {

        return "Vehiculo Registrado{" + "Placa: " + Plate + ", Tipo: " + Type + ", Hora de ingreso: " + Enter_Time + ", Hora de salida: " + Exit_Time+ '}'; // borrar este return
    }    

}

