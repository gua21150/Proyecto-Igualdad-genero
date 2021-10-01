package ProyectoPOO.src;
import java.io.IOException;
import java.util.ArrayList;

public class Controlador{
    ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
    ArrayList<Credenciales> credenciales = new ArrayList<>();

    private void leerDatos(ArrayList<String> leidos, String nArchivo) throws IOException{      
        for (String string : archivo.Lectura(nArchivo)) {
            leidos.add(string);
        }  
    }

    private void cargarDatos(){
        ArrayList<String> temporal = new ArrayList<>();
        String nombre;
        String telef;
        String correo;
        String user;
        String password;
        String question;
        String answer;
        int i=0;
        try {
            leerDatos(temporal, "Credenciales.txt");
            for (String string : temporal) {
                user = string.split(",",4)[0].strip();    // split realiza un arreglo que sera separado donde encuentre comas, por ejemplo.
                password = string.split(",", 4)[1].strip(); // se asigna la posicion del vector a una variable temporal
                question = string.split(",", 4)[2].strip();   // se utiliza strip para eliminar cualquier espacio que pueda haber   
                answer = string.split(",", 4)[3].strip();  
                credenciales.add(new Credenciales(user, password, question, answer)); // creacion de objeto credenciales
            }
            temporal.clear(); // se limpia el arreglo antes de volver a utilizarlo
            leerDatos(temporal, "Usuarios.txt");
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

    private boolean validarUsuario(String correo){
        boolean repetido = false; // variable donde se indica si un dato esta repetido o no
        for (Usuario user : usuariosRegistrados) {
            if(user.getcorreo().equals(correo.toLowerCase())) {
                repetido = true;
                break;
            }
        }
        return repetido;
    }

    public void registrarUsuarios() {
        cargarDatos();
        
        if(validarUsuario("correo")){
            // do something 
        }        
    }
}