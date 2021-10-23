package ProyectoPOO.src;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogIn {

    @FXML
    private Button cancelar;

    @FXML
    private PasswordField contraseña;

    @FXML
    private Button ingresar;

    @FXML
    private TextField usuario;

    @FXML
    void onCancelarClick(ActionEvent event) {
        contraseña.clear();
        usuario.clear();
        Platform.exit();
    }

    @FXML
    void onIngresarClick(ActionEvent event) {
        Controlador.iniciarSesion(usuario.getText(), contraseña.getText());
        contraseña.clear();
        usuario.clear();
    }

}
