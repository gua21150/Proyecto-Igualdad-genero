package ProyectoPOO.src;

import java.sql.Connection;
import java.sql.DriverManager;
public class BasedeDatos {
    
    conexion con;

    public BasedeDatos(){
        try {
            Class.forName("java driver");
            con = DriverManager("datos de la conexion");
        } catch (Exception e) {
            
        }
    }
}
