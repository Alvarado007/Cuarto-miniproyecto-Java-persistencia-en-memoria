import java.util.Scanner;
import java.util.ResourceBundle.Control;

import Clases.Visualizacion;
import Controladores.ControladorInicio;
import Vistas.InicioPokemon;
import Vistas.InicioPokemonTerminal;
import Vistas.InicioPokemon;

public class App {
    public static void main(String[] args) throws Exception {

        /**Se crea e inicializa "InicioPokemonTerminal", y después un controlador que toma el inicio y
        * "ESGUI", que determina si se va a utilizar la interfaz gráfica o la terminal./** */
        InicioPokemonTerminal inicio = new InicioPokemonTerminal();
        ControladorInicio controlador = new ControladorInicio(inicio, false);
        controlador.cambiarVista();
    }
}
