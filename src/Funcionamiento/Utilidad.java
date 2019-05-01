package Funcionamiento;

import Jugador.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Utilidad {

    public static void escribirArrayEnArchivo(String pathname, List array) {
        File path = new File(".\\src\\Archivos\\" + pathname);
        if (path.exists()) {

            try {

                Gson gson = new Gson();
                String arrayEnString = gson.toJson(array, List.class);
                System.out.println(arrayEnString);
                BufferedWriter bufferwriter = new BufferedWriter(new FileWriter(path));
                gson.toJson(array,bufferwriter);
                bufferwriter.close();
            } catch (IOException e) {
                System.out.println("Error al escribir el archivo");
            }
        }
        else
        {
            System.out.println("La ruta especificada no existe.");
        }
    }

    public static List<Arquero> leerArchivoArqueros(){
        File path = new File (".\\src\\Archivos\\Arqueros.json");
        List<Arquero> array = new ArrayList<>();
        if (path.exists()){
            try{
                Gson gson = new Gson();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
                array = gson.fromJson(bufferedReader,new TypeToken<List<Arquero>>(){}.getType());
                bufferedReader.close();
            }catch (IOException e){
                System.out.println("Error al leer el archivo");
            }
        }
        else{
            System.out.println("La ruta especificada no existe");
        }
        return array;

    }

    public static List<Defensor> leerArchivoDefensores(){
        File path = new File (".\\src\\Archivos\\Defensores.json");
        List<Defensor> array = new ArrayList<>();
        if (path.exists()){
            try{
                Gson gson = new Gson();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
                array = gson.fromJson(bufferedReader,new TypeToken<List<Defensor>>(){}.getType());
                bufferedReader.close();
            }catch (IOException e){
                System.out.println("Error al leer el archivo");
            }
        }
        else{
            System.out.println("La ruta especificada no existe");
        }
        return array;

    }

    public static List<Volante> leerArchivoVolantes(){
        File path = new File (".\\src\\Archivos\\volantes.json");
        List<Volante> array = new ArrayList<>();
        if (path.exists()){
            try{
                Gson gson = new Gson();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
                array = gson.fromJson(bufferedReader,new TypeToken<List<Volante>>(){}.getType());
                bufferedReader.close();
            }catch (IOException e){
                System.out.println("Error al leer el archivo");
            }
        }
        else{
            System.out.println("La ruta especificada no existe");
        }
        return array;

    }

    public static List<Delantero> leerArchivoDelanteros(){
        File path = new File (".\\src\\Archivos\\Delanteros.json");
        List<Delantero> array = new ArrayList<>();
        if (path.exists()){
            try{
                Gson gson = new Gson();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
                array = gson.fromJson(bufferedReader,new TypeToken<List<Delantero>>(){}.getType());
                bufferedReader.close();
            }catch (IOException e){
                System.out.println("Error al leer el archivo");
            }
        }
        else{
            System.out.println("La ruta especificada no existe");
        }
        return array;

    }

    public static boolean Validar(Set<Jugador> hashset) {
        boolean indicador = true;
        int sumaARQ = 0;
        int sumaDEF = 0;
        int sumaVOL = 0;
        int sumaDEL = 0;
        int sumaSalario = 0;
        for (Jugador j : hashset) {
            if (j != null) {
                if (j instanceof Arquero) {
                    sumaARQ = sumaARQ + 1;
                } else if (j instanceof Defensor) {
                    sumaDEF = sumaDEF + 1;
                } else if (j instanceof Volante) {
                    sumaVOL = sumaVOL + 1;
                } else if (j instanceof Delantero) {
                    sumaDEL = sumaDEL + 1;
                }
                sumaSalario = sumaSalario + j.getSalario();
            }else{
                System.out.println("Error en la verificacion del archivo");
            }

        }
        if (sumaARQ != 1) {
            indicador = false;
            System.out.println("Cantidad de arqueros erronea");
        }
        if (sumaDEF < 3 || sumaDEF > 5) {
            indicador = false;
            System.out.println("Cantidad de defensores erronea");
        }
        if (sumaVOL < 3 || sumaVOL > 5) {
            indicador = false;
            System.out.println("Cantidad de volantes erronea");
        }
        if (sumaDEL < 1 || sumaDEL > 3) {
            indicador = false;
            System.out.println("Cantidad de delanteros erronea");
        }

        if (sumaSalario > 60000){
            indicador = false;
            System.out.println("Usted se exedio del presupuesto permitido para la compra de jugadores ($60000)");
        }

        if (hashset.size() != 11){
            indicador = false;
            System.out.println("Usted no completo su equipo con once jugadores");
        }

        return indicador;
    }

    public static List<Jugador> jsonToArray (){

        List<Defensor> defensores;
        List<Arquero> arqueros;
        List<Volante> volantes;
        List<Delantero> delanteros;
        List<Jugador> jugadores = new ArrayList<>();

        arqueros = leerArchivoArqueros();
        defensores =leerArchivoDefensores();
        volantes = leerArchivoVolantes();
        delanteros = leerArchivoDelanteros();

        jugadores.addAll(arqueros);
        jugadores.addAll(defensores);
        jugadores.addAll(volantes);
        jugadores.addAll(delanteros);

        return jugadores;
    }
}
