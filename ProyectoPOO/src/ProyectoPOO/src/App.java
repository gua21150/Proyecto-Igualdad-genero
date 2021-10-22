package ProyectoPOO.src;

import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            
            int opcion = 0;
            while(opcion!=6) {
                System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Bienvenido a SIMULADOR por favor revisa nuestras páginas dedicadas a la igualdad");
                System.out.println("1. Página de inicio");
                System.out.println("2. Actividades");
                System.out.println("3. Lecturas");
                System.out.println("4. Registrarse");
                System.out.println("5. Iniciar sesión");
                System.out.println("6. Salir del simulador");
                opcion = ControladorDatos.solicitarInt("Seleccione la opción del menú", scanner);

                switch(opcion) {
                    case 1:
                        System.out.println("Aquí hay información de nuestra página de inicio como nuestros valores, misión y visión");
                    break;
                    case 2: 
                        System.out.println("Actividades para conocer sobre igualdad de género");
                    break;
                    case 3: 
                        System.out.println("Lecturas sobre igualdad de género");
                    break;
                    case 4:                         
                        Controlador.registrarUsuarios(scanner); 
                        System.out.println("Se ha iniciado sesión");
                    break;
                    case 5:
                        launch(args);
                    break;
                    default:
                        System.out.println("Gracias por usar esta página, esperemos cada día una sociedad más igualitaria");
                        opcion = 6;
                    break;
                }
            }
        } catch (Exception e){
            System.out.println("Se ha producido el siguiente error:" + e.getMessage());
        } 
        scanner.close();       
    }

    public void start(Stage stage) throws Exception{
        
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }catch(Exception e)
        {
            System.out.println("algo fallo"+e.getMessage());//throw e;
        }
    }
}