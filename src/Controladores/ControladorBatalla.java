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

    /** El constructor recibe los pokemones seleccionados, la vista de la batalla, la batalla creada
     * y "ESGUI" */
    public ControladorBatalla(Pokemon pokemon1, Pokemon pokemon2, BatallaPokemon vista, Batalla batalla, boolean ESGUI) {
        this.ESGUI = ESGUI;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.vista = vista;
        this.batalla = batalla;
        this.vista.setControlador(this);
    }
    public void iniciar() {
        /** Se toman los nombres de los pokemones elegidos, se determina el turno dependiendo de la
         * velocidad de los mismos, se toma la vida como un String para mostrarla en la vista,
         * y entra al condicional, que dependiendo de "ESGUI" se muestran los ataques de diferente
         * manera, ya que utilizar HTML en terminal no quedaba bien. */
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
        }
        else {
            AtatquePrimerEntrenador1 = pokemon1.getAtaques().get(0).getNombreAtaque() + " daña: " + pokemon1.getAtaques().get(0).getPotencia();
            AtatquePrimerEntrenador2 = pokemon1.getAtaques().get(1).getNombreAtaque() + " daña: " + pokemon1.getAtaques().get(1).getPotencia();
            AtatquePrimerEntrenador3 = pokemon1.getAtaques().get(2).getNombreAtaque() + " daña: " + pokemon1.getAtaques().get(2).getPotencia();
            AtatquePrimerEntrenador4 = pokemon1.getAtaques().get(3).getNombreAtaque() + " daña: " + pokemon1.getAtaques().get(3).getPotencia();
            AtatqueSegundoEntrenador1 = pokemon2.getAtaques().get(0).getNombreAtaque() + " daña: " + pokemon2.getAtaques().get(0).getPotencia();
            AtatqueSegundoEntrenador2 = pokemon2.getAtaques().get(1).getNombreAtaque() + " daña: " + pokemon2.getAtaques().get(1).getPotencia();
            AtatqueSegundoEntrenador3 = pokemon2.getAtaques().get(2).getNombreAtaque() + " daña: " + pokemon2.getAtaques().get(2).getPotencia();
            AtatqueSegundoEntrenador4 = pokemon2.getAtaques().get(3).getNombreAtaque() + " daña: " + pokemon2.getAtaques().get(3).getPotencia();
        }
        /** Se toman las imagenes de los pokemones en batalla, y se llama a "vista.Iniciar", que toma
         * los nombres de los entrenadores, las vidas de los pokemones, los ataques de los pokemones
         * y la imagenes. */
        String imagen1 = Entrenador.getimagenes_Back().get(pokemon1.getNombre());
        String imagen2 = Entrenador.getimagenes_front().get(pokemon2.getNombre());
        vista.Iniciar(nombre1, nombre2, Vida1, Vida2, AtatquePrimerEntrenador1, AtatquePrimerEntrenador2, AtatquePrimerEntrenador3, AtatquePrimerEntrenador4, AtatqueSegundoEntrenador1, AtatqueSegundoEntrenador2, AtatqueSegundoEntrenador3, AtatqueSegundoEntrenador4, imagen1, imagen2);
        if (ESGUI){
            /** Se utiliza vista2.Ocultarbotones() para ocultar los botones de la vista
             * dependiendo del turno, y despues llama a MensajeTurno() para mostrar el turno siguiente. */
            BatallaPokemon vista2 = CastingVista();
            vista2.Ocultarbotones();
            MensajeTurno();
        }
        /** En caso de no ser GUI, simplemente se muestra el mensaje del turno con "MensajeTurno()". */
        else if (!ESGUI){
            MensajeTurno();
        }
    }
    public Boolean atacar(int ataque) {
        if (get_turno() == 1) {
            batalla.atacar(ataque);
            if (ESGUI) {
                /** Se realiza un Casting para acceder a lo propio de la GUI, y posteriormente
                 * se actualiza la vida del Pokemon 2. */
                BatallaPokemon vista2 = CastingVista();
                vista2.actualizar(Short.toString(pokemon2.getVida()));
            }
            /** Se muestra el mensaje de que el Pokemon 1 ha atacado con su ataque actual, y esto
             * mismo se agrega a la pila. */
            vista.Mensaje("Has atacado con " + pokemon1.getNombre() + " con un daño de " + pokemon1.getAtaque_actual());
            pila.push("Has atacado con " + pokemon1.getNombre() + " con un daño de " + pokemon1.getAtaque_actual());
            if (batalla.getPokemonderrotado() == true) {
                /** Si el Pokemon 2 es derrotado, se muestra dicho mensaje y también se agrega a la pila,
                 * Se llama a "Regreso()" para volver a la pantalla de seleccion y se retorna "true"
                 * para controlar el "while" de la terminal. */
                vista.Mensaje("El pokemon " + pokemon2.getNombre() + " ha sido derrotado");
                pila.push("El pokemon " + pokemon2.getNombre() + " ha sido derrotado");
                Regreso();
                return true;
                
            }
            else{
                /** En caso contrario, se muestra el mensaje de que es el turno de Pokemon 2,
                 * y se retorna "false" para controlar el "while" de la terminal.
                 */
                if (ESGUI) {
                    BatallaPokemon vista2 = CastingVista();
                    vista2.Ocultarbotones();
                }
                vista.Mensaje("Es el turno de " + pokemon2.getNombre());
                return false;
            }
        }
        else {
            /** Se realiza lo contrario al caso anterior. */
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
        /** Se borra la pantalla, se crea una nueva "vistaSeleccion" y "controlador", este ultimo
         * recibiendo esa vista, los entrenadores y "ESGUI", se pasa la pila actual del controlador
         * de batalla, el cual tiene los mensajes de los ataques previos, y por último se llama a
         * "cambiarVista" para mostrar la nueva vista. */
        vista.Borrar();
        SeleccionPokemonInterface vistaSeleccion = new SeleccionPokemon();
        ControladorSeleccion controlador = new ControladorSeleccion(vistaSeleccion, batalla.getEntrenador1(), batalla.getEntrenador2(), ESGUI);
        controlador.setPila(pila);
        controlador.cambiarVista();
    }

    /** Este es el metodo que cambia la vista, recibe el booleano "ESGUI", donde se empieza con este
    * mismo en falso, por lo que entra en el "else", y al final de las condiciones, se cambia el valor,
    * en este caso a "true" y se inicia. */
    public void cambiarVista() {
        if (ESGUI) {
            vista = new Vistas.BatallaPokemon();
        }
        else {
            vista = new Vistas.BatallaPokemonTerminal();
        }
        ESGUI = !ESGUI;
        vista.setControlador(this);
        iniciar();
    }

    public void setESGUI(boolean ESGUI) {
        this.ESGUI = ESGUI;
    }

    /** Se realiza un casting para poder tener una copia de "BatallaPokemon", que tienen la misma
     * información pero se definen diferente, para así poder tratar con los métodos propios sin
     * afectar el otro lado. */
    public BatallaPokemon CastingVista() {
        return (BatallaPokemon) vista;
    }
    public void MensajeTurno() {
        if (batalla.getTurno() == 1) {
            vista.Mensaje("Es el turno de " + pokemon1.getNombre());
        }
        else {
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