package ProyectoPOO.src;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.awt.Desktop;
import java.net.URI;
public class instituciones {
    
    @FXML
    private Button actividades;

    @FXML
    private Button lecturas;


    @FXML
    private Button principal;

    @FXML
    void Onactividades(ActionEvent event) throws IOException{
        
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("paginainicial.fxml"));
            Stage stage0 = (Stage) actividades.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("algo fallo: "+e.getMessage());
        }

    }

    @FXML
    void Onlecturas(ActionEvent event) throws IOException{
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("paginainicial.fxml"));
            Stage stage0 = (Stage) lecturas.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("algo fallo: "+e.getMessage());
        }


    }

    @FXML
    void Onprincipal(ActionEvent event) {

        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("paginainicial.fxml"));
            Stage stage0 = (Stage) principal.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("algo fallo: "+e.getMessage());
        }
    }
    
    @FXML
    void onlink1(ActionEvent event) throws URISyntaxException, IOException {
    Desktop.getDesktop().browse(new URI("http://ggm.org.gt/caimus/"));

    }

    @FXML
    void onlink2(ActionEvent event) throws URISyntaxException, IOException {
    Desktop.getDesktop().browse(new URI("https://miriam-guatemala.org/"));

    }

    @FXML
    void onlink3(ActionEvent event) throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://institutodelavictima.gob.gt/quienes-somos/"));

    }

    
}
