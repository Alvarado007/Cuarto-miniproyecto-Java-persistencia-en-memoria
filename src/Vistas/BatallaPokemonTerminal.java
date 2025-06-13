package Vistas;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controladores.ControladorBatalla;
import Excepciones.ExcepcionDeRangoIndice;
import Interfaces.BatallaInterface;

public class BatallaPokemonTerminal implements BatallaInterface {

    ControladorBatalla controlador;
    
    Scanner scanner;

    public BatallaPokemonTerminal() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void setControlador(ControladorBatalla controlador) {
        this.controlador = controlador;
    }

    @Override
    public void Iniciar(String nombre1, String nombre2, String Vida1, String Vida2, String AtatquePrimerEntrenador1,
            String AtatquePrimerEntrenador2, String AtatquePrimerEntrenador3, String AtatquePrimerEntrenador4,
            String AtatqueSegundoEntrenador1, String AtatqueSegundoEntrenador2, String AtatqueSegundoEntrenador3,
            String AtatqueSegundoEntrenador4, String imagen1, String imagen2) {
        try {
            System.out.println("Elija una opción:");
            System.out.println("1. Iniciar Batalla");
            System.out.println("2. Cambiar a GUI");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:{
                    this.controlador.setESGUI(false);
                    int turno1 = 0;
                    int turno2 = 0;
                    while (true){
                        if (controlador.get_turno() == 1){
                            try {
                                if (turno1 == 0) {
                                    /** En caso de ser el primer turno de toda la partida, se muestra
                                     * la vida inicial del Pokemon. */
                                    System.out.println("Vida: " + Vida1);
                                } else {
                                    /**En caso de ser otro turno, muestra la vida actual del Pokemon,
                                     * es decir, después de haber recibido un ataque. */
                                    System.out.println("Vida: " + controlador.vida1());
                                }
                        
                                System.out.println("Ataques:");
                                System.out.println("1. " + AtatquePrimerEntrenador1);
                                System.out.println("2. " + AtatquePrimerEntrenador2);
                                System.out.println("3. " + AtatquePrimerEntrenador3);
                                System.out.println("4. " + AtatquePrimerEntrenador4);
                                int ataque = scanner.nextInt();
                                if (ataque > 4 || ataque < 1) {
                                    throw new ExcepcionDeRangoIndice("Número de ataque no válido. Debe ser entre 1 y 4.");
                                }
                                turno1++;
                                if(controlador.atacar(ataque - 1)){
                                    System.out.println("Batalla terminada. ");
                                    return;
                                }
                                
                            }
                            catch (ExcepcionDeRangoIndice e) {
                                System.out.println("Error: " + e.getMessage());
                                scanner.nextLine(); // Limpiar el buffer del scanner
                                continue;
                            }
                            catch (InputMismatchException e) {
                                System.out.println("No se permiten caracteres, ingrese un número de las opciones válidas.");
                                scanner.nextLine(); // Limpiar el buffer del scanner
                                continue;
                            }
                        }
                        /** En caso de ser el turno del Entrenador 2, se aplica lo mismo que el del
                         * Entrenador 1, pero con sus respectivos datos. */
                        else{
                            try {
                                if (turno2 == 0) {
                                    System.out.println("Vida: " + Vida2);
                                } else {
                                    System.out.println("Vida: " + controlador.vida2());
                                }
                        
                                System.out.println("Ataques:");
                                System.out.println("1. " + AtatqueSegundoEntrenador1);
                                System.out.println("2. " + AtatqueSegundoEntrenador2);
                                System.out.println("3. " + AtatqueSegundoEntrenador3);
                                System.out.println("4. " + AtatqueSegundoEntrenador4);
                                int ataque = scanner.nextInt();
                                if (ataque > 4 || ataque < 1) {
                                    throw new ExcepcionDeRangoIndice("Número de ataque no válido. Debe ser entre 1 y 4.");
                                }
                                turno2++;
                                if(controlador.atacar(ataque - 1)) {
                                    System.out.println("Batalla terminada. ");
                                    return;
                                }
                            }
                            catch (ExcepcionDeRangoIndice e) {
                                System.out.println("Error: " + e.getMessage());
                                scanner.nextLine(); // Limpiar el buffer del scanner
                                continue;
                            }
                            catch (InputMismatchException e) {
                                System.out.println("No se permiten caracteres, ingrese un número de las opciones válidas.");
                                scanner.nextLine(); // Limpiar el buffer del scanner
                                continue;
                            }
                        }
                    }
                }
                case 2:
                    controlador.setESGUI(true);
                    controlador.cambiarVista();
                    break;
                
                default:
                    throw new ExcepcionDeRangoIndice("Opción no válida. Por favor, elija una de las opciones disponibles.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("No se permiten caracteres, ingrese un número de las opciones válidas.");
            scanner.nextLine(); // Limpiar el buffer del scanner
            Iniciar(nombre1, nombre2, Vida1, Vida2, AtatquePrimerEntrenador1,
            AtatquePrimerEntrenador2, AtatquePrimerEntrenador3, AtatquePrimerEntrenador4,
            AtatqueSegundoEntrenador1, AtatqueSegundoEntrenador2, AtatqueSegundoEntrenador3,
            AtatqueSegundoEntrenador4, imagen1, imagen2);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Archivo no encontrado.");
            scanner.nextLine(); // Limpiar el buffer del scanner
            Iniciar(nombre1, nombre2, Vida1, Vida2, AtatquePrimerEntrenador1,
            AtatquePrimerEntrenador2, AtatquePrimerEntrenador3, AtatquePrimerEntrenador4,
            AtatqueSegundoEntrenador1, AtatqueSegundoEntrenador2, AtatqueSegundoEntrenador3,
            AtatqueSegundoEntrenador4, imagen1, imagen2);
        }
        catch (ExcepcionDeRangoIndice e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); // Limpiar el buffer del scanner
            Iniciar(nombre1, nombre2, Vida1, Vida2, AtatquePrimerEntrenador1,
            AtatquePrimerEntrenador2, AtatquePrimerEntrenador3, AtatquePrimerEntrenador4,
            AtatqueSegundoEntrenador1, AtatqueSegundoEntrenador2, AtatqueSegundoEntrenador3,
            AtatqueSegundoEntrenador4, imagen1, imagen2);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); // Limpiar el buffer del scanner
            Iniciar(nombre1, nombre2, Vida1, Vida2, AtatquePrimerEntrenador1,
            AtatquePrimerEntrenador2, AtatquePrimerEntrenador3, AtatquePrimerEntrenador4,
            AtatqueSegundoEntrenador1, AtatqueSegundoEntrenador2, AtatqueSegundoEntrenador3,
            AtatqueSegundoEntrenador4, imagen1, imagen2);
        }
        
    }

    @Override
    public void Mensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void Borrar() {
        
    }
    
}