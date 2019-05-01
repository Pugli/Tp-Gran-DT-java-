package Funcionamiento;
import Jugador.*;

import java.util.List;
import java.util.Set;

public class Equipo {
   private Set<Jugador> jugadores;
   private int partidosGanados;
   private int partidosPerdidos;
   private int partidosEmpatados;
   private int golesRecibidos;
   private int golesMetidos;
   private int ataqueUltimoPartido;
   private int defensaUltimoPartido;

    public Equipo (Set<Jugador> jugadores)
    {
        this.jugadores = jugadores;
    }

    public void getEquipo(){
        for (Jugador j : jugadores){
            System.out.println(j.toString());
        }
    }
    public void sumar (int golesMetidos,int golesRecibidos)
    {
        partidosGanados = partidosGanados + 1;
        this.golesMetidos= this.golesMetidos + golesMetidos;
        this.golesRecibidos = this.golesRecibidos + golesRecibidos;
    }
    public void restar (int golesMetidos,int golesRecibidos)
    {
        partidosPerdidos = partidosPerdidos + 1;
        this.golesMetidos= this.golesMetidos + golesMetidos;
        this.golesRecibidos = this.golesRecibidos + golesRecibidos;
    }
    public void igualar (int golesMetidos,int golesRecibidos)
    {
        partidosEmpatados = partidosEmpatados + 1;
        this.golesMetidos= this.golesMetidos + golesMetidos;
        this.golesRecibidos = this.golesRecibidos + golesRecibidos;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getGolesMetidos() {
        return golesMetidos;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void jugarEquipo(){
        ataqueUltimoPartido = 0;
        defensaUltimoPartido = 0;

        for (Jugador j : jugadores){
            j.Jugar();
            ataqueUltimoPartido += j.getValorAtaqueFinal();
            defensaUltimoPartido += j.getValorDefensaFinal();
        }
    }

    public int getAtaqueUltimoPartido() {
        return ataqueUltimoPartido;
    }

    public int getDefensaUltimoPartido() {
        return defensaUltimoPartido;
    }
}
