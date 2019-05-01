package Funcionamiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Funcionamiento.*;

public class Torneo {
    private ArrayList<Competidor> competidores;


    public Torneo(ArrayList<Competidor> competidores) {
        this.competidores = competidores;
    }

    public void ALaCancha() {
        Partido partido = new Partido();
        int contra;
        for (int i = 0; i < competidores.size(); i++) {
            contra = i + 1;
            while (contra < competidores.size()) {
                partido.juego(competidores.get(i), competidores.get(contra));
                contra = contra + 1;
            }
        }
        System.out.println("Torneo finalizado, todos los equipos han jugado contra todos!");
    }

    private void ordenarGanadores(ArrayList<Competidor> competidores) {


        Collections.sort(competidores, new Comparator<Competidor>() {
            @Override
            public int compare(Competidor c1, Competidor c2) {
                return c2.compareTo(c1);
            }
        });

    }

    public void mostrarTabla(ArrayList<Competidor> competidores) {
        ordenarGanadores(competidores);
        int i = 0;
        for (Competidor c : competidores) {
            System.out.println((i + 1) + " " + c.getNombre() + " Wins: " + c.miEquipoGanados() + " Loses " +
                    c.miEquipoPerdidos() + " Draws " + c.miEquipoEmpatados() + " GF " + c.miEquipoGoles());
            i++;
        }
    }
}
