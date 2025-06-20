package Controladores;

import Clases.Entrenador;
import Interfaces.EntrenadoresInterface;
import Vistas.Entrenadores;
import Vistas.EntrenadoresTerminal;
import Vistas.SeleccionPokemon;

public class ControladorEntrenadores {
    private EntrenadoresInterface vista;
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private boolean ESGUI;

    /** Este es el constructor de Entrenadores, que recibe "vista" y el booleano "ESGUI",
    * se le asigna el controlador, lo que permite que la vista pueda interactuar con el controlador, 
    * y se guardan los entrenadores en "entrenador1" y "entrenador2". */
    public ControladorEntrenadores(EntrenadoresInterface vista, boolean ESGUI) {
        this.ESGUI = ESGUI;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void iniciar() {
        vista.Iniciar();
    }

    public void crearEntrenadores(String nombreEntrenador1, String nombreEntrenador2) {
        entrenador1 = new Entrenador(nombreEntrenador1);
        entrenador2 = new Entrenador(nombreEntrenador2);
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        entrenador1.elegirPokemonBatallaAutomatico();
        entrenador2.elegirPokemonBatallaAutomatico();
        entrenador1.agregraAtaquesPokemonesAutomatico();
        entrenador2.agregraAtaquesPokemonesAutomatico();
        vista.Mostrar_equipo(entrenador1.getNombre_entrenador(), entrenador1.getEquipo_entrenador());
        vista.Mostrar_equipo(entrenador2.getNombre_entrenador(), entrenador2.getEquipo_entrenador());
        /** Se crea unos nuevos "vistaSeleccion"  y "ControladorSeleccion" (Este ultimo recibe
         * la previamente creada "vistaSeleccion", además de los entrenadores y "ESGUI"), y
         * se llama al metodo "cambiarVista()" de este nuevo controlador. */
        SeleccionPokemon vistaSeleccion = new SeleccionPokemon();
        ControladorSeleccion controladorSeleccion = new ControladorSeleccion(vistaSeleccion, entrenador1, entrenador2, ESGUI);
        controladorSeleccion.cambiarVista();
    }

    /** Este es el metodo que cambia la vista, recibe el booleano "ESGUI", donde se empieza con este
    * mismo en falso, por lo que entra en el "else", y al final de las condiciones, se cambia el valor,
    * en este caso a "true" y se inicia. */
    public void cambiarVista() {
        if (ESGUI) {
            vista = new Vistas.Entrenadores();
        } else {
            vista = new Vistas.EntrenadoresTerminal();
        }
        ESGUI = !ESGUI;
        vista.setControlador(this);
        iniciar();
    }

    public void setESGUI(boolean ESGUI) {
        this.ESGUI = ESGUI;
    }


}
