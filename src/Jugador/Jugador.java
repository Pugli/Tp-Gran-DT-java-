package Jugador;

/**
 * La clase Jugador, simula a un jugador de futbol.
 */

public abstract class Jugador {

    /**
     * @see #nombre Es el nombre del jugador
     * @see #Apellido Es el apellido del jugador
     * @see #salario Es el coste del jugador
     * @see #VALOR_ATAQUE Es la habilidad del jugador en ataque, sin ser modificada luego de jugar el partido.
     * @see #VALOR_DEFENSA Es la habilidad del jugador en defensa, sin ser modificada luego de jugar el partido.
     * @see #Jugar() este metodo es el que hace que los jugadores vean afectada su defensa y su ataque.
     * @see #valorAtaqueFinal Es la habilidad del jugador en ataque, luego que haya jugado su partido.
     * @see #valorDefensaFinal Es la habilidad del jugador en defensa, luego que haya jugado su partido.
     */

    protected String nombre;
    protected String Apellido;
    protected int salario;
    protected final int VALOR_ATAQUE;
    protected final int VALOR_DEFENSA;
    protected double valorAtaqueFinal;
    protected double valorDefensaFinal;

    /**
     * Constructor de la clase, Crea una instancia del mismo.
     * @param nombre nombre del jugador.
     * @param apellido apellido del jugador.
     * @param salario coste del jugador.
     * @param valorAtaque valor de ataque.
     * @param valorDefensa valor de defensa.
     */

    public Jugador(String nombre, String apellido, int salario, int valorAtaque, int valorDefensa) {
        this.nombre = nombre;
        Apellido = apellido;
        this.salario = salario;
        this.VALOR_ATAQUE = valorAtaque;
        this.VALOR_DEFENSA = valorDefensa;
    }

    public String getNombre() {
        return nombre;
    }


    public double getValorAtaqueFinal() {
        return valorAtaqueFinal;
    }

    public double getValorDefensaFinal() {
        return valorDefensaFinal;
    }

    public int getSalario() {
        return salario;
    }

    public abstract void Jugar();

    @Override
    public String toString() {
        return  "Nombre " + nombre +
                " " + Apellido  +
                ", Cotizacion: " + salario +
                '\n';
    }

    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (!(o instanceof Jugador)) return false;
        Jugador otro = (Jugador) o;
        return (this.nombre.compareTo(otro.nombre) == 0 && this.Apellido.compareTo(otro.Apellido) == 0);
    }

    @Override
    public int hashCode (){
        int resultado = nombre.hashCode();
        resultado = resultado * 31 + Apellido.hashCode();
        return resultado;
    }

}
