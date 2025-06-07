package Vistas;

import java.util.Scanner;

import Controladores.ControladorInicio;
import Interfaces.Inicio;

public class InicioPokemonTerminal implements Inicio{

    ControladorInicio controlador;

    private Scanner scanner;

    

    public InicioPokemonTerminal() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void SetControlador(ControladorInicio controller) {
        this.controlador = controller;
    }

    @Override
    public void Iniciar() {
        System.out.println("Bienvenido al juego de Pokemon Java!");
        System.out.println("Eliga una opcion:");
        System.out.println("1. Iniciar Juego");
        System.out.println("2. Cambiar a GUI");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                controlador.setESGUI(false);
                controlador.iniciarJuego();
                break;
        
            case 2:
                controlador.cambiarVista();
                break;
        }
        
        
        
    }
    
}
