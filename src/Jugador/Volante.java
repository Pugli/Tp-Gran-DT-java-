package Jugador;


import java.util.Random;

/**
 * Esta clase simula a un volante.
 */

public class Volante extends Jugador {

    //Atributos de la clase.

    /**
     *@see #marcaje
     * Este metodo es un bonus, el cual si esta encendido multiplicará su defensa.
     *@see #tirarCentro
     * Este metodo es un bonus, el cual si esta encendido multiplicará su ataque.
     */

    private boolean tirarCentro;
    private boolean marcaje;

    //Constructor de la clase.

    /**
     * Constructor de la clase, Crea una instancia del mismo.
     * @param nombre nombre del jugador.
     * @param apellido apellido del jugador.
     * @param salario coste del jugador.
     * @param valorAtaque valor de ataque.
     * @param valorDefensa valor de defensa.
     */

    public Volante (String nombre, String apellido, int salario, int valorAtaque, int valorDefensa) {
        super(nombre,apellido,salario,valorAtaque,valorDefensa);
    }

    //Fin del constructor de la clase.

    //Metodos de la clase.

    /**
     * @see #Jugar()
     * El método jugar, genera valores aleatorios para los atributos de la subclase y simula que el jugador
     * juegue su partido y obtenga diferentes resultados por cada juego.
     */

    @Override
    public void Jugar()
    {
        Random random = new Random();
        tirarCentro = random.nextBoolean();
        marcaje = random.nextBoolean();

        if (marcaje == true)
        {
            super.valorDefensaFinal = super.VALOR_DEFENSA * 1.3;
        }
        else {
            super.valorDefensaFinal = super.VALOR_DEFENSA;
        }

        if (tirarCentro == true){
            super.valorAtaqueFinal = super.VALOR_ATAQUE * 1.5;
        }
        else {
            super.valorAtaqueFinal = super.VALOR_ATAQUE;
        }
    }

    @Override
    public String toString() {
        return "Volante: " + " " + super.toString();
    }
}
