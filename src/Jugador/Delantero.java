package Jugador;


import java.util.Random;

/**
 * Esta clase simula a un delantero.
 */

public class Delantero extends Jugador {

    // Atributos de la clase

    /**
     * @see #meterGol
     * Es un bonus, el cual si esta encendido multiplicará su ataque
     */
    private boolean meterGol;

    //Constructor de la clase

    /**
     * Constructor de la clase, Crea una instancia del mismo.
     * @param nombre nombre del jugador.
     * @param apellido apellido del jugador.
     * @param salario coste del jugador.
     * @param valorAtaque valor de ataque.
     * @param valorDefensa valor de defensa.
     */

    public Delantero (String nombre, String apellido, int salario, int valorAtaque, int valorDefensa) {
        super(nombre,apellido,salario,valorAtaque,valorDefensa);
    }

    // Fin del constructor

    // Metodos de la clase

    /**
     * @see #Jugar()
     * El método jugar, genera valores aleatorios para los atributos de la subclase y simula que el jugador
     * juegue su partido y obtenga diferentes resultados por cada juego.
     */

    @Override
    public void Jugar()
    {
        Random random = new Random();
        meterGol = random.nextBoolean();
        if (meterGol == true){
            super.valorAtaqueFinal = super.VALOR_ATAQUE * 1.7;
        }
        else {
            super.valorAtaqueFinal = super.VALOR_ATAQUE;
        }

        super.valorDefensaFinal = super.VALOR_DEFENSA;

    }

    @Override
    public String toString() {
        return "Delantero: " + " " + super.toString();
    }
}
