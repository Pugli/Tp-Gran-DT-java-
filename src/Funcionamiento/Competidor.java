package Funcionamiento;

import Jugador.*;
import Menu.Lectura;

import java.util.*;

/**
 * Esta clase crea un competidor, con su respectivo equipo y nombre.
 */

public class Competidor implements Lectura, Comparable {

    //Atributos de la clase

    /**
     * @see #nombre es el nombre del competidor
     * @see Equipo miEquipo es el equipo que elije el competidor, con todos sus respectivos datos.
     */
    private String nombre;
    private Equipo miEquipo;
    private int presupuesto;

    //Constructor de la clase

    /**
     * @param jugadoresDelArchivo es un arraylist de jugadores, en el cual se encuentran todos los jugadores ubicados en la
     *                            base de datos previamente descargada.
     */

    public Competidor(List<Jugador> jugadoresDelArchivo) {
        System.out.println("Escriba su nombre");
        while (!scan.hasNext()) {
            System.out.println("nombre invalido");
            scan.next();
        }
        nombre = scan.next();
        this.presupuesto = 60000;
        CrearEquipo(jugadoresDelArchivo);
    }

    /**
     * Crea el equipo a gusto del competidor, el mismo se encarga de verificar que la composicion del mismo sea valida.
     *
     * @param jugadoresDelArchivo Es un arraylist con todos los jugadores disponibles en la base de datos.
     */

    public void CrearEquipo(List<Jugador> jugadoresDelArchivo) {
        int opcion = 0;

        List<Jugador> jugadores = jugadoresDelArchivo;
        Set<Jugador> elegidos = new HashSet<>();


        do {
            int dineroGastado = 0;
            elegidos.clear();
            System.out.println("Lista de jugadores");

            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println(i + jugadores.get(i).toString());
            }

            System.out.println("Elija sus once jugadores, recuerde las restricciones!");

            for (int i = 0; i < 11; i++) {
                System.out.println("Elija jugador: ");
                try {
                    opcion = scan.nextInt();
                } catch (InputMismatchException e) {
                    e.getMessage();
                } finally {
                    if (opcion >= 0 && opcion < jugadores.size()) {
                        if (elegidos.add(jugadores.get(opcion)) == true) {
                            dineroGastado = dineroGastado + jugadores.get(opcion).getSalario();
                            System.out.println("Usted elijio su " + (i + 1) + " jugador y lleva gastado : " + dineroGastado);
                        }else{
                            System.out.println("Usted elijio un jugador que ya esta en su equipo, por favor elija otro:");
                            i--;
                        }
                    } else {
                        i--;
                        System.out.println("Ingrese un numero de jugador valido");
                    }
                }
            }

        } while (Utilidad.Validar(elegidos) == false);

        miEquipo = new Equipo(elegidos);
        miEquipo.getEquipo();


    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Se encarga de asignarle al equipo un partido ganado y le suma los goles metidos y recibidos.
     * @param golesMetidos Goles metidos en el ultimo partido jugado, se suman a las estadisticas previas del equipo
     * @param golesRecidos Goles recibidos en el ultimo partido jugado, se suman a las estadisticas previas del equipo
     */

    public void partidoGanado(int golesMetidos, int golesRecidos) {
        miEquipo.sumar(golesMetidos, golesRecidos);
    }

    /**
     * Se encarga de asignarle al equipo un partido perdido y le suma los goles metidos y recibidos.
     * @param golesMetidos Goles metidos en el ultimo partido jugado, se suman a las estadisticas previas del equipo
     * @param golesRecidos Goles recibidos en el ultimo partido jugado, se suman a las estadisticas previas del equipo
     */

    public void partidoPerdido(int golesMetidos, int golesRecidos) {
        miEquipo.restar(golesMetidos, golesRecidos);
    }

    /**
     * Se encarga de asignarle al equipo un partido empatado y le suma los goles metidos y recibidos.
     * @param golesMetidos Goles metidos en el ultimo partido jugado, se suman a las estadisticas previas del equipo
     * @param golesRecidos Goles recibidos en el ultimo partido jugado, se suman a las estadisticas previas del equipo
     */

    public void partidoEmpatado(int golesMetidos, int golesRecidos) {
        miEquipo.igualar(golesMetidos, golesRecidos);
    }

    /**
     * @return retorna el numero de partidos ganados del equipo asociado al competidor
     */

    public int miEquipoGanados() {
        return miEquipo.getPartidosGanados();
    }

    /**
     * @return retorna el numero de empatados ganados del equipo asociado al competidor
     */

    public int miEquipoEmpatados() {
        return miEquipo.getPartidosEmpatados();
    }

    /**
     * @return retorna el numero de partidos perdidos del equipo asociado al competidor
     */

    public int miEquipoPerdidos() {
        return miEquipo.getPartidosPerdidos();
    }

    /**
     * @return retorna el numero de goles metidos del equipo asociado al competidor
     */

    public int miEquipoGoles() {
        return miEquipo.getGolesMetidos();
    }

    /**
     * @see Jugador#Jugar()
     * Aplica el metodo jugar a cada jugador del arraylist alojado en el equipo asociado al competidor
     */

    public void hacerJugarEquipo() {
        miEquipo.jugarEquipo();
    }

    /**
     * @return retorna el ataque total del equipo en su ultimo partido disputado
     */

    public int calcularAtaque() {
        return miEquipo.getAtaqueUltimoPartido();
    }

    /**
     * @return retorna la defensa total del equipo en su ultimo partido disputado
     */

    public int calcularDefensa() {
        return miEquipo.getDefensaUltimoPartido();
    }


    @Override
    public int compareTo(Object o) {
        Competidor c = (Competidor) o;
        if (c.miEquipoGanados() < this.miEquipoGanados())
            return 1;
        else if (c.miEquipoGanados() > this.miEquipoGanados())
            return -1;
        else {
            if (c.miEquipoEmpatados() < this.miEquipoEmpatados())
                return 1;
            else if (c.miEquipoEmpatados() > this.miEquipoEmpatados())
                return -1;
            else {
                if (c.miEquipoGoles() < this.miEquipoGoles())
                    return 1;
                else
                    return -1;
            }
        }
    }
}
