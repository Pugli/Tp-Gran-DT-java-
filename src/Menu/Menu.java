package Menu;


import Funcionamiento.Competidor;
import Funcionamiento.Partido;
import Funcionamiento.Torneo;
import Jugador.Jugador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Lectura {
    private Partido variable;
    private List<Competidor> competidores = new ArrayList<Competidor>(10);
    private List<Jugador> jugadoresDelArchivo;

    public Menu(List<Jugador> jugadoresDelArchivo) {
        this.jugadoresDelArchivo = jugadoresDelArchivo;
    }


    public void imprimirMenu() {
        int value = 1;


        while (value != 0) {

            System.out.println("== Menu de Bienvenida ==");
            System.out.println("1. Jugar");
            System.out.println("2. Crear competidor");
            System.out.println("0. Salir");
            System.out.print("Ingrese opcion: ");
            while (!scan.hasNextInt()) {
                System.out.println("Ingrese opcion: ");
                scan.next();
            }
            value = scan.nextInt();
            switch (value) {
                case 1:
                    if (competidores.size() >= 2) {
                        Torneo t = new Torneo((ArrayList) competidores);
                        t.ALaCancha();
                        t.mostrarTabla((ArrayList) competidores);
                    } else {
                        System.out.println("Cantidad de competidores insuficiente");
                    }
                    break;
                case 2:
                    int i = 1;
                    while (i == 1) {
                        Competidor variable = new Competidor(jugadoresDelArchivo);
                        competidores.add(variable);
                        System.out.println("¿Continuar con otro competidor?");
                        System.out.println("si - 1");
                        System.out.println("no - cualquier numero");
                        i = scan.nextInt();
                    }
                    break;

                default:
                    System.out.println("opcion incorrecta");
                    break;
            }
            try {
                System.out.println("Ingrese una teclap para continuar");
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("PROGRAMA TERMINADO");
    }

}