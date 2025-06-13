package Clases;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Enums.TiposPokemon;

public class Pokemon implements Serializable {
    private String nombre;
    private ArrayList<Ataque> ataques;
    private TiposPokemon tipo;
    private short vida;
    private byte contadorataques = 0;
    private TiposPokemon counter;
    short defensa;
    short velocidad;
    short defensaEspecial;
    short ataque;
    private String Ataque_actual;
    public String getAtaque_actual() {
        return Ataque_actual;
    }

    
    public Pokemon(String nombre, TiposPokemon tipo, short vida, TiposPokemon counter, short defensa, short velocidad, short defensaEspecial, short ataque) {
        this.nombre = nombre;
        this.ataques = new ArrayList<Ataque>();
        this.tipo = tipo;
        this.vida = vida;
        this.counter = counter;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.defensaEspecial = defensaEspecial;
        this.ataque = ataque;
    }
    
    public short getAtaque() {
        return ataque;
    }

    public void setAtaque(short ataque) {
        this.ataque = ataque;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public TiposPokemon getTipo() {
        return tipo;
    }
    public void setTipo(TiposPokemon tipo) {
        this.tipo = tipo;
    }
    public short getVida() {
        return vida;
    }
    public void setVida(short vida) {
        this.vida = vida;
    }
    public TiposPokemon getCounter() {
        return counter;
    }
    public void setCounter(TiposPokemon counter) {
        this.counter = counter;
    }
    public void addAtaque(Ataque ataque) {
        if (ataques == null || contadorataques < 4) {
            ataques.add(ataque);
            contadorataques++;
        } else {
            System.out.println("No se pueden agregar más ataques.");
        }
    }
    public void setAtaques(ArrayList<Ataque> ataques) {
        this.ataques = ataques;
    }

    public byte getContadorataques() {
        return contadorataques;
    }

    public void setContadorataques(byte contadorataques) {
        this.contadorataques = contadorataques;
    }

    public short getDefensa() {
        return defensa;
    }

    public void setDefensa(short defensa) {
        this.defensa = defensa;
    }

    public short getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(short velocidad) {
        this.velocidad = velocidad;
    }

    public short getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setDefensaEspecial(short defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }

    public void mostrarAtaques() {
        for (Ataque ataque : ataques) {
            System.out.println(  ". " + "Nombre: " + ataque.getNombreAtaque() + ", Potencia: " + ataque.getPotencia() + ", Tipo: " + ataque.getTipoAtaque() + ", Tipo de Daño: " + ataque.getTipoDano());
        }
    }
    public String toString() {
        return nombre;
    }

    public void atacar(Pokemon pokemon2, int indiceAtaque) {
        /** Se toma el pokemon 2 y su indice de ataque con el getActionCommand, toma el ataque
         * de la lista de ataques y se le asigna el daño generado con la formula. */
        Ataque ataquePokemon1 = ataques.get(indiceAtaque);
        int daño = (2/5*30+2)*(this.getAtaque()/pokemon2.getDefensa())*(ataquePokemon1.getPotencia()/50) + 2;
        if (ataquePokemon1.getTipoAtaque() == pokemon2.getCounter()) {
            /** Se multiplica el daño por 1.5 si el tipo del ataque del Pokemon 1 es igual al counter
             * del Pokemon 2. */
            daño = (int) (daño * 1.5);
        } else if (ataquePokemon1.getTipoAtaque() == pokemon2.getTipo()) {
            /** Se multiplica el daño por 0.5 si el tipo del ataque del Pokemon 1 es igual al tipo
             * del Pokemon 2. */
            daño = (int) (daño * 0.5);
        }
        /** Se convierte ese daño en un String para que al atacar, se muestre el mensaje de cuanto
         * daño le hizo al otro Pokemon, y el Pokemon 2 recibe el daño. */
        Ataque_actual = String.valueOf(daño);
        pokemon2.recibirDaño(daño);
    }
    
    public void recibirDaño(int daño) {
        /**Se le resta el daño a la vida del Pokemon y se le asigna la vida restante. */
        short vidaRestante = (short) (vida - daño);
        this.vida = vidaRestante;
    }

    public String getAtaqueactual() {
        return Ataque_actual;
    }
}