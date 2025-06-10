package Vistas;

import java.util.InputMismatchException;
import java.util.Scanner;

import Clases.Pokemon;
import Controladores.ControladorSeleccion;
import Excepciones.ExcepcionDeRangoIndice;
import Interfaces.SeleccionPokemonInterface;

public class SeleccionPokemonTerminal implements SeleccionPokemonInterface{

    ControladorSeleccion controlador;
    Scanner scanner;

    public SeleccionPokemonTerminal() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void setControlador(ControladorSeleccion controlador) {
        this.controlador = controlador;
    }

    @Override
    public void Iniciar(String nombreEntrenador1, String nombreEntrenador2, Pokemon[] pokemonesEntrenador1, Pokemon[] pokemonesEntrenador2) {
        try {
            while(true){
                System.out.println("Seleccione una opcion:");
                System.out.println("1. Seleccionar pokemones");
                System.out.println("2. Cambiar a GUI");
                System.out.println("3.Guardar");
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        controlador.setESGUI(false);
                        System.out.println("Entrenador 1: " + nombreEntrenador1);
                        for (int i = 0; i < pokemonesEntrenador1.length; i++) {
                            System.out.println("Pokemon " + (i + 1) + ": " + pokemonesEntrenador1[i].getNombre());
                        }
                        System.out.println("Selecciona un pokemon para iniciar la batalla:");
                        int pokemonSeleccionado1 = scanner.nextInt();
                        System.out.println("Entrenador 2: " + nombreEntrenador2);
                        for (int i = 0; i < pokemonesEntrenador2.length; i++) {
                            System.out.println("Pokemon " + (i + 1) + ": " + pokemonesEntrenador2[i].getNombre());
                        }
                        System.out.println("Selecciona un pokemon para iniciar la batalla:");
                        int pokemonSeleccionado2 = scanner.nextInt();
                        controlador.InicioBatalla(pokemonesEntrenador1[pokemonSeleccionado1 - 1], pokemonesEntrenador2[pokemonSeleccionado2 - 1]);
                        return; // Salir del bucle una vez que se inicia la batalla
                    case 2:
                        controlador.cambiarVista();
                        return; // Salir del bucle una vez que se cambia a GUI
                    case 3:
                        controlador.IniciarGuardado();
                        break;
                    default:
                        throw new ExcepcionDeRangoIndice("Opción no válida. Por favor, elija una opción entre 1 y 3.");
            }
        }
        }
        catch (InputMismatchException e) {
            System.out.println("No se permiten caracteres, ingrese un número de las opciones válidas.");
            scanner.nextLine(); // Limpiar el buffer del scanner
            Iniciar(nombreEntrenador1,nombreEntrenador2,pokemonesEntrenador1,pokemonesEntrenador2);
        }
        catch (ExcepcionDeRangoIndice e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); // Limpiar el buffer del scanner
            Iniciar(nombreEntrenador1,nombreEntrenador2,pokemonesEntrenador1,pokemonesEntrenador2);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Selección de Pokémon fuera de rango.");
            scanner.nextLine(); // Limpiar el buffer del scanner
            Iniciar(nombreEntrenador1,nombreEntrenador2,pokemonesEntrenador1,pokemonesEntrenador2);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); // Limpiar el buffer del scanner
            Iniciar(nombreEntrenador1,nombreEntrenador2,pokemonesEntrenador1,pokemonesEntrenador2);
        }
        
    }

    @Override
    public void Mensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
}
