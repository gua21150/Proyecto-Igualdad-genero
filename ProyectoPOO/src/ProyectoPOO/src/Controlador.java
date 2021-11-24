package ProyectoPOO.src;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * El objetivo de esta clase es mantener la integridad de los datos del modelo MVC.
 * Todos sus métodos son de tipo static porque no se instancian objetos de esta clase.
 * @author Mariel Alejandra Guamuche Recinos 2115
 * @author coauthor: Pedro Javier Marroquín Abrego 21801
 * @since 1.1 01/10/2021
 * @version 22102021
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
     * @throws SQLException: Al realizar la lectura de datos en sql 
     */
    private static void leerDatos(ArrayList<String> leidos, String dato) throws IOException, SQLException{              
        if(dato.equals("usuario")){
            for (String string : archivo.leerUsuario()) {
                leidos.add(string); // recorre la lista devuelta de la lectura del archivo para agregarla al arreglo de referencia
            }
        } else {
            if (dato.equals("credenciales")) {
                for (String string : archivo.leerCredencial()) {
                    leidos.add(string); // recorre la lista devuelta de la lectura del archivo para agregarla al arreglo de referencia
                }
            }
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
            leerDatos(temporal, "credenciales");
            for (String string : temporal) {
                user = string.split(",",4)[0].strip();      // split realiza un arreglo que sera separado donde encuentre comas, por ejemplo.
                password = string.split(",", 4)[1].strip(); // se asigna la posicion del vector a una variable temporal
                question = string.split(",", 4)[2].strip(); // se utiliza strip para eliminar cualquier espacio que pueda haber   
                answer = string.split(",", 4)[3].strip();  
                credenciales.add(new Credenciales(user, password, question, answer)); // creacion de objeto credenciales
            }

            temporal.clear(); // se limpia el arreglo antes de volver a utilizarlo
            leerDatos(temporal, "usuario"); // ahora el arraylist temporal tendrá los datos del archivo usuarios.txt
            
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
     * @throws IOException
     * @throws SQLException
     */
    public static boolean registrarUsuarios(String correo, String nombre, String telef, String user, String password, String question, String answer) throws SQLException, IOException {
        boolean exitoso = false;
        cargarDatos(); // se cargan los datos a las listas creadas
        if(!validarUsuario(correo)){
            // valida que el correo no esté repetido, de no estar repetido, solicitará el resto de datos
            credenciales.add(new Credenciales(user, password, question, answer)); // creación de credencial
            usuariosRegistrados.add(new Usuario(nombre, telef, correo, credenciales.get(credenciales.size()-1))); // creación de usuario
            // hacer actualizacion de escritura de datos
            /*archivo.Escritura(usuariosRegistrados);  archivo.EscrituraCredenciales(credenciales);*/                       
            if(archivo.registerUser(nombre, telef, correo)) {
                archivo.registerCredencial(correo, user, password, question, answer); // realizacion del query en basedatos
                System.out.println("Usuario correctamente creado");
                exitoso = true;
            } else {
                System.out.println("Ha habido un error con la creacion del usuario");
            }
        } else {
            System.out.println("Lo sentimos ese correo ya está asociado a una cuenta.\nIntenta con otro correo o iniciar sesión");
        }
        return exitoso;    
    }

    /**
     * Realiza el proceso de inicio de sesión del usuario.
     * Se pide su username y su contraseña para ser buscado entre los datos ingresados al sistema.
     * @throws SQLException error en el query de cambio
     * @throws IOException error en la conexion con la base de datos
     */
    public static boolean iniciarSesion(String usuario, String password) throws IOException, SQLException {
        boolean match = false;        
        cargarDatos(); // en caso que se haya hecho una actualización en el archivo, se actualizan los datos actuales.
        for (Credenciales credenciales2 : credenciales) {
            if(credenciales2.getUsername().equals(usuario) && credenciales2.getPassword().equals(password)) 
            {
                System.out.println("Hola " + credenciales2.getUsername() + ", es bueno verte de nuevo");
                user = credenciales2.getUsername(); // permitirá obtener el nombre de quien se ha iniciado sesión
                match = true;                 
                break;
            }
            //tiene que redireccionar a recuperar contraseña si lo elige el usuario
            
        }
        if(match == false) {
            System.out.println("No existe el usuario o la contraseña es inválida");
        }
        return match;
    }
    /**
     * Ayuda al usuario a recuperar su contraseña
     * Pide el usuario y luego revisa la pregunta y respuesta de seguridad
     * @param usuario Usuario al que se cambiará la contraseña
     * @param scanner Scanner que se usará para pedir ingresos de datos
     * @throws SQLException error en el query de cambio
     * @throws IOException error en la conexion con la base de datos
     */
    public static String recuperarContrasena(String respuestacorrecta, String nuevopassword, String pregunta) throws IOException, SQLException
    {
        cargarDatos();
        String passwordguardado = "no se pudo guardar la contraseña";
        if(respuestacorrecta.equals("respuesta correcta, escriba su nueva contraseña"))
        {
            for (Credenciales credenciales2: credenciales)
            {
                if(credenciales2.getQuestion().equals(pregunta))
                {
                    if(ControladorDatos.isString(nuevopassword))
                    {
                        credenciales2.setPassword(nuevopassword);
                        archivo.cambiarContra(nuevopassword, credenciales2.getUsername());
                        passwordguardado = "contraseña guardada exitosamente, puede oprimir cancelar para regresar";
                    }else
                    {
                        passwordguardado = "ingrese una contraseña";
                    }
                }
            }
        }
        return passwordguardado;
    }
    public static String buscarUsuario(String usuario) throws IOException, SQLException {   
        String preguntaEncontrada = "no se encontró el usuario";
        cargarDatos();
        for(Credenciales credenciales2: credenciales)
        {
            if(credenciales2.getUsername().equals(usuario))
            {
                preguntaEncontrada = credenciales2.getQuestion();
                break;
            }
        }
        return preguntaEncontrada;
    }
    public static String verificarRespuesta(String pregunta, String respuesta) throws IOException, SQLException
    {
        String correcto = "respuesta incorrecta";
        cargarDatos();
        for(Credenciales credenciales2: credenciales)
        {
            if(credenciales2.getQuestion().equals(pregunta) && credenciales2.getAnswer().equals(respuesta))
            {                
                correcto = "respuesta correcta, escriba su nueva contraseña";                
            }
        }
        return correcto;
    }

    public static String usuarioEnLinea() {
        return user;
    }
}