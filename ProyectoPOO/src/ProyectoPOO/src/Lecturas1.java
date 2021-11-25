package ProyectoPOO.src;

import java.io.IOException;
import java.net.URI;
import java.awt.Desktop;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Lecturas1 {

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
            System.out.println("Se ha producido el siguiente fallo: "+e.getCause());
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
            System.out.println("Se ha producido el siguiente fallo: "+e.getCause());
        }
    }

    @FXML
    void OnLectura1(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("lecprincipal.fxml"));
            Stage stage0 = (Stage)  Lecturas.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("Se ha producido el siguiente fallo: "+e.getCause());
        }
    }

    @FXML
    void Onclick1(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://scielo.isciii.es/scielo.php?script=sci_arttext&pid=S1132-05592006000200004"));
    }
}
