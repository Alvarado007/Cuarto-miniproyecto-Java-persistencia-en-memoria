package Interfaces;

import Clases.Pokemon;
import Controladores.ControladorSeleccion;

public interface SeleccionPokemonInterface {
void setControlador( ControladorSeleccion controlador);
void Iniciar(String nombreEntrenador1, String nombreEntrenador2, Pokemon[] pokemonesEntrenador1, Pokemon[] pokemonesEntrenador2);
void Mensaje(String mensaje);

}
