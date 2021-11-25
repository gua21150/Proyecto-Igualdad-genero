package ProyectoPOO.src;
import java.util.Scanner;
/**
 * El objetivo de esta clase es validar los datos ingresados del usuario así como solicitar los datos. 
 * @version 29/09/2021
 * @author Mariel Alejandra Guamuche Recinos 21150
 */
public class ControladorDatos {
    /**
     * Constructor privado porque no se instancia objetos de esta clase.
     */
    private ControladorDatos() {
        // no se implementa porque no se instancian objetos de esta clase
    }
    /**
     * Validar que el String ingresado no sea vacío o con un tamaño muy grande
     * @param value String que evalua para verificar que el dato es correcto
     * @return true: si el dato cumple con la especificación, false: si el dato no cumple con la especificación
     */
    public static boolean isString(String[] value) {    
        boolean correcto = false;  // variable booleana donde se guarda la actualización del dato
        for (String string : value) {
            if(string.isBlank() || string.isEmpty()) {
                correcto = false;
                break;      // valida que el dato no esté en blanco o contenga solo espacios en blanco 
            } else {
                correcto = true;        // cambia el valor a true si cumple con las especificaciones
            } 
        }
        return correcto;
    }

    /**
     * Valida que el string ingresado por el usuario sea un número entero
     * @param value: entrada del usuario
     * @return: true: si el dato es un numero entero, false si el dato no es un número entero.
     */
    private static boolean isInt(String value) {            
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }  

     /**
     * Solicitara el dato al usuario hasta que el usuario ingrese el dato con parámetros correctos (datos de tipo entero).
     * @param pregunta: ¿Qué dato se desea obtener del usuario?
     * @return dato: respuesta del usuario
     */
    public static int solicitarInt(String pregunta, Scanner scanner){
        
        String dato;                                // string donde se guarda la respuesta del scanner
        boolean continuar = true;                   // bandera del ciclo while
        int respuesta=0;                            // donde se guarda la respuesta numerica entera
        do{                                         // ciclo do-while para solicitar el dato hasta que sea correcto
            System.out.println(pregunta);           // se imprime la pregunta
            dato = scanner.nextLine();
            if(isInt(dato)){                    // se valida que sea entero con el metodo creado isInteger
                respuesta = Integer.parseInt(dato); // si es numerico entonces lo parsea a un entero 
                if (respuesta > 0) {                // valida que la respuesta no sean numeros negativos o 0
                    continuar = false;              // de cumplir con la condicion, la bandera cambia a false para que no continue el ciclo 
                }                
            }
        } while(continuar);         
        return respuesta;   // se retorna la respuesta entera
    }
}