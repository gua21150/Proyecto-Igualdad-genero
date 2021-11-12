package ProyectoPOO.src;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Lectura1 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Foro;

    @FXML
    private Button Inicio;

    @FXML
    private Button Lecturas;

    @FXML
    void OnForo(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("discusion.fxml"));
            Stage stage0 = (Stage)  Foro.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
            }catch(Exception e){
            System.out.println("algo fallo: "+e.getCause());
        }
    }

    @FXML
    void OnInicio(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("paginainicial.fxml"));
            Stage stage0 = (Stage)  Inicio.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
            }catch(Exception e){
            System.out.println("algo fallo: "+e.getCause());
        }
    }

    @FXML
    void OnLecturas(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Foro != null : "fx:id=\"Foro\" was not injected: check your FXML file 'lectura1.fxml'.";
        assert Inicio != null : "fx:id=\"Inicio\" was not injected: check your FXML file 'lectura1.fxml'.";
        assert Lecturas != null : "fx:id=\"Lecturas\" was not injected: check your FXML file 'lectura1.fxml'.";

    }

}
