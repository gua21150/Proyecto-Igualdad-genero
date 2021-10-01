package ProyectoPOO.src;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            
            int opcion = 0;
            while(opcion!=6) {
                System.out.println("Bienvenido a SIMULADOR por favor revisa nuestras páginas dedicadas a la igualdad");
                System.err.println("1. Página de inicio");
                System.err.println("2. Actividades");
                System.err.println("3. Lecturas");
                System.err.println("4. Registrarse");
                System.err.println("5. Iniciar sesión");
                System.err.println("6. Salir del simulador");
                opcion = ControladorDatos.solicitarInt("Seleccione la opción del menú");

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
                        Controlador.registrarUsuarios(); 
                        System.out.println("Se ha iniciado sesión");
                    break;
                    case 5:
                        Controlador.iniciarSesion();
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
    }
}
