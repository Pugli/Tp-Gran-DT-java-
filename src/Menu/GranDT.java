package Menu;

import Funcionamiento.Utilidad;
import Jugador.*;
import java.util.List;

public class GranDT {

    public static void main(String[] args) {
        List<Jugador> jugadoresDelArchivo = Utilidad.jsonToArray();
        Menu menu = new Menu(jugadoresDelArchivo);
        menu.imprimirMenu();
    }
}
