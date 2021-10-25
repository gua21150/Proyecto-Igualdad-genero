package ProyectoPOO.src;

/**
  * Clase publica Archivo. 
  * Se almacenan los datos del usuario en archivos y se hace uso de escritura y lectura de file.
  *
  * @author Aaron Beltran Campos
  * @author (CoAuthor) Mariel Guamuche 21150
  * @since EL 30 de Septiembre de 2021
  * @version 22102021
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File; // se utiliza para la creacion de un archivo
import java.io.FileNotFoundException; //se utiliza para capturar exceptions del archivo
import java.io.PrintWriter;// se utiliza para escribir sobre el archivo
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;


public class archivo{

    private static Statement createStatement; // utilizado para hacer los sql 
    /**
     * Constructor archivo
     * Se encuentra vacio ya que su funcion es poder crear un objeto de la clase para poder utilizar sus metodos en otras clases.
     * @return no hace
     */
    private archivo(){
        // información ya dada
    }

/**
     * Método lectura
     * Este método de lectura permite 
     * @param nombre: nombre del archivo que el usuario ha dado.
     * @return una lista donde se encuentran las líneas del texto leído.
     * @throws IOException La excepción será levantada en caso de que no se ha encontrado el archivo especificado.
     */
    public static List<String> Lectura(String nombre) throws IOException {

    File file;          // archivo de texto 
    FileReader fr;      // objeto que asegura la lectura del archivo
    BufferedReader bf;  // objeto similar al cursor 
    List<String> datos = new ArrayList<>(); // lista donde se guardan los datos

    // se coloca try-catch para que trate de realizar la lectura, si se levanta una excepción será tomada con el catch.
        try {
            file = new File(nombre);        // se especifica el archivo
            fr = new FileReader(file);      // se asigna a qué archivo se leerá
            bf = new BufferedReader(fr);    // se agrega un cursor de lectura
            String bfRead;                  // linea utilizada para el condicional

            while ((bfRead = bf.readLine()) != null) {
                datos.add(bfRead);           // se ha guardado el texto del archivo 
            }
            bf.close(); // se cierra el cursor
            fr.close(); // se cierra el archivo

        } catch(Exception e)
        {
            System.out.println("No se ha encontrado el texto " + nombre); // excepción 
        }           
        return datos; // retorno de la lista info con los elementos leídos.
    }

/**
     * Método Escritura
     * Este método de escritura permite guardar en un archivo externo en formato txt con los datos ingresados de todos los usuarios
     * tanto como su nombre completo, correo electrónico, contraseña , telefeno , credenciales y etc.
     * @return crea un archivo txt con los datos en la carpeta del proyecto
     * @throws FileNotFoundException La excepción será levantada en caso de que no se ha encontrado el archivo especificado.
     */
public static void Escritura(ArrayList<Usuario>usuarioR){
    // se crea el archivo que contendra  la informacion del programa
    File archivo;
    PrintWriter escribir;
        // se crea el destino y nombre dle archivo a generar
    archivo = new File("Usuario.txt");
    if(!archivo.exists())
    {
        // se utiliza un try and catch para obtener posibles excepciones a partir de la utilizacion de archivos
        try {
           archivo.createNewFile(); // se crea el archivo
        } catch (Exception e) // se captura la posible excepcion
        {
          try{
            escribir=new PrintWriter(archivo);
            //se recorre la lista para agregar los elementos del arreglo al archivo y escribirlos en este.
            for(int i=0;i<usuarioR.size();i++)
            {
              escribir.println(usuarioR.get(i).getnombre() +","+ usuarioR.get(i).gettelefono() + ","+ usuarioR.get(i).getcorreo());
            }
            escribir.close();
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        
        }
    }
    else
    {
        // en caso de que se haya creado el archivo se escriben los datos que contendra el archivo con PrintWriter
        try{
            escribir=new PrintWriter(archivo);
           for(int i=0;i<usuarioR.size();i++)
            {
              escribir.println(usuarioR.get(i).getnombre() +","+ usuarioR.get(i).gettelefono() + ","+ usuarioR.get(i).getcorreo());
            }
            escribir.close();
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        
        
    }
}

/**
     * Método Escritura
     * Este método de escritura permite guardar en un archivo externo en formato txt con los datos ingresados de todos los usuarios
     * tanto como su nombre completo, correo electrónico, contraseña , telefeno , credenciales y etc.
     * @return crea un archivo txt con los datos en la carpeta del proyecto
     * @throws FileNotFoundException La excepción será levantada en caso de que no se ha encontrado el archivo especificado.
     */
    public static void EscrituraCredenciales(ArrayList<Credenciales>credenciales){
        // se crea el archivo que contendra  la informacion del programa
        File archivo;
        PrintWriter escribir;
            // se crea el destino y nombre dle archivo a generar
        archivo = new File("Credenciales.txt");
        if(!archivo.exists())
        {
            // se utiliza un try and catch para obtener posibles excepciones a partir de la utilizacion de archivos
            try {
               archivo.createNewFile(); // se crea el archivo
            } catch (Exception e) // se captura la posible excepcion
            {
              try{
                escribir=new PrintWriter(archivo);
                //se recorre la lista para agregar los elementos del arreglo al archivo y escribirlos en este.
                for(int i=0;i<credenciales.size();i++)
                {
                  escribir.println(credenciales.get(i).getUsername() +","+ credenciales.get(i).getPassword() + ","+ credenciales.get(i).getQuestion()+ ","+ credenciales.get(i).getAnswer());
                }
                escribir.close();
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
            
            }
        }
        else
        {
            // en caso de que se haya creado el archivo se escriben los datos que contendra el archivo con PrintWriter
            try{
                escribir=new PrintWriter(archivo);
               for(int i=0;i<credenciales.size();i++)
                {
                    escribir.println(credenciales.get(i).getUsername() +","+ credenciales.get(i).getPassword() + ","+ credenciales.get(i).getQuestion()+ ","+ credenciales.get(i).getAnswer());
                }
                escribir.close();
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
            
            
        }
    }

    /**
     * Realiza el query para registrar los datos del usuario.
     * @param nom: String con el nombre completo del usuario
     * @param tel: String con el teléfono de contacto del usuario.
     * @param correo: String con el correo del usuario
     * @return true: en caso que se realizo el registro del usuario correctamente para progresar a realizar el registro de la credencial
     * @return false: en caso de que no se realizo el query 
     * @throws SQLException: error con el query de sql
     * @throws IOException se produce cuando no se realiza bien la conexión
     */
    public static boolean registerUser(String nom, String tel, String correo) throws SQLException, IOException{
        BasedeDatos connect = new BasedeDatos();
        Connection connectionDb = connect.RealizarConexion();
        // las siguientes son las instrucciones del query con las variables ingresadas
        String inserFields = "INSERT INTO usuario (nombre, telefono, correo) VALUES('";
        String insertValue = nom + "','" + tel + "','" + correo + "');";
        String inserToReg = inserFields + insertValue;
    
        try {
            createStatement = connectionDb.createStatement();
            Statement statement = createStatement;
            statement.executeUpdate(inserToReg);
            statement.close();
            return true;
        } catch(SQLIntegrityConstraintViolationException e) {
            System.out.println("No se ha podido agregar el dato porque ya se encuentra un correo asociado al dato");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            return false;
        }
    }

    /**
     * Utilizado para realizar el query de registrar credencial en la base de datos
     * @param mail: correo con el que se consigue el id del usuario
     * @param user: nombre de usuario
     * @param pass: contraseña asignada para este usuario
     * @param sques: pregunta de seguridad 
     * @param ques: la pregunta que se mostrará al usuario
     * @param ans: respuesta a la pregunta de seguridad
     * @throws SQLException
     * @throws IOException
     */
    public static void registerCredencial(String mail, String user, String pass, String ques, String ans) throws SQLException, IOException {
        BasedeDatos connect = new BasedeDatos(); // realización de variable que hace la conexión 
        Connection connectionDb = connect.RealizarConexion();
        
        String insertFields = "INSERT INTO credenciales (idUsuario, userName, password, question, answer) VALUES((SELECT idUsuario FROM usuario WHERE correo = '";        
        String insertValue =  mail + "'), '"+ user +"', '" + pass + "', '" + ques + "', '" + ans + "');";
        String inserToReg = insertFields + insertValue;
    
        try {
            Statement statement = connectionDb.createStatement();
            statement.executeUpdate(inserToReg);
            statement.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Este dato no esta asociado con el correo proporcionado");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    /**
     * Cambiar la contraseña en la base de datos 
     * @param pass: String de la contraseña que se debe de cambiar
     * @param user: String usuario de quien se le realizara el cambio
     * @throws IOException
     * @throws SQLException
     */
    public static void cambiarContra(String pass, String user) throws IOException, SQLException {
        BasedeDatos connect = new BasedeDatos(); // realización de variable que hace la conexión 
        Connection connectionDb = connect.RealizarConexion();        
        String updateData = "UPDATE credenciales SET password='"+pass+"' WHERE userName='"+user+"';";
        PreparedStatement ps = connectionDb.prepareStatement(updateData);
        ps.executeUpdate();
        ps.close();
    }
    /**
     * Realiza la lectura de la tabla de usuario y los agrega a una lista de string 
     * Separa los datos con comas
     * @return la lista con datos 
     * @throws IOException error en la conexion a la base de datos
     * @throws SQLException error con algun query 
     */
    public static List<String> leerUsuario() throws  SQLException, IOException {
        BasedeDatos connect = new BasedeDatos(); // realización de variable que hace la conexión 
        Connection connectionDb = connect.RealizarConexion();
        Statement statement = connectionDb.createStatement();
        List<String> datos = new ArrayList<>();

        ResultSet result = statement.executeQuery("SELECT *FROM usuario");
        while(result.next()) {
            datos.add(result.getString("nombre")+","+result.getString("telefono")+","+result.getString("correo"));
        }
        statement.close(); 
        return datos;
    }

    /**
     * Realiza la lectura de la tabla credenciales y los agrega a una lista de string 
     * selecciona las columnas
     * @return la lista de datos
     * @throws IOException error en la conexión a la base de datos
     * @throws SQLException error con algun query de select
     */
    public static List<String> leerCredencial() throws IOException, SQLException {
        BasedeDatos connect = new BasedeDatos(); // realización de variable que hace la conexión 
        Connection connectionDb = connect.RealizarConexion();
        Statement statement = connectionDb.createStatement();
        List<String> datos = new ArrayList<>();

        ResultSet result = statement.executeQuery("SELECT *FROM credenciales");
        while(result.next()) {
            datos.add(result.getString("userName")+","+result.getString("password")+","+result.getString("question")+","+result.getString("answer"));
        }
        statement.close(); 
        return datos;
    }
}