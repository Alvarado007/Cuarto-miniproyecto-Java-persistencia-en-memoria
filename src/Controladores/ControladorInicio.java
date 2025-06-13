package Controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Clases.Entrenador;
import Interfaces.Inicio;
import Vistas.Entrenadores;

public class ControladorInicio {
    private Inicio vista;
    private boolean ESGUI;
    /** Este es el constructor, que recibe "vista" y el booleano "ESGUI", y apenas se crea vista,
    * se le asigna el controlador, lo que permite que la vista pueda interactuar con el controlador. */
    public ControladorInicio(Inicio vista, boolean ESGUI) {
        this.ESGUI = ESGUI;
        this.vista = vista;
        this.vista.SetControlador(this);
    }

    public void iniciarJuego() {
        /**Crea "ControladorEntrenadores", que se le pasa "vistaEntrenadores" y "ESGUI", y después
        * se llama a "cambiarVista()" para cambiar la vista e inicializarlo. */
        Entrenadores vistaEntrenadores = new Entrenadores();
        ControladorEntrenadores controladorEntrenadores = new ControladorEntrenadores(vistaEntrenadores, ESGUI);
        controladorEntrenadores.cambiarVista();
    }

    public void iniciar() {
        vista.Iniciar();
    }

    /** Este es el metodo que cambia la vista, recibe el booleano "ESGUI", donde se empieza con este
    * mismo en falso, por lo que entra en el "else", y al final de las condiciones, se cambia el valor,
    * en este caso a "true" y se inicia. */
    public void cambiarVista() {
        if (ESGUI) {
            vista = new Vistas.InicioPokemon();
        }
        else {
            vista = new Vistas.InicioPokemonTerminal();
        }
        ESGUI = !ESGUI;
        vista.SetControlador(this);
        iniciar();
    }

    public void setESGUI(boolean ESGUI) {
        this.ESGUI = ESGUI;
    }

    /** Se crea "entrenador1" y "entrenador2", los cuales tienen el primer y segundo valor
     * seleccionado ([0] y [1]) respectivamente, que son los archivos seleccionados por el usuario,
     * después se crea un "ControladorSeleccion" que recibe "Vistas.SeleccionPokemon",
     * "entrenador1" y "entrenador2" (que tienen la información de los archivos),y finalmente
     * "ESGUI", y se llama al metodo "cambiarVista()" de este controlador. */
    public void IniciarCarga(File[] archivos){
        Entrenador entrenador1 = CargarEntrenador(archivos[0].getAbsolutePath());
        Entrenador entrenador2 = CargarEntrenador(archivos[1].getAbsolutePath());
        ControladorSeleccion controladorSeleccion = new ControladorSeleccion(new Vistas.SeleccionPokemon(), entrenador1, entrenador2, ESGUI);
        controladorSeleccion.cambiarVista();
    }

    /** Se crea un "ObjectInputStream" que recibe un "FileInputStream" que recibe la ruta de los
     * archivos, después devuelve lo leído de forma binaria, y después se realiza un casting para
     * convertirlo en un "Entrenador". */
    public Entrenador CargarEntrenador(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (Entrenador) ois.readObject(); // convierte el archivo en un objeto real
        }
        catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
        }
    }
}
