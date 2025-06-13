package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Enums.TipoDano;
import Enums.TiposPokemon;

public class Entrenador extends SerVivo implements Serializable{
    private String nombre_entrenador;
    private ArrayList<Pokemon> equipo_entrenador;
    private byte contador_pokemones = 0;
    


    public String getNombre_entrenador() {
        return nombre_entrenador;
    }
    
    public ArrayList<Pokemon> getEquipo_entrenador() {
        return equipo_entrenador;
    }
    public void EliminarPokemon(Pokemon pokemon) {
        equipo_entrenador.remove(pokemon);
    }


    public Entrenador(String nombre_entrenador) {
        this.nombre_entrenador = nombre_entrenador;
        this.equipo_entrenador = new ArrayList<Pokemon>();
    }

    public void agregarPokemonEquipo(Pokemon pokemon) {
        if(contador_pokemones < 3) {
            equipo_entrenador.add(pokemon);
            contador_pokemones++;
        }
        else {
            System.out.println("No se pueden agregar más pokemones al equipo.");
        }

    }

    public short randomVida() {
        short vida = (short) (Math.random() * 100 + 100);
        return vida;
    }

    public short randomDefensa() {
        short defensa = (short) (Math.random() * 20 + 20);
        return defensa;
    }
    public short randomVelocidad() {
        short velocidad = (short) (Math.random() * 100 + 50);
        return velocidad;
    }
    public short randomDefensaEspecial() {
        short defensaEspecial = (short) (Math.random() * 25 + 20);
        return defensaEspecial;
    }
    public short randomAtaque() {
        short ataque = (short) (Math.random() * 90 + 95);
        return ataque;
    }

    public void elegirPokemonBatallaAutomatico() {
        /** Se crea el array de pokemones, para guardar los 70 pokemones existentes, 
         * los dos HashMap "tipoPokemon" y "counters", que guardan los tipos de pokemones
         * y sus counters respectivamente, y el ArrayList "nombresPokemones" que guarda los nombres
         * de los mismos. */
        ArrayList<Pokemon> pokemones = new ArrayList<>();
        HashMap<String, TiposPokemon> tipoPokemon = getTipoPokemon();
        HashMap<String, TiposPokemon> counters = getCounters();
        ArrayList<String> nombresPokemones = getPokemones();
        for (int i = 0; i < 70; i++) {
            /** Se elige aleatoriamente un pokemon con "Math.random()" entre todos los pokemones
             * existentes, se toma su nombre, y después su tipo y su counter dependiendo del nombre,
             * después se asigna aleatoriamente los valores de vida, defensa, velocidad, defensa especial
             * y ataque, se crea un nuevo objeto "Pokemon" con estos valores, y finalmente se agrega
             * a la lista de pokemones del entrenador. */
            String nombre = nombresPokemones.get((int) (Math.random() * nombresPokemones.size() ));
            TiposPokemon tipo = tipoPokemon.get(nombre);
            TiposPokemon counter = counters.get(nombre);
            short vida = randomVida();
            short defensa = randomDefensa();
            short velocidad = randomVelocidad();
            short defensaEspecial = randomDefensaEspecial();
            short ataque = randomAtaque();
            Pokemon pokemon = new Pokemon(nombre, tipo, vida, counter, defensa, velocidad, defensaEspecial, ataque);
            pokemones.add(pokemon);
        }
        
            
        for (byte i=0; i<3; i++){
            /** Se eligen aleatoriamente 3 pokemones de la lista de pokemones disponibles con
             * "Math.random()", se toma del pokemon seleccionado su índice, se agrega al equipo
             * del entrenador con "agregarPokemonEquipo(pokemon)", y se elimina de la lista (pueden
             * haber pokemones repetidos en el mismo equipo, pero no con los mismos valores o atributos)". */
            int randomIndex = (int) (Math.random() * pokemones.size());
            Pokemon pokemon = pokemones.get(randomIndex);
            agregarPokemonEquipo(pokemon);
            pokemones.remove(randomIndex);
        }
    }
    public void agregraAtaquesPokemonesAutomatico() {
        ArrayList<Ataque>ataques=Ataque.getAtaques();
        /** Se crea un "for" de todos los pokemones del equipo del entrenador, y dentro hay otro
         * "for" que itera 3 veces(cantidad de ataques normales del pokemon), genera un índice aleatorio
         * después de tomar el tamaño de la lista de ataques, y se verifica si el tipo de ataque
         * es igual al tipo del pokemon, si es así, se agrega el ataque al pokemon y se elimina de la
         * lista de ataques, y si no es así, vuelve a iterar hasta encontrar un ataque que coincida, y
         * a lo último se llama a la funcion "agregraAtaquesPokemonesAutomaticoEspeciales()". */
        for (Pokemon pokemon : equipo_entrenador) {
            for (byte i=0; i<3; i++){
                while (true){
                    int randomIndex = (int) (Math.random() * ataques.size());
                    Ataque ataque = ataques.get(randomIndex);
                    if (ataque.getTipoAtaque().equals(pokemon.getTipo())){
                        pokemon.addAtaque(ataque);
                        ataques.remove(randomIndex);
                        break;
                    } 
                }
            }
        }
        agregraAtaquesPokemonesAutomaticoEspeciales();
    }
    public void agregraAtaquesPokemonesAutomaticoEspeciales() {
        /** Se toma el array de todos los ataques especiales, y se realiza el mismo procedimiento
         * que con los ataques normales, pero esta vez solo itera una vez, ya que el pokemon solo
         * puede tener un ataque especial. */
        ArrayList<Ataque>ataques=Ataque.getAtaquesEspeciales();
        for (Pokemon pokemon : equipo_entrenador) {
            for (byte i=0; i<1; i++){
                while (true){
                    int randomIndex = (int) (Math.random() * ataques.size());
                    Ataque ataque = ataques.get(randomIndex);
                    if (ataque.getTipoAtaque().equals(pokemon.getTipo())){
                        pokemon.addAtaque(ataque);
                        ataques.remove(randomIndex);
                        break;
                    } 
                }
            }
        }
    }

    public void mostrarEquipo() {
        byte contador = 1;
        for (Pokemon pokemon : equipo_entrenador) {
            System.out.println(nombre_entrenador + " Nombre del pokémon " + contador++ + ": " + pokemon.getNombre() + ", Tipo: " + pokemon.getTipo() + ", Vida: " + pokemon.getVida());
            pokemon.mostrarAtaques();
        }
    }
    static public HashMap<String, String> getimagenes_front() {
        HashMap<String, String> imagenes = new HashMap<>();

        imagenes.put("Abra", "/Imagenes/Pokemones/Front/Abra.gif");
        imagenes.put("Alakazam", "/Imagenes/Pokemones/Front/Alakazam.gif");
        imagenes.put("Arcanine", "/Imagenes/Pokemones/Front/Arcanine.gif");
        imagenes.put("Blastoise", "/Imagenes/Pokemones/Front/Blastoise.gif");
        imagenes.put("Bulbasaur", "/Imagenes/Pokemones/Front/Bulbasaur.gif");
        imagenes.put("Celebi", "/Imagenes/Pokemones/Front/Celebi.gif");
        imagenes.put("Charizard", "/Imagenes/Pokemones/Front/Charizard.gif");
        imagenes.put("Charmander", "/Imagenes/Pokemones/Front/Charmander.gif");
        imagenes.put("Delphox", "/Imagenes/Pokemones/Front/Delphox.gif");
        imagenes.put("Eevee", "/Imagenes/Pokemones/Front/Eevee.gif");
        imagenes.put("Gardevoir", "/Imagenes/Pokemones/Front/Gardevoir.gif");
        imagenes.put("Gengar", "/Imagenes/Pokemones/Front/Gengar.gif");
        imagenes.put("Greninja", "/Imagenes/Pokemones/Front/Greninja.gif");
        imagenes.put("Gyarados", "/Imagenes/Pokemones/Front/Gyarados.gif");
        imagenes.put("Incineroar", "/Imagenes/Pokemones/Front/Incineroar.gif");
        imagenes.put("Jigglypuff", "/Imagenes/Pokemones/Front/Jigglypuff.gif");
        imagenes.put("Lucario", "/Imagenes/Pokemones/Front/Lucario.gif");
        imagenes.put("Lugia", "/Imagenes/Pokemones/Front/Lugia.gif");
        imagenes.put("Magikarp", "/Imagenes/Pokemones/Front/Magikarp.gif");
        imagenes.put("Meowth", "/Imagenes/Pokemones/Front/Meowth.gif");
        imagenes.put("Mewtwo", "/Imagenes/Pokemones/Front/Mewtwo.gif");
        imagenes.put("Pikachu", "/Imagenes/Pokemones/Front/Pikachu.gif");
        imagenes.put("Psyduck", "/Imagenes/Pokemones/Front/Psyduck.gif");
        imagenes.put("Raichu", "/Imagenes/Pokemones/Front/Raichu.gif");
        imagenes.put("Rayquaza", "/Imagenes/Pokemones/Front/Rayquaza.gif");
        imagenes.put("Squirtle", "/Imagenes/Pokemones/Front/Squirtle.gif");

        return imagenes;
    }

    static public HashMap<String, String> getimagenes_Back() {
        HashMap<String, String> imagenes = new HashMap<>();

        imagenes.put("Abra", "/Imagenes/Pokemones/Back/Abra.gif");
        imagenes.put("Alakazam", "/Imagenes/Pokemones/Back/Alakazam.gif");
        imagenes.put("Arcanine", "/Imagenes/Pokemones/Back/Arcanine.gif");
        imagenes.put("Blastoise", "/Imagenes/Pokemones/Back/Blastoise.gif");
        imagenes.put("Bulbasaur", "/Imagenes/Pokemones/Back/Bulbasaur.gif");
        imagenes.put("Celebi", "/Imagenes/Pokemones/Back/Celebi.gif");
        imagenes.put("Charizard", "/Imagenes/Pokemones/Back/Charizard.gif");
        imagenes.put("Charmander", "/Imagenes/Pokemones/Back/Charmander.gif");
        imagenes.put("Delphox", "/Imagenes/Pokemones/Back/Delphox.gif");
        imagenes.put("Eevee", "/Imagenes/Pokemones/Back/Eevee.gif");
        imagenes.put("Gardevoir", "/Imagenes/Pokemones/Back/Gardevoir.gif");
        imagenes.put("Gengar", "/Imagenes/Pokemones/Back/Gengar.gif");
        imagenes.put("Greninja", "/Imagenes/Pokemones/Back/Greninja.gif");
        imagenes.put("Gyarados", "/Imagenes/Pokemones/Back/Gyarados.gif");
        imagenes.put("Incineroar", "/Imagenes/Pokemones/Back/Incineroar.gif");
        imagenes.put("Jigglypuff", "/Imagenes/Pokemones/Back/Jigglypuff.gif");
        imagenes.put("Lucario", "/Imagenes/Pokemones/Back/Lucario.gif");
        imagenes.put("Lugia", "/Imagenes/Pokemones/Back/Lugia.gif");
        imagenes.put("Magikarp", "/Imagenes/Pokemones/Back/Magikarp.gif");
        imagenes.put("Meowth", "/Imagenes/Pokemones/Back/Meowth.gif");
        imagenes.put("Mewtwo", "/Imagenes/Pokemones/Back/Mewtwo.gif");
        imagenes.put("Pikachu", "/Imagenes/Pokemones/Back/Pikachu.gif");
        imagenes.put("Psyduck", "/Imagenes/Pokemones/Back/Psyduck.gif");
        imagenes.put("Raichu", "/Imagenes/Pokemones/Back/Raichu.gif");
        imagenes.put("Rayquaza", "/Imagenes/Pokemones/Back/Rayquaza.gif");
        imagenes.put("Squirtle", "/Imagenes/Pokemones/Back/Squirtle.gif");

        return imagenes;
    }

    public HashMap<String, TiposPokemon> getTipoPokemon() {
        HashMap<String, TiposPokemon> tipoPokemon = new HashMap<>();

        tipoPokemon.put("Abra", TiposPokemon.PSIQUICO);
        tipoPokemon.put("Alakazam", TiposPokemon.PSIQUICO);
        tipoPokemon.put("Arcanine", TiposPokemon.FUEGO);
        tipoPokemon.put("Blastoise", TiposPokemon.AGUA);
        tipoPokemon.put("Bulbasaur", TiposPokemon.AGUA);
        tipoPokemon.put("Celebi", TiposPokemon.PSIQUICO);
        tipoPokemon.put("Charizard", TiposPokemon.FUEGO);
        tipoPokemon.put("Charmander", TiposPokemon.FUEGO);
        tipoPokemon.put("Delphox", TiposPokemon.FUEGO);
        tipoPokemon.put("Eevee", TiposPokemon.AGUA);
        tipoPokemon.put("Gardevoir", TiposPokemon.PSIQUICO);
        tipoPokemon.put("Gengar", TiposPokemon.PSIQUICO);
        tipoPokemon.put("Greninja", TiposPokemon.AGUA);
        tipoPokemon.put("Gyarados", TiposPokemon.AGUA);
        tipoPokemon.put("Incineroar", TiposPokemon.FUEGO);
        tipoPokemon.put("Jigglypuff", TiposPokemon.PSIQUICO);
        tipoPokemon.put("Lucario", TiposPokemon.ELECTRICO);
        tipoPokemon.put("Lugia", TiposPokemon.AGUA);
        tipoPokemon.put("Magikarp", TiposPokemon.AGUA);
        tipoPokemon.put("Meowth", TiposPokemon.PSIQUICO);
        tipoPokemon.put("Mewtwo", TiposPokemon.PSIQUICO);
        tipoPokemon.put("Pikachu", TiposPokemon.ELECTRICO);
        tipoPokemon.put("Psyduck", TiposPokemon.PSIQUICO);
        tipoPokemon.put("Raichu", TiposPokemon.ELECTRICO);
        tipoPokemon.put("Rayquaza", TiposPokemon.ELECTRICO);
        tipoPokemon.put("Squirtle", TiposPokemon.AGUA);


        return tipoPokemon;
    }

    public HashMap<String, TiposPokemon> getCounters() {
        HashMap<String, TiposPokemon> counters = new HashMap<>();

        counters.put("Abra", TiposPokemon.FUEGO);
        counters.put("Alakazam", TiposPokemon.FUEGO);
        counters.put("Arcanine", TiposPokemon.AGUA);
        counters.put("Blastoise", TiposPokemon.ELECTRICO);
        counters.put("Bulbasaur", TiposPokemon.ELECTRICO);
        counters.put("Celebi", TiposPokemon.FUEGO);
        counters.put("Charizard", TiposPokemon.AGUA);
        counters.put("Charmander", TiposPokemon.AGUA);
        counters.put("Delphox", TiposPokemon.AGUA);
        counters.put("Eevee", TiposPokemon.ELECTRICO);
        counters.put("Gardevoir", TiposPokemon.FUEGO);
        counters.put("Gengar", TiposPokemon.FUEGO);
        counters.put("Greninja", TiposPokemon.ELECTRICO);
        counters.put("Gyarados", TiposPokemon.ELECTRICO);
        counters.put("Incineroar", TiposPokemon.AGUA);
        counters.put("Jigglypuff", TiposPokemon.FUEGO);
        counters.put("Lucario", TiposPokemon.PSIQUICO);
        counters.put("Lugia", TiposPokemon.ELECTRICO);
        counters.put("Magikarp", TiposPokemon.ELECTRICO);
        counters.put("Meowth", TiposPokemon.FUEGO);
        counters.put("Mewtwo", TiposPokemon.FUEGO);
        counters.put("Pikachu", TiposPokemon.PSIQUICO);
        counters.put("Psyduck", TiposPokemon.FUEGO);
        counters.put("Raichu", TiposPokemon.PSIQUICO);
        counters.put("Rayquaza", TiposPokemon.PSIQUICO);
        counters.put("Squirtle", TiposPokemon.ELECTRICO);

        return counters;
    }

    public ArrayList<String> getPokemones() {
        ArrayList<String> pokemones = new ArrayList<>();
        pokemones.add("Abra");
        pokemones.add("Alakazam");
        pokemones.add("Arcanine");
        pokemones.add("Blastoise");
        pokemones.add("Bulbasaur");
        pokemones.add("Celebi");
        pokemones.add("Charizard");
        pokemones.add("Charmander");
        pokemones.add("Delphox");
        pokemones.add("Eevee");
        pokemones.add("Gardevoir");
        pokemones.add("Gengar");
        pokemones.add("Greninja");
        pokemones.add("Gyarados");
        pokemones.add("Incineroar");
        pokemones.add("Jigglypuff");
        pokemones.add("Lucario");
        pokemones.add("Lugia");
        pokemones.add("Magikarp");
        pokemones.add("Meowth");
        pokemones.add("Mewtwo");
        pokemones.add("Pikachu");
        pokemones.add("Psyduck");
        pokemones.add("Raichu");
        pokemones.add("Rayquaza");
        pokemones.add("Squirtle");

        return pokemones;
    }

    @Override
    void felicidad() {
        System.out.println("El entrenador " + nombre_entrenador + " está feliz  por que su equipo ha ganado.");
    }

    @Override
    void tristeza() {
        System.out.println("El entrenador " + nombre_entrenador + " está triste por que su equipo ha perdido.");
    }


}