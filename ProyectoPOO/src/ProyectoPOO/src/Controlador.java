package ProyectoPOO.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * El objetivo de esta clase es mantener la integridad de los datos del modelo MVC.
 * Todos sus métodos son de tipo static porque no se instancian objetos de esta clase.
 * @author Mariel Alejandra Guamuche Recinos 2115
 * @author coauthor: Pedro Javier Marroquín Abrego 21801
 * @version 1.1 01/10/2021
 */
public class Controlador{
    private static ArrayList<Usuario> usuariosRegistrados = new ArrayList<>(); // donde se guardan los usuarios registrados
    private static ArrayList<Credenciales> credenciales = new ArrayList<>();   // se guardan las credenciales registradas al sistema
    private static String nombre; // sirve en varias funciones, se guarda el nombre 
    private static String telef;   // guarda el teléfono 
    private static String correo;  // guarda el correo
    private static String user;    // guarda el username
    private static String password; // guarda la contraseña
    private static String question; // pregunta de seguridad cambio de contraseña
    private static String answer; // respuesta a pregunta de seguridad

    private Controlador(){
        // no se instancian objetos de esta clase
    }

    /**
     * Ingresa los datos del archivo de texto hacia un arreglo que se le ha dado como referencia.
     * @param leidos: ArrayList donde se desea que se copien los datos leídos del archivo
     * @param nArchivo: nombre del archivo de texto 
     * @throws IOException: Si el archivo no ha sido encontrado o ha habido un error al leer el archivo 
     */
    private static void leerDatos(ArrayList<String> leidos, String nArchivo) throws IOException{      
        for (String string : archivo.Lectura(nArchivo)) {
            leidos.add(string); // recorre la lista devuelta de la lectura del archivo para agregarla al arreglo de referencia
        }  
    }

    /**
     * Invoca el método de leerDatos para ingresar sus datos en los ArrayList de usuariosRegistrados y credenciales
     * No realiza ni un return.
     * @throws IndexOutOfBoundsException cuando se ha realizado una mala lectura de posición de datos.
     */
    private static void cargarDatos() throws IndexOutOfBoundsException{
        ArrayList<String> temporal = new ArrayList<>(); // arraylist temporal que se pasa por referencia
        int i=0; // contador para determinar la posición actual del usuario
        try {
            leerDatos(temporal, "Credenciales.txt");
            for (String string : temporal) {
                user = string.split(",",4)[0].strip();      // split realiza un arreglo que sera separado donde encuentre comas, por ejemplo.
                password = string.split(",", 4)[1].strip(); // se asigna la posicion del vector a una variable temporal
                question = string.split(",", 4)[2].strip(); // se utiliza strip para eliminar cualquier espacio que pueda haber   
                answer = string.split(",", 4)[3].strip();  
                credenciales.add(new Credenciales(user, password, question, answer)); // creacion de objeto credenciales
            }

            temporal.clear(); // se limpia el arreglo antes de volver a utilizarlo
            leerDatos(temporal, "Usuarios.txt"); // ahora el arraylist temporal tendrá los datos del archivo usuarios.txt
            
            for (String string : temporal) {                
               nombre = string.split(",",3)[0].strip();    
               telef = string.split(",", 3)[1].strip(); 
               correo = string.split(",", 3)[2].strip();   
               usuariosRegistrados.add(new Usuario(nombre, telef, correo, credenciales.get(i))); // creación de nuevo programa en cola de procesos
               i++; // se aumenta el valor del iterador 
            }
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Se ha producido un error, lo sentimos. El programa será cerrado");            
        } catch (IOException e){
            System.out.println("Se ha producido un error de lectura del archivo, lo sentimos. El programa será cerrado");            
        } catch( Exception e) {
            System.out.println("Se ha producido un error no identificado.");            
        }
    }

    /**
     * Permite validar que no haya un usuario registrado con un mismo correo entre los usuarios ya existentes.
     * @param correo: string con respuesta del usuario
     * @return: true si se ha encontrado repetido el correo
     * @return false si no se ha encontrado el correo repetido
     */
    private static boolean validarUsuario(String correo){
        boolean repetido = false; // variable donde se indica si un dato esta repetido o no
        for (Usuario user : usuariosRegistrados) {
            if(user.getcorreo().equals(correo.toLowerCase())) {
                repetido = true;
                break; // al encontrar el correo no debe de seguir buscando por lo que se rompe el ciclo
            }
        }
        return repetido;
    }

    /**
     * Permite al usuario ingresar sus datos al programa mediante inputs.
     * Se le solicita su nombre, correo, telefono, username, password, pregunta de seguridad y
     * respuesta pregunta de seguridad.
     * Si el correo ingresado está repetido, se le indica.
     */
    public static void registrarUsuarios(Scanner scanner) {
        cargarDatos(); // se cargan los datos a las listas creadas
        System.out.println("Tus datos no serán dado a terceros, al menos que solicites ayuda");
        String respuesta = ControladorDatos.solicitarString("¿Cuál es su correo de inicialización?", scanner);
        if(!validarUsuario(respuesta)){
            correo = respuesta; // valida que el correo no esté repetido, de no estar repetido, solicitará el resto de datos
            nombre = ControladorDatos.solicitarString("Ingresa tu nombre completo", scanner);
            telef = ControladorDatos.solicitarString("¿Cuál es tu numero de telefono?", scanner);
            user = ControladorDatos.solicitarString("Ingresa tu nombre de usuario", scanner);
            password = ControladorDatos.solicitarString("Ingresa tu contraseña", scanner);
            question = ControladorDatos.solicitarString("Ingresa qué debemos de preguntarte cuando quieras recuperar tu contraseña.\nEste es un factor de seguridad.", scanner);
            answer = ControladorDatos.solicitarString("Ingresa la respuesta a tu pregunta", scanner);
            credenciales.add(new Credenciales(user, password, question, answer)); // creación de credencial
            usuariosRegistrados.add(new Usuario(nombre, telef, correo, credenciales.get(credenciales.size()-1))); // creación de usuario
            // hacer actualizacion de escritura de datos
            System.out.println("Usuario correctamente creado");
        } else {
            System.out.println("Lo sentimos ese correo ya está asociado a una cuenta.\nIntenta con otro correo o iniciar sesión");
        }       
    }

    /**
     * Realiza el proceso de inicio de sesión del usuario.
     * Se pide su username y su contraseña para ser buscado entre los datos ingresados al sistema.
     */
    public static void iniciarSesion(Scanner scanner) {
        String inicio = ControladorDatos.solicitarString("Ingresa tu nombre de usuario", scanner);
        password = ControladorDatos.solicitarString("Ingresa tu contraseña", scanner);
        cargarDatos(); // en caso que se haya hecho una actualización en el archivo, se actualizan los datos actuales.
        for (Credenciales credenciales2 : credenciales) {
            if(credenciales2.getUsername().equals(inicio)) {
                if (credenciales2.getPassword().equals(password)) {
                    System.out.println("Hola " + credenciales2.getUsername() + ", es bueno verte de nuevo");
                } else {
                    System.out.println("Contraseña incorrecta\n¿Deseas cambiar tu contraseña?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");
                    int respuesta = ControladorDatos.solicitarInt("-------", scanner);
                    if(respuesta==1) {
                        recuperarContrasena(credenciales2.getUsername(), scanner); 
                    }else{
                        break;
                    }
                }
            }else{
                System.out.println("No existe este usuario.");
            }
        }
    }
    /**
     * Ayuda al usuario a recuperar su contraseña
     * Pide el usuario y luego revisa la pregunta y respuesta de seguridad
     * @param usuario Usuario al que se cambiará la contraseña
     * @param scanner Scanner que se usará para pedir ingresos de datos
     */
    public static void recuperarContrasena(String usuario, Scanner scanner)
    {
        for (Credenciales credenciales2: credenciales)
        {
            if(credenciales2.getUsername().equals(usuario))
            {
                System.out.println(credenciales2.getQuestion());
                String respuesta = ControladorDatos.solicitarString("Ingrese la respuesta a su pregunta de seguridad", scanner);
                if(credenciales2.getAnswer().equals(respuesta))
                {
                    String nueva_contrasena = ControladorDatos.solicitarString("Ingrese su nueva contraseña", scanner);
                    credenciales2.setPassword(nueva_contrasena);
                    System.out.println("Se ha guardado su nueva contraseña exitosamente.");
                }else{
                    System.out.println("¡Respuesta incorrecta!");
                }
            }else{
                System.out.println("No existe este usuario.");
            }
        }
    }
}