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
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

//calse vehiculo 
public class Vehiculos {

    private String Plate;
    private String Type;
    private String Enter_Time;
    private String Enter_Date;
    private String Service;
    List<Vehiculos> vehiculo = new ArrayList<>(); // para guardar los vehiculos
    HashSet<String> placas = new HashSet<>();// se usa el hash set por su metodo .contains para evaluar si una placa existe o no

    // constructor vacio del ocjeto vehiculo
    public Vehiculos() {
        this.Plate = "";
        this.Type = "";
        this.Enter_Time = "";
        this.Enter_Date = "";
        this.Service = "";
        this.vehiculo = new ArrayList<>();
    }

    //Constructor sobrecargado 
    public Vehiculos(String vPlate, String vType, String vEnter_Time,
            String vEnter_Date, String vService) {
        this.Plate = vPlate;
        this.Type = vType;
        this.Enter_Time = vEnter_Time;
        this.Enter_Date = vEnter_Date;
        this.Service = vService;

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

    public String getEnter_Date() {
        return Enter_Date;
    }

    public void setEnter_Date(String Enter_Date) {
        this.Enter_Date = Enter_Date;
    }

    public void setService(String Service) {
        this.Service = Service;
    }

    public String getService() {
        return Service;
    }

    public List<Vehiculos> getvehiculo() {
        return vehiculo;
    }

    // funcion para registrar entrada de los vehiculos
    public void Registrar_Vehiculo() {
        Gestor_Parqueo gestor = new Gestor_Parqueo();
        Scanner scanner = new Scanner(System.in);
        boolean state = false;

        do { // bucle do..while para validacion de placa
            if (gestor.tieneEspacio()) {
                System.out.print("Ingrese la placa de su vehiculo (abc123): ");
                String placa = scanner.nextLine();
                if (placa.matches("^[a-zA-Z]{3}[0-9]{3}$")) { // regex para formato y elementos de la placa
                    if (!placas.contains(placa)) { // verificacion de unicidad de la placa
                        this.setPlate(placa);
                        placas.add(placa);
                        Gestor_Parqueo.GestorEspacios(this);
                        state = true; // estado para romper el bucle
                    } else {
                        System.out.println("La placa ya se encuentra registrada en el parqueo!");
                    }
                } else {
                    System.out.println("Error, la placa no se encuentra en el formato solicitado");
                }
            } else {
                System.out.println("El parqueo se encuentro lleno lo sentimos!");
                break;
            }
        } while (!state);

        try { // try...catch para validacion en la seleccion del tipo de vehiculo y servicio
            System.out.println("Seleccione el tipo de vehiculo:");
            System.out.println("1. Automovil:");
            System.out.println("2. Motocicleta");
            System.out.println("3. Camion");
            System.out.print("Seleccione una opcion: ");
            int op = scanner.nextInt();

            switch (op) { // switch..case para el seteo del tipo de vehiculo
                case 1 -> {
                    Vehiculos.this.setType("Automovil");
                    break;
                }
                case 2 -> {
                    Vehiculos.this.setType("Motocicleta");
                    break;
                }
                case 3 -> {
                    Vehiculos.this.setType("Camion");
                    break;
                }
            }
            System.out.println("Seleccione el tipo de servicio que desea: ");
            System.out.println("1. Por dia");
            System.out.println("2. Por hora");
            System.out.print("Seleccione su opcion: ");
            int servicio = scanner.nextInt();

            switch (servicio) { // switch...case para el seteo del servicio
                case 1 -> {
                    Vehiculos.this.setService("Por dia");
                    break;
                }
                case 2 -> {
                    Vehiculos.this.setService("Por hora");
                    break;
                }
            }
            //seteo automatico de la hora al momento del registro
            LocalTime hora = LocalTime.now();
            DateTimeFormatter form_hora = DateTimeFormatter.ofPattern("HH:mm"); // formato de la hora
            String hora_entrada = hora.format(form_hora);
            Vehiculos.this.setEnter_Time(hora_entrada); // seteo de la hora
            
            //fecha de ingreso del vehiculo de manera automatica
            LocalDate fecha = LocalDate.now();
            DateTimeFormatter form_fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // formato de la fecha
            String fecha_ingreso = fecha.format(form_fecha);
            Vehiculos.this.setEnter_Date(fecha_ingreso); // seteo de la fecha

            String pl = this.getPlate();
            String ty = this.getType();
            String et = this.getEnter_Time();
            String ed = this.getEnter_Date();
            String se = this.getService();

            Vehiculos nuevo_vehiculo = new Vehiculos(pl, ty, et, ed, se); // creacion del vehiculo
            vehiculo.add(nuevo_vehiculo); // guardado del vehiculo creado
            System.out.println("Su vehiculo ha sido registrado de manera exitosa!");
            scanner.nextLine();
        } catch (InputMismatchException error) {
            System.out.println("Ingrese los datos que se solicitan!");
        }
    }

  // funcion para la salida del vehiculo
   public void Salida_vehiculo() {
    Calculo_tarifas calc = new Calculo_tarifas(); // llamado de la clase Calculo_tarifas que se encarga de manejr los cobros
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese la placa de su vehiculo: "); 
    String pl = scanner.next();

    if (placas.contains(pl)) { // verificacion de la existencia de la placa en el hash set
        Vehiculos encontrado = null; // estado para hacer la verificacion del llamado de la funcion de calculo
        for (Vehiculos v : vehiculo) {
            if (v.getPlate().equalsIgnoreCase(pl)) {
                encontrado = v;
                break;
            }
        }

        if (encontrado != null) { // si encontrado es diferente a nulo
            
            calc.Calculo_tarifa_final(encontrado);

            placas.remove(pl); // se remueve la placa del hash set
            vehiculo.remove(encontrado);  // se remueve el vehiculo de la lista de vehiculos
            Gestor_Parqueo.espacios_totales++;  // aumentan espacios en el parqueo
        }
    } else {
        System.out.println("La matricula no se encuentra registrada o se digito mal!");
    }
}
    
    public void recibo() // generacion de recibo en funcion para llamarlo en Calculo_tarifas y colocarle los demas 
    {
        System.out.println("============");
        System.out.println("===RECIBO===");
        System.out.println("============");
        System.out.println("Placa del vehiculo----------"+Plate);
        System.out.println("Tipo de vehiculo----------"+ Type);
        System.out.println("Servicio solicitado----------"+ Service);
    }
}