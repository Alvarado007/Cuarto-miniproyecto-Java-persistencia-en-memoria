import java.util.Scanner;
import java.util.ResourceBundle.Control;

import Clases.Visualizacion;
import Controladores.ControladorInicio;
import Vistas.InicioPokemon;
import Vistas.InicioPokemonTerminal;
import Vistas.InicioPokemon;

public class App {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        // Visualizacion visualizacion = new Visualizacion();
        // visualizacion.iniciarJuego(sc);
        // sc.close();
        InicioPokemonTerminal inicio = new InicioPokemonTerminal();
        ControladorInicio controlador = new ControladorInicio(inicio, false);
        controlador.cambiarVista();
    }
}
