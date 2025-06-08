package Vistas;

import java.io.File;
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
        System.out.println("3. Cargar Entrenadores");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                controlador.setESGUI(false);
                controlador.iniciarJuego();
                break;
        
            case 2:
                controlador.cambiarVista();
                break;
            case 3:
                controlador.setESGUI(false);
                File carpeta = new File("src/Guardados");
                File[] archivos_enteros = carpeta.listFiles();
                File[] archivos = new File[2];
                for (int i = 0; i < archivos_enteros.length; i++) {
                    System.out.println((i + 1) + ". " + archivos_enteros[i].getName());
                }
                System.out.println("Seleccione dos archivos para cargar los entrenadores");
                System.out.println("Ingrese el numero del primer archivo:");
                int primerArchivo = scanner.nextInt() - 1;
                System.out.println("Ingrese el numero del segundo archivo:");
                int segundoArchivo = scanner.nextInt() - 1;
                archivos [0] = archivos_enteros[primerArchivo];
                archivos [1] = archivos_enteros[segundoArchivo];
                controlador.IniciarCarga(archivos);
                break;
        }
        
        
        
    }
    
}
