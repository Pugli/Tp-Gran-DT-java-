package Funcionamiento;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Partido {
    private int ataqueA;
    private int ataqueB;
    private int defensaA;
    private int defensaB;
    private Competidor A;
    private Competidor B;
    private int golesA;
    private int golesB;

    public Partido ()
    {

    }

    public void juego (Competidor a,Competidor b)
    {
        restablecer();
        A = a;
        B = b;
        A.hacerJugarEquipo();
        B.hacerJugarEquipo();
        ataqueA=A.calcularAtaque();
        ataqueB=B.calcularAtaque();
        defensaA=A.calcularDefensa();
        defensaB=B.calcularDefensa();
        System.out.println("El competidor "+a.getNombre()+" Metio "+getGolesA()+" Goles ");
        System.out.println("El competidor "+b.getNombre()+" Metio "+getGolesB()+" Goles ");
        if(getGolesA()>getGolesB())
        {
            System.out.println("El ganador es: "+a.getNombre());
            a.partidoGanado(getGolesA(),getGolesB());
            b.partidoPerdido(getGolesB(),getGolesA());
        }else if (getGolesA()<getGolesB())
        {
            System.out.println("El ganador es: "+b.getNombre());
            b.partidoGanado(getGolesB(),getGolesA());
            a.partidoPerdido(getGolesA(),getGolesB());
        }else
        {
            System.out.println("El partido termina en empate");
            a.partidoEmpatado(getGolesA(),getGolesB());
            b.partidoEmpatado(getGolesB(),getGolesA());
        }
    }

    private void restablecer ()
    {
        golesA = 0;
        golesB = 0;
        ataqueA = 0;
        ataqueB = 0;
        defensaA = 0;
        defensaB= 0;
    }

    public int getGolesA() {
        this.golesA = ataqueA - defensaB;
        if (this.golesA <= 0)
            this.golesA = 0;
        else{
            this.golesA = (this.golesA) / 10;
        }
        return golesA;
    }

    public int getGolesB() {
        this.golesB = ataqueB - defensaA;
        if (this.golesB <= 0)
            this.golesB = 0;
        else{
            this.golesB = (this.golesB) / 10;
        }
        return golesB;
    }


}

