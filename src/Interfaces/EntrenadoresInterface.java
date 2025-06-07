package Interfaces;

import java.util.ArrayList;

import Clases.Pokemon;

public interface EntrenadoresInterface {
    void setControlador(Controladores.ControladorEntrenadores controlador);
    void Iniciar();
    void Mostrar_equipo(String nombreEntrenador, ArrayList<Pokemon> equipo);
    
}
