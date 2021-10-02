package ProyectoPOO.src;

/**
  * Clase publica Archivo. 
  * Se almacenan los datos del usuario en archivos y se hace uso de escritura y lectura de file.
  *
  * @author Aaron Beltran Campos
  * @version 1.0 FINALIZADO EL 30 de Septiembre de 2021
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File; // se utiliza para la creacion de un archivo
import java.io.FileNotFoundException; //se utiliza para capturar exceptions del archivo
import java.io.PrintWriter;// se utiliza para escribir sobre el archivo


public class archivo{

/**
     * Constructor archivo
     * Se encuentra vacio ya que su funcion es poder crear un objeto de la clase para poder utilizar sus metodos en otras clases.
     * @return no hace
     */
public archivo(){
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
            escribir.println("Los datos del usuario son: \n");
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
            escribir.println("Los del usuario son: \n");
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
                escribir.println("Las credenciales del usuario son: \n");
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
                escribir.println("Las credenciales de seguridad del usuario son: \n");
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

}

