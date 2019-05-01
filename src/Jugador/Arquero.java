package Jugador;

import java.util.Random;

/**
 * Clase Arquero
 *
 * Representa a un arquero de futbol
 *
 *
 */

public class Arquero extends Jugador {

    // Atributos de la clase

    /**
     * @see #atajarPelota
     * Es un bonus, el cual si esta encendido multiplicará su defensa
     */
    private boolean atajarPelota;

    // Constructor de la clase

    /**
     * Constructor de la clase, Crea una instancia del mismo.
     * @param nombre nombre del jugador.
     * @param apellido apellido del jugador.
     * @param salario coste del jugador.
     * @param valorAtaque valor de ataque.
     * @param valorDefensa valor de defensa.
     */

    public Arquero(String nombre, String apellido, int salario, int valorAtaque, int valorDefensa) {
        super(nombre,apellido,salario,valorAtaque,valorDefensa);
    }

    // Cierre del Constructor

    // Metodos de la clase.

    /**
     * @see #Jugar()
     * El método jugar, genera valores aleatorios para los atributos de la subclase y simula que el jugador
     * juegue su partido y obtenga diferentes resultados por cada juego.
     */

    @Override
    public void Jugar()
    {
        Random random = new Random();
        atajarPelota = random.nextBoolean();
        super.valorAtaqueFinal = super.VALOR_ATAQUE;
        if (atajarPelota == true)
        {
            super.valorDefensaFinal = (super.VALOR_DEFENSA)*(1.7);
        }
        else{
            super.valorDefensaFinal = super.VALOR_DEFENSA;
        }
    }

    @Override
    public String toString() {
        return "Arquero: " + " " + super.toString();
    }
}
