package ProyectoPOO.src;//agrupando las clases en paquetes

/************************************************
 * Clase de credenciales para que un
 * usuario pueda ingresar a la 
 * página web
 * 
 * @author Pedro Javier Marroquín Abrego 21801
 * @version 1.0
 ***********************************************/
public class Credenciales {
    //atributos
    private String username;
    private String password;
    private String question;
    private String answer;

    /********************************
     * Constructor sin parámetros
     * de unas credenciales
     *******************************/
    Credenciales()
    {
        this.username = "";
        this.password = "";
        this.question = "";
        this.answer = "";
    }
    /******************************************************
     * Constructor de Credenciales
     * @param username El nombre de usuario de la 
     * persona que use la página web
     * @param password Clave de ingreso para accesar
     * al usuario
     * @param question Pregunta de seguridad por si se
     * desea recuperar la cuenta cambiando la clave
     * @param answer Respuesta a la pregunta de seguridad
     ****************************************************/
    Credenciales(String username, String password, String question, String answer)
    {
        this.username = username;
        this.password = password;
        this.question = question;
        this.answer = answer;
    }
    /********************************************
     * Método para grabar el nombre de usuario
     * @param username nombre de usuario
     *******************************************/
    public void setUsername(String username)
    {
        this.username = username;
    }
    /********************************************
     * Recupera el nombre de usuario
     * @return nombre de usuario
     *******************************************/
    public String getUsername()
    {
        return this.username;
    }
    /**********************************************
     * Establece la clave de seguridad del usuario
     * @param password la clave de seguridad
     *********************************************/
    public void setPassword(String password)
    {
        this.password = password;
    }
    /*********************************************
     * Recupera la clave de seguridad del usuario
     * @return String de la clave
     ********************************************/
    public String getPassword()
    {
        return this.password;
    }
    /********************************************
     * Establece una pregunta de seguridad con 
     * la cual un usuario puede cambiar su clave
     * @param question pregunta de seguridad
     *******************************************/
    public void setQuestion(String question)
    {
        this.question = question;
    }
    /************************************************
     * Recupera la pregunta de seguridad determinada
     * por el usuario
     * @return  pregunta de seguridad
     ***********************************************/
    public String getQuestion()
    {
        return this.question;
    }
    /****************************************************
     * Determina la respuesta a la pregunta de seguridad
     * del usuario con la cual permite cambiar la
     * contraseña
     * @param answer respuesta 
     ***************************************************/
    public void setAnswer(String answer)
    {
        this.answer = answer;
    }
    /***************************************************
     * Recupera la respuesta de seguridad para el cambio
     * de contraseña
     * @return La respuesta correcta
     **************************************************/
    public String getAnswer()
    {
        return this.answer;
    }
}