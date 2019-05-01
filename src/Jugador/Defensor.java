package Jugador;


import java.util.Random;

/**
 * Clase Defensor
 *
 * Representa a un arquero de futbol
 *
 *
 */

public class Defensor extends Jugador {

    //Atributos de la clase.

    /**
     *@see #quitarPelota
     * Este metodo es un bonus, el cual si esta encendido multiplicará su defensa.
     *@see #Cabezaso
     * Este metodo es un bonus, el cual si esta encendido multiplicará su ataque.
     */
    private boolean quitarPelota;
    private boolean Cabezaso;

    //Constructor de la clase.

    /**
     * Constructor de la clase, Crea una instancia del mismo.
     * @param nombre nombre del jugador.
     * @param apellido apellido del jugador.
     * @param salario coste del jugador.
     * @param valorAtaque valor de ataque.
     * @param valorDefensa valor de defensa.
     */

    public Defensor(String nombre, String apellido, int salario, int valorAtaque, int valorDefensa) {
        super(nombre,apellido,salario,valorAtaque,valorDefensa);
    }

    //Fin del constructor

    //Metodos de la case

    /**
     * @see #Jugar()
     * El método jugar, genera valores aleatorios para los atributos de la subclase y simula que el jugador
     * juegue su partido y obtenga diferentes resultados por cada juego.
     */

    @Override
    public void Jugar()
    {
        Random random = new Random();
        quitarPelota = random.nextBoolean();
        Cabezaso = random.nextBoolean();
        if (quitarPelota == true)
        {
            super.valorDefensaFinal = super.VALOR_DEFENSA * 1.5;
        }
        else {
            super.valorDefensaFinal = super.VALOR_DEFENSA;
        }

        if (Cabezaso == true){
            super.valorAtaqueFinal = super.VALOR_ATAQUE * 1.3;
        }
        else {
            super.valorAtaqueFinal = super.VALOR_ATAQUE;
        }


    }

    @Override
    public String toString() {
        return "Defensor: " + " " + super.toString();
    }


}
