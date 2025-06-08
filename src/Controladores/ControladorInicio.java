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

    public void IniciarCarga(File[] archivos){
        Entrenador entrenador1 = CargarEntrenador(archivos[0].getAbsolutePath());
        Entrenador entrenador2 = CargarEntrenador(archivos[1].getAbsolutePath());
        ControladorSeleccion controladorSeleccion = new ControladorSeleccion(new Vistas.SeleccionPokemon(), entrenador1, entrenador2, ESGUI);
        controladorSeleccion.cambiarVista();
    }

    public Entrenador CargarEntrenador(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (Entrenador) ois.readObject(); // convierte el archivo en un objeto real
        } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
        }
    }
}
