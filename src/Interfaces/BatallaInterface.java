package Interfaces;

public interface BatallaInterface {

    public void setControlador(Controladores.ControladorBatalla controlador);
    public void Iniciar(String nombre1, String nombre2,String Vida1, String Vida2, String AtatquePrimerEntrenador1, String AtatquePrimerEntrenador2,String AtatquePrimerEntrenador3,String AtatquePrimerEntrenador4, String AtatqueSegundoEntrenador1, String AtatqueSegundoEntrenador2, String AtatqueSegundoEntrenador3, String AtatqueSegundoEntrenador4, String imagen1, String imagen2);
    public void Mensaje(String mensaje);
    public void Borrar();

}