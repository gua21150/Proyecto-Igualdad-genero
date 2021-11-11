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
public class instituciones {
    
    @FXML
    private Button actividades;

    @FXML
    private Button instituciones;

    @FXML
    private Button lecturas;


    @FXML
    private Button principal;

    @FXML
    void Onactividades(ActionEvent event) throws IOException{
        

    }

    @FXML
    void Oninstituciones(ActionEvent event) throws IOException{

        
    }

    @FXML
    void Onlecturas(ActionEvent event) throws IOException{

    }

    @FXML
    void Onprincipal(ActionEvent event) {

        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
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
    

    }

    @FXML
    void onlink2(ActionEvent event) {

    }

    @FXML
    void onlink3(ActionEvent event) {

    }

    
}
