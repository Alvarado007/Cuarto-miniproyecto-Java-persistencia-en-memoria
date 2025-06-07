package Controladores;

import Interfaces.Inicio;
import Vistas.Entrenadores;

public class ControladorInicio {
    private Inicio vista;
    private boolean ESGUI;

    public ControladorInicio(Inicio vista, boolean ESGUI) {
        this.ESGUI = ESGUI;
        this.vista = vista;
        this.vista.SetControlador(this);
    }

    public void iniciarJuego() {
        Entrenadores vistaEntrenadores = new Entrenadores();
        ControladorEntrenadores controladorEntrenadores = new ControladorEntrenadores(vistaEntrenadores, ESGUI);
        controladorEntrenadores.cambiarVista();

    }

    public void iniciar() {
        vista.Iniciar();
    }

    public void cambiarVista() {
        if (ESGUI) {
            vista = new Vistas.InicioPokemon();
        } else {
            vista = new Vistas.InicioPokemonTerminal();
        }
        ESGUI = !ESGUI;
        vista.SetControlador(this);
        iniciar();
    }

    public void setESGUI(boolean ESGUI) {
        this.ESGUI = ESGUI;
    }
}
