package ProyectoPOO.src;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Lectura3 {

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
            stage1.show();}
        catch(Exception e){
            System.out.println("Se ha producido el siguiente fallo: "+e.getCause());
        }     
    }

    @FXML
    void OnActividad(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://es.educaplay.com/recursos-educativos/10887062-crucigrama_igualdad_de_genero.html"));
    }

    @FXML
    void OnLecturas(ActionEvent event) {
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
    void OnClickl3(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("http://saludpublica.bvsp.org.bo/cc/bo40.1/documentos/690.pdf"));
    }
}
