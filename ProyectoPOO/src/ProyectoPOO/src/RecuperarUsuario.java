package ProyectoPOO.src;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RecuperarUsuario {

    @FXML
    private Button Cambiar;

    @FXML
    private Button Cancelar;

    @FXML
    private Button buscar;

    @FXML
    private Label exito;

    @FXML
    private PasswordField nuevopassword;

    @FXML
    private Label nuevopasswordguardado;

    @FXML
    private Label pregunta;

    @FXML
    private TextField respuesta;

    @FXML
    private TextField usuario;

    @FXML
    private Button verificar;

    @FXML
    void OnBuscarPress(ActionEvent event) throws IOException, SQLException {
        pregunta.setText(Controlador.buscarUsuario(usuario.getText()));
    }

    @FXML
    void OnCambiarClick(ActionEvent event) throws IOException, SQLException{
        nuevopasswordguardado.setText(Controlador.recuperarContrasena(exito.getText(), nuevopassword.getText(), pregunta.getText()));
    }

    @FXML
    void OnVerificarPress(ActionEvent event) throws IOException, SQLException {
        exito.setText(Controlador.verificarRespuesta(pregunta.getText(), respuesta.getText()));
    }

    @FXML
    void onCancelarPress(ActionEvent event) {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage0 = (Stage) Cancelar.getScene().getWindow();
            Stage stage1 = new Stage();
            stage0.close();
            stage1.setScene(new Scene(root));
            stage1.show();
        }catch(Exception e){
            System.out.println("Se ha producido el siguiente fallo "+e.getMessage());
        }
    }

}
