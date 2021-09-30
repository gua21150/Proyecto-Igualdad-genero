package ProyectoPOO.src;

public class Usuario {
private String nombre;
private String telefono;
private String correo;
private Credenciales credencial;
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
