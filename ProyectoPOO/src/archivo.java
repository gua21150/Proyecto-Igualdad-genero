import java.io.File; // se utiliza para la creacion de un archivo
import java.io.FileNotFoundException; //se utiliza para capturar exceptions del archivo
import java.io.PrintWriter;// se utiliza para escribir sobre el archivo

public class archivo{

public archivo(){}


public void Lectura(){}


public void Escrituta(){
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
            escribir.println("Los que se encuentran en la memoria RAM SDR son: \n");
            //se recorre la lista para agregar los elementos del arreglo al archivo y escribirlos en este.
            /*for(int i=0;i<memoriaSDR.size();i++)
            {
              escribir.println(memoriaSDR.get(i).getPrograma() +","+ memoriaSDR.get(i).getPeso() + ","+ memoriaSDR.get(i).getTiempoe());
            }*/
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
            escribir.println("Los que se encuentran en la memoria RAM SDR son: \n");
           /* for(int i=0;i<memoriaSDR.size();i++)
            {
              escribir.println(memoriaSDR.get(i).getPrograma() +","+ memoriaSDR.get(i).getPeso() + ","+ memoriaSDR.get(i).getTiempoe());
            }*/
            escribir.close();
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        
        
    }
}

}


