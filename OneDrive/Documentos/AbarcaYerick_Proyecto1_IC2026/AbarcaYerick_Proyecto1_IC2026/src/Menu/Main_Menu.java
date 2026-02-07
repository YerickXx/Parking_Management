/*
 * Yerick Fauricio Abarca Nunez
 * Grupo 03
 * Programacion Intermedia
 * Primer Cuatrimestre 2026
 * Each line should be prefixed with  * 
 */

package Menu;
 import java.util.Scanner;
 import java.util.InputMismatchException;
 import Objetos.GestorParqueo;
/**
 * @author yeric
 */
public class Main_Menu {
    Scanner scanner = new Scanner(System.in);
    GestorParqueo gestor = new GestorParqueo();
    // muestra las opciones del menu principal
    public void Menus()
    {
        System.out.println("=================================");
        System.out.println("SISTEMA ADMINISTRACION DE PARQUEO");
        System.out.println("=================================");
        System.out.println("Seleccione una opcion");
        System.out.println("1. Registrar ingreso de vehiculo");
        System.out.println("2. Registrar salida de vehiculo");
        System.out.println("3. Consultar espacios disponibles");
        System.out.println("4. Ver reportes del dia");
        System.out.println("5. Salir");
        System.out.print("Ingrese su opcion: ");
    } 
    
    
    // se encarga del manejo del menu principal
    public void Menu_Management()
    {
    Integer op = 0;
    do{
    Menus();
    
    try{
    op = scanner.nextInt();
    switch(op)
    {
        case 1 -> 
            {
            gestor.Register_Vehicle();
            break;
            }
        case 2 -> 
            {
            break;
            }
        case 3 -> 
            {
            break;
            }  
        case 4 -> 
            {  
            break;
            }
        case 5 -> 
            { 
            break;
            }
    }
    }catch(InputMismatchException e) // Maneja la excepcion de que el usuario introduzca una letra o caracter
    {
        System.out.println("Debe seleccionar solamente una opcion entre 1-5");
        System.out.println("Intente de nuevo");
        scanner.next(); // Limpia la entrada 
  
        
    }}while(op != 5); // Salida del sistema
    
    
    }
}