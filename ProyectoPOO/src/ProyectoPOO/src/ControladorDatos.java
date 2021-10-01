package ProyectoPOO.src;

import java.util.Scanner;
/**
 * El objetivo de esta clase es validar los datos ingresados del usuario así como solicitar los datos. 
 * @version 29/09/2021
 * @author Mariel Alejandra Guamuche Recinos 21150
 */
public class ControladorDatos {
    /**
     * Validar que el String ingresado no sea vacío o con un tamaño muy grande
     * @param value String que evalua para verificar que el dato es correcto
     * @return true: si el dato cumple con la especificación, false: si el dato no cumple con la especificación
     */
    private boolean isString(String value) {    
        boolean correcto = false;   // variable booleana donde se guarda la actualización del dato
        if(value.isBlank() || value.isEmpty()) {
            correcto = false;       // valida que el dato no esté en blanco o contenga solo espacios en blanco 
        } else {
            correcto = true;        // cambia el valor a true si cumple con las especificaciones
        } 
        return correcto;
    }
    
    /**
     * Solicitara el dato al usuario hasta que el usuario ingrese el dato con parámetros correctos.
     * @param pregunta: ¿Qué dato desea obtener el usuario?
     * @return dato: respuesta del usuario
     */
    public String SolicitarString(String pregunta) {
        Scanner scanner = new Scanner(System.in); // Scanner para obtener los datos de consola
        String dato;                              // variable que guarda el String de respuesta
        boolean continuar = true;                 // bandera para continuar o no con el proceso 
        do{            
            System.out.println(pregunta); // haya registro de la pregunta generada
            dato = scanner.nextLine();    // obtención del dato
            if(isString(dato)){ 
                continuar = false; // valida que el dato esté corecto, si lo está entonces deberá de parar el ciclo while.              
            }
        } while(continuar);         // ciclo para pedir el mismo dato hasta que cumple la especificaciones
        scanner.close();            // cierra el scanner.
        return dato;                // retorno del dato validado.
    }
    
}
