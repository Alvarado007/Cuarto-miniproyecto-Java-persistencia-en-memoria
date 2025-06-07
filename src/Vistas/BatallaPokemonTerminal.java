package Vistas;

import java.util.Scanner;

import Controladores.ControladorBatalla;
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
        System.out.println("Elija una opcion:");
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
                        if (turno1 == 0) {
                            System.out.println("Vida: " + Vida1);
                        } else {
                            System.out.println(controlador.vida1());
                        }
                        
                        System.out.println("Ataques:");
                        System.out.println("1. " + AtatquePrimerEntrenador1);
                        System.out.println("2. " + AtatquePrimerEntrenador2);
                        System.out.println("3. " + AtatquePrimerEntrenador3);
                        System.out.println("4. " + AtatquePrimerEntrenador4);
                        int ataque = scanner.nextInt();
                        turno1++;
                        if(controlador.atacar(ataque - 1)){
                            System.out.println("Batalla terminada. ");
                            return;
                        }
                        
                    }
                    else{
                        if (turno2 == 0) {
                            System.out.println("Vida: " + Vida2);
                        } else {
                            System.out.println(controlador.vida2());
                        }
                        
                        System.out.println("Ataques:");
                        System.out.println("1. " + AtatqueSegundoEntrenador1);
                        System.out.println("2. " + AtatqueSegundoEntrenador2);
                        System.out.println("3. " + AtatqueSegundoEntrenador3);
                        System.out.println("4. " + AtatqueSegundoEntrenador4);
                        int ataque = scanner.nextInt();
                        turno2++;
                        if(controlador.atacar(ataque - 1)) {
                            System.out.println("Batalla terminada. ");
                            return;
                        }
                    }
                }
                
            }
            case 2:
                controlador.setESGUI(true);
                controlador.cambiarVista();
                break;
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