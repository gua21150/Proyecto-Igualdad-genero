package ProyectoPOO.src;
/************************************************
 * Clase para obtener los diferentes datos del usuario 
 * 
 * @author Paulo Raul Sanchez Gonzalez
 * @version 1.0
 ***********************************************/
public class Usuario {
private String nombre; //variable string para guardar el nombre completo de usuario 
private String telefono;//variable string para almacenar el numero de celular
private String correo;//String que almacena el correo electronico del usuario
private Credenciales credencial; //Variable basada en la clase credenciales para guardar la credencial
public Usuario(String nombre, String telefono, String correo, Credenciales credencial)
{
 this.nombre=nombre;
 this.telefono=telefono;
 this.correo=correo;   
 this.credencial=credencial;
}
public String getnombre(){
    return nombre;
}
public void setnombre(String nombre)
{
    this.nombre=nombre;
}
public String gettelefono()
{
    return telefono;
}
public void settelefono(String telefono)
{
    this.telefono=telefono;
}
public String getcorreo()
{
    return correo;

}
public void setcorreo(String correo)
{
    this.correo= correo;
}
public Credenciales getcredencial()
{
    return credencial;
}
public void setcredencial(Credenciales credencial)
{
this.credencial= credencial;
}

}
