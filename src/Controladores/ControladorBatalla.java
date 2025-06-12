package Controladores;

import java.util.Stack;

import Clases.Batalla;
import Clases.Entrenador;
import Clases.Pokemon;
import Interfaces.BatallaInterface;
import Interfaces.SeleccionPokemonInterface;
import Vistas.BatallaPokemon;
import Vistas.SeleccionPokemon;

public class ControladorBatalla {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private BatallaInterface vista;
    private Batalla batalla;
    private boolean ESGUI;
    private  Stack<String> pila;
    //Recibe el modelo batalla no esta todavia
    public ControladorBatalla(Pokemon pokemon1, Pokemon pokemon2, BatallaPokemon vista, Batalla batalla, boolean ESGUI) {
        this.ESGUI = ESGUI;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.vista = vista;
        this.batalla = batalla;
        this.vista.setControlador(this);
    }
    public void iniciar() {
        String nombre1 = pokemon1.getNombre();
        String nombre2 = pokemon2.getNombre();
        batalla.turno();
        String Vida1 = String.valueOf(pokemon1.getVida());
        String Vida2 = String.valueOf(pokemon2.getVida());
        String AtatquePrimerEntrenador1, AtatquePrimerEntrenador2, AtatquePrimerEntrenador3, AtatquePrimerEntrenador4;
        String AtatqueSegundoEntrenador1, AtatqueSegundoEntrenador2, AtatqueSegundoEntrenador3, AtatqueSegundoEntrenador4;
        if (!ESGUI) {
            AtatquePrimerEntrenador1 = "<html>" + pokemon1.getAtaques().get(0).getNombreAtaque() + "<br>" + "daño:" +pokemon1.getAtaques().get(0).getPotencia() + "</html>";
            AtatquePrimerEntrenador2 = "<html>" + pokemon1.getAtaques().get(1).getNombreAtaque() + "<br>" + "daño:" +pokemon1.getAtaques().get(1).getPotencia() + "</html>";
            AtatquePrimerEntrenador3 = "<html>" + pokemon1.getAtaques().get(2).getNombreAtaque() + "<br>" + "daño:" +pokemon1.getAtaques().get(2).getPotencia() + "</html>";
            AtatquePrimerEntrenador4 = "<html>" + pokemon1.getAtaques().get(3).getNombreAtaque() + "<br>" + "daño:" +pokemon1.getAtaques().get(3).getPotencia() + "</html>";
            AtatqueSegundoEntrenador1 = "<html>" + pokemon2.getAtaques().get(0).getNombreAtaque() + "<br>" + "daño:" +pokemon2.getAtaques().get(0).getPotencia() + "</html>";
            AtatqueSegundoEntrenador2 = "<html>" + pokemon2.getAtaques().get(1).getNombreAtaque() + "<br>" + "daño:" +pokemon2.getAtaques().get(1).getPotencia() + "</html>";
            AtatqueSegundoEntrenador3 = "<html>" + pokemon2.getAtaques().get(2).getNombreAtaque() + "<br>" + "daño:" +pokemon2.getAtaques().get(2).getPotencia() + "</html>";
            AtatqueSegundoEntrenador4 = "<html>" + pokemon2.getAtaques().get(3).getNombreAtaque() + "<br>" + "daño:" +pokemon2.getAtaques().get(3).getPotencia() + "</html>";
        } else {
            AtatquePrimerEntrenador1 = pokemon1.getAtaques().get(0).getNombreAtaque() + " daña: " + pokemon1.getAtaques().get(0).getPotencia();
            AtatquePrimerEntrenador2 = pokemon1.getAtaques().get(1).getNombreAtaque() + " daña: " + pokemon1.getAtaques().get(1).getPotencia();
            AtatquePrimerEntrenador3 = pokemon1.getAtaques().get(2).getNombreAtaque() + " daña: " + pokemon1.getAtaques().get(2).getPotencia();
            AtatquePrimerEntrenador4 = pokemon1.getAtaques().get(3).getNombreAtaque() + " daña: " + pokemon1.getAtaques().get(3).getPotencia();
            AtatqueSegundoEntrenador1 = pokemon2.getAtaques().get(0).getNombreAtaque() + " daña: " + pokemon2.getAtaques().get(0).getPotencia();
            AtatqueSegundoEntrenador2 = pokemon2.getAtaques().get(1).getNombreAtaque() + " daña: " + pokemon2.getAtaques().get(1).getPotencia();
            AtatqueSegundoEntrenador3 = pokemon2.getAtaques().get(2).getNombreAtaque() + " daña: " + pokemon2.getAtaques().get(2).getPotencia();
            AtatqueSegundoEntrenador4 = pokemon2.getAtaques().get(3).getNombreAtaque() + " daña: " + pokemon2.getAtaques().get(3).getPotencia();
        }
        String imagen1 = Entrenador.getimagenes_Back().get(pokemon1.getNombre());
        String imagen2 = Entrenador.getimagenes_front().get(pokemon2.getNombre());
        vista.Iniciar(nombre1, nombre2, Vida1, Vida2, AtatquePrimerEntrenador1, AtatquePrimerEntrenador2, AtatquePrimerEntrenador3, AtatquePrimerEntrenador4, AtatqueSegundoEntrenador1, AtatqueSegundoEntrenador2, AtatqueSegundoEntrenador3, AtatqueSegundoEntrenador4, imagen1, imagen2);
        if (ESGUI){
            BatallaPokemon vista2 = CastingVista();
            vista2.Ocultarbotones();
            MensajeTurno();
        }
        else if (!ESGUI){
            MensajeTurno();
        }
    }
    public Boolean atacar(int ataque) {
        if (get_turno() == 1) {
            batalla.atacar(ataque);
            if (ESGUI) {
                BatallaPokemon vista2 = CastingVista();
                vista2.actualizar(Short.toString(pokemon2.getVida()));
            }
            vista.Mensaje("Has atacado con " + pokemon1.getNombre() + " con un daño de " + pokemon1.getAtaque_actual());
            pila.push("Has atacado con " + pokemon1.getNombre() + " con un daño de " + pokemon1.getAtaque_actual());
            if (batalla.getPokemonderrotado() == true) {
                vista.Mensaje("El pokemon " + pokemon2.getNombre() + " ha sido derrotado");
                pila.push("El pokemon " + pokemon2.getNombre() + " ha sido derrotado");
                Regreso();
                return true;
                
            }
            else{
                if (ESGUI) {
                    BatallaPokemon vista2 = CastingVista();
                    vista2.Ocultarbotones();
                }
                vista.Mensaje("Es el turno de " + pokemon2.getNombre());
                return false;
            }
            
        } else {
            batalla.atacar(ataque);
            if (ESGUI) {
                BatallaPokemon vista2 = CastingVista();
                vista2.actualizar(Short.toString(pokemon1.getVida()));
            }
            vista.Mensaje("Has atacado con " + pokemon2.getNombre() + " con un daño de " + pokemon2.getAtaque_actual());
            pila.push("Has atacado con " + pokemon2.getNombre() + " con un daño de " + pokemon2.getAtaque_actual());
            if (batalla.getPokemonderrotado() == true) {
                vista.Mensaje("El pokemon " + pokemon1.getNombre() + " ha sido derrotado");
                pila.push("El pokemon " + pokemon1.getNombre() + " ha sido derrotado");
                Regreso();
                return true;
            }
            else{
                if (ESGUI) {
                    BatallaPokemon vista2 = CastingVista();
                    vista2.Ocultarbotones();
                }
                vista.Mensaje("Es el turno de " + pokemon1.getNombre());
                return false;
            }
        }
    }
    public Byte get_turno() {
        return batalla.getTurno();
    }
    public Byte get_contadorAtaque1() {
        return batalla.getContadorAtaque1();
    }
    public Byte get_contadorAtaque2() {
        return batalla.getContadorAtaque2();
    }  
    
    public void Regreso() {
        vista.Borrar();
        SeleccionPokemonInterface vistaSeleccion = new SeleccionPokemon();
        ControladorSeleccion controlador = new ControladorSeleccion(vistaSeleccion, batalla.getEntrenador1(), batalla.getEntrenador2(), ESGUI);
        controlador.setPila(pila);
        controlador.cambiarVista();
    }

    public void cambiarVista() {
        if (ESGUI) {
            vista = new Vistas.BatallaPokemon();
        } else {
            vista = new Vistas.BatallaPokemonTerminal();
        }
        ESGUI = !ESGUI;
        vista.setControlador(this);
        iniciar();
    }

    public void setESGUI(boolean ESGUI) {
        this.ESGUI = ESGUI;
    }

    public BatallaPokemon CastingVista() {
        return (BatallaPokemon) vista;
    }
    public void MensajeTurno() {
        if (batalla.getTurno() == 1) {
            vista.Mensaje("Es el turno de " + pokemon1.getNombre());
        } else {
            vista.Mensaje("Es el turno de " + pokemon2.getNombre());
        }
    }

    public String vida1() {
        return Short.toString(pokemon1.getVida());
    }

    public String vida2() {
        return Short.toString(pokemon2.getVida());
    }
    public void setPila(Stack<String> pila) {
        this.pila = pila;
    }
    


}