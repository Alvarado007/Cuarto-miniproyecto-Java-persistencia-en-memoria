package Controladores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

import Clases.Batalla;
import Clases.Entrenador;
import Clases.Pokemon;
import Interfaces.SeleccionPokemonInterface;
import Vistas.BatallaPokemon;

/** Se crea el controlador de la pantalla de seleccion de pokemon, recibe la vista, los entrenadores,
 * "ESGUI" y se crea la pila. */
public class ControladorSeleccion {
    private Interfaces.SeleccionPokemonInterface vista;
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Batalla batalla;
    private boolean ESGUI;
    private Stack<String> pila = new Stack<>();

    
    /** En el constructor se crea el controlador, que recibe la vista, los entrenadores y "ESGUI",
     * y después se asignan los valores de los mismos. */
    public ControladorSeleccion(SeleccionPokemonInterface vista, Entrenador entrenador1, Entrenador entrenador2, boolean ESGUI) {
        this.ESGUI = ESGUI;
        this.vista = vista;
        this.vista.setControlador(this);
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
    }

    /** Se toman los nombres de los entrenadores y sus equipos, estos ultimos se convierten de arrays
     * a una lista normal, para mostrarlos posteriormente en un JList. */
    public void iniciar() {
        String nombreEntrenador1 = entrenador1.getNombre_entrenador();
        String nombreEntrenador2 = entrenador2.getNombre_entrenador();
        Pokemon[] pokemonesEntrenador1 = entrenador1.getEquipo_entrenador().toArray( new Pokemon[0]);
        Pokemon[] pokemonesEntrenador2 = entrenador2.getEquipo_entrenador().toArray( new Pokemon[0]);
        if (ESGUI) {
            Desicion();
        }
        vista.Iniciar(nombreEntrenador1, nombreEntrenador2, pokemonesEntrenador1, pokemonesEntrenador2);
        if (!ESGUI) {
            Desicion();
        }
    }

    public void InicioBatalla(Pokemon pokemon1, Pokemon pokemon2) {
        /** Crea una nueva batalla que recibe los entrenadores y los pokemones seleccionados,
         * se crea una nueva vista y controlador de la batalla, este ultimo tomando los pokemones
         * seleccionados, la nueva vista, la batalla creada y "ESGUI", se pasa la pila del
         * controlador de batalla, y se llama a "cambiarVista". */
        this.batalla = new Batalla(entrenador1, entrenador2, pokemon1, pokemon2);
        BatallaPokemon vistaBatalla = new BatallaPokemon();
        ControladorBatalla controlador = new ControladorBatalla(pokemon1, pokemon2, vistaBatalla, batalla, ESGUI);
        controlador.setPila(pila);
        controlador.cambiarVista();
    }

    public void setBatalla(Batalla batalla) {
        this.batalla = batalla;
    }
    
    /** Este es el metodo que cambia la vista, recibe el booleano "ESGUI", donde se empieza con este
    * mismo en falso, por lo que entra en el "else", y al final de las condiciones, se cambia el valor,
    * en este caso a "true" y se inicia. */
    public void cambiarVista() {
        if (ESGUI) {
            vista = new Vistas.SeleccionPokemon();
        } else {
            vista = new Vistas.SeleccionPokemonTerminal();
        }
        ESGUI = !ESGUI;
        vista.setControlador(this);
        iniciar();
    }

    public void setESGUI(boolean ESGUI) {
        this.ESGUI = ESGUI;
    }

    /** Se comprueba si alguno de los entrenadores no tiene pokemones disponibles antes de
     * seleccionar el pokemon, y de ser así, se muestra el mensaje de que el otro entrenador ganó,
     * y se cierra el programa. */
    public void Desicion() {
        if(entrenador1.getEquipo_entrenador().size() == 0 ) {
            vista.Mensaje("No hay pokemones disponibles para la batalla, el entrenador " + entrenador2.getNombre_entrenador() + " ha ganado");
            System.exit(0);
        }
        else if(entrenador2.getEquipo_entrenador().size() == 0) {
            vista.Mensaje("No hay pokemones disponibles para la batalla, el entrenador " + entrenador1.getNombre_entrenador() + " ha ganado");
            System.exit(0);
        }
    }

    public void IniciarGuardado() {
        GuardarPartida(entrenador1);
        GuardarPartida(entrenador2);
    }

    public void GuardarPartida(Entrenador jugador) {
        /** Se crea una ruta base, la cual aplica para todos los archivos, después el nombre del
         * archivo es el nombre del jugador, al cual se le agrega la extension ".txt", y la
         * ruta completa es la ruta base, y después el nombre del archivo. */
        String rutaBase = "src/Guardados/";
        String nombreArchivo = jugador.getNombre_entrenador() + ".txt"; // usa el nombre del jugador
        String rutaCompleta = rutaBase + nombreArchivo;

        /** Se crea un archivo que toma la ruta completa, y se usa "ObjectOutputStream" para
         * escribir en ese archivo, por medio del "writeObject", guardando esos datos. */
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaCompleta))) {
            oos.writeObject(jugador); // serializa y guarda el objeto en el archivo
            vista.Mensaje("Partida guardada correctamente en: " + rutaCompleta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Vermovimientos(){
        /** Se crea un StringBuilder, el cual empieza con el mensaje "Movimientos realizados:",
         * y posteriormente se realiza un bucle que recorre la pila de movimientos y los muestra,
         * y al final se termina con "------". */
        StringBuilder mensaje = new StringBuilder("Movimientos realizados:\n");
        for (int i = pila.size() - 1; i >= 0; i--) {
            mensaje.append("| ").append(pila.get(i)).append(" |\n");
        }
        mensaje.append("------");

        vista.Mensaje(mensaje.toString());
    }

    public void setPila(Stack<String> pila) {
        this.pila = pila;
    }

    
}