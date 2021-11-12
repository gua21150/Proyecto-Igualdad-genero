package ProyectoPOO.src;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Lectura2 {

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

}
