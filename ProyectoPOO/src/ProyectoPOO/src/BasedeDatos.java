/**
  * Clase publica BasedeDatos. 
  * Se realiza la conexion entre el el archivo de java y la base de datos ubicada en My SQL.
  *
  * @author Aaron Beltran Campos
  * @version 2.0 FINALIZADO EL 20 de Octubre de 2021
*/

package ProyectoPOO.src;

import java.sql.Connection;// permite realizar la conexion entre java y mysql
import java.sql.DriverManager;// permite 
import java.sql.SQLException;

//Se crea la clase publica de Base de Datos
public class BasedeDatos {

    Connection con;
    
    /**
     * Método Realizar conexion
     * Este método de lectura permite 
     * @return no hace
     * @throws ClassNotFoundException La excepción será levantada en caso de que no se pueda cargar el controlador.
     * @throws SQLException La excepción será levantada en caso de que no se puede conectar con la base de datos.
     */

    public void RealizarConexion(){
        try {
            //se realiza la llamada al driver de java connector
            Class.forName("com.mysql.cj.jdbc.Driver");

            // se coloca la ruta de acceso de la base de datos a la que se desea conectar
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datos","root","Belmar.2017");
            System.out.println("Conexion Exitosa");

            //excepciones
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error en la conexion");
            e.printStackTrace();
        }
    }
}
