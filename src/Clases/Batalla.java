package Clases;

public class Batalla {
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon PokemonSobreviviente;
    private byte turno;
    private byte contadorAtaque1;
    private byte contadorAtaque2;
    private Boolean Pokemonderrotado;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2, Pokemon pokemon1, Pokemon pokemon2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public void turno() {
        /** Se determina el turno dependiendo de qué Pokemon tenga mayor velocidad. */
        if (pokemon1.getVelocidad() >= pokemon2.getVelocidad()) {
            this.turno = (byte)(1); // Pokemon 1 ataca primero
        } else {
            this.turno = (byte)(2); // Pokemon 2 ataca primero
        }
    }

    public void atacar(int indiceAtaque) {
        /** Se determina el turno del jugador y se realiza el ataque al Pokemon del otro jugador,
         * se le suma 1 al contador del ataque para ir desbloqueando el ataque especial y se cambia
         * el turno al otro jugador. */
        if (turno == 1) {
            pokemon1.atacar(pokemon2, indiceAtaque);
            contadorAtaque1++;
            this.turno = 2; // Cambia el turno al Pokemon 2
            /** Si la vida del Pokemon 2 es menor o igual a cero, es derrotado y se elimina de la lista
             * de los pokemones del entrenador 2 */
            if (pokemon2.getVida() <= 0) {
                this.Pokemonderrotado = true;
                entrenador2.EliminarPokemon(pokemon2);
                PokemonSobreviviente = pokemon1;
            }
            else {
                this.Pokemonderrotado = false;
            }
        } else {
            /** Se realiza lo mismo que en el caso anterior pero para el otro Pokemon. */
            pokemon2.atacar(pokemon1, indiceAtaque);
            contadorAtaque2++;
            this.turno = 1; // Cambia el turno al Pokemon 1
            if (pokemon1.getVida() <= 0) {
                this.Pokemonderrotado = true;
                entrenador1.EliminarPokemon(pokemon1);
                PokemonSobreviviente = pokemon2;
            }
            else {
                this.Pokemonderrotado = false;
            }
        }
    }

    public void setTurno(byte turno) {
        this.turno = turno;
    }
    public byte getTurno() {
        return turno;
    }

    public Entrenador getEntrenador1() {
        return entrenador1;
    }

    public Entrenador getEntrenador2() {
        return entrenador2;
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public byte getContadorAtaque1() {
        return contadorAtaque1;
    }

    public byte getContadorAtaque2() {
        return contadorAtaque2;
    }

    public Boolean getPokemonderrotado() {
        return Pokemonderrotado;
    }


}