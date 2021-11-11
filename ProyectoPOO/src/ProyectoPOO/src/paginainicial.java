package ProyectoPOO.src;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class paginainicial {

    @FXML
    private Button Actividades;

    @FXML
    private Button Lecturas;

    @FXML
    private Button iniciarSesion;
    
    @FXML
    private Button instituciones;

    @FXML
    void onPressActividades(ActionEvent event) {

    }

    @FXML
    void onPressIniciarSesion(ActionEvent event) throws IOException {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage0 = (Stage) iniciarSesion.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("algo fallo: "+e.getMessage());
        }
    }

    @FXML
    void onPressLecturas(ActionEvent event) {

    }

    @FXML
    void oninstituciones(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("instituciones.fxml"));
            Stage stage0 = (Stage) instituciones.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("algo fallo: "+e.getMessage());
        }

    }

}
