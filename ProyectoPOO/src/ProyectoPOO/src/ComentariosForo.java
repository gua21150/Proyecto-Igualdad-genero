package ProyectoPOO.src;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ComentariosForo {    
    private String nombre; // nombre de usuario que ha escrito el comentario
    private String comentario;  // comentario escrito 
    private LocalDate fecha; // fecha en la que se hizo el comentario

    public ComentariosForo() {}

    public ComentariosForo(String nombre, String comentario, LocalDate fecha) {
        this.nombre = nombre;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public ObservableList<ComentariosForo> getComentarios() throws IOException {
        ObservableList<ComentariosForo> obs = FXCollections.observableArrayList(); // tipo lista utilizada en javafx para colocar datos en tablas
        try{
            BasedeDatos conectionBase = new BasedeDatos();
            Connection conection = conectionBase.RealizarConexion();
            Statement statement = conection.createStatement();            

            ResultSet result = statement.executeQuery("SELECT *FROM comentariosforo");
            while(result.next()) {
                obs.add(new ComentariosForo(result.getString("userName"), result.getString("comentario"), result.getDate("fecha").toLocalDate()));
            }
            statement.close();             
        } catch (SQLException e){
            System.out.println("Se ha producido un error al leer la tabla");
        }
        return obs;
    }

    public boolean insertarComentario() throws IOException {
        boolean value = false; 
        BasedeDatos conectionBase = new BasedeDatos();
        Connection conection = conectionBase.RealizarConexion();
        try{
            Statement statement = conection.createStatement(); // realiza la conexion a la base de datos
            String fecha = this.getFecha().getYear() + "-" + this.getFecha().getMonthValue() + "-" + this.getFecha().getDayOfMonth(); // se seleciona la fecha con este formato         
            // este es el query para insertar en la tabla comentariosforo
            String sql = "INSERT INTO comentariosforo (username, comentario, fecha) VALUES ('"
                        +this.getNombre()+"','"
                        +this.getComentario()+"','"
                        +fecha+"');";   
            statement.executeUpdate(sql); // ejecuta el query 
            statement.close();    // cierra el query
            value = true;  // si pudo hacer el cambio entonces lo agrega    
        } catch (SQLException e){
            System.out.println("Se ha producido un error insertando el comentario. Puede deberse a la fecha");
        }
        return value; // retorna el valor de la variable booleana
    }
}
