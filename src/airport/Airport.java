/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class Airport {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Integer> listaAsientos = new ArrayList<Integer>();
    static int personas;
    static int aviones;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        personas = in.nextInt();
        aviones = in.nextInt();
        //ArrayList<Integer> listaAsientos = new ArrayList<Integer>();
        int aux;
        int []array = new int [aviones];
        for (int i = 0; i < aviones; i++) {
            aux = in.nextInt();
            listaAsientos.add(i, aux);
            array[i] = aux;
        }
        //System.out.println(listaAsientos);
        //Collections.sort(listaAsientos);
        //System.out.println(listaAsientos);
        //listaAsientos = listaAux;
        mayor();
        
        //listaAsientos = listaAux;
        for (int i = 0; i < aviones; i++) {
            listaAsientos.set(i, array[i]);
        }
        
        menor();
    }

    private static void mayor() {
        int index, aux, contZlotys = 0;
        for (int i = 0; i < personas; i++) {
            index = getMax();
            aux = listaAsientos.get(index);
            if (listaAsientos.get(index) <= 0) {
                listaAsientos.set(index, Integer.MIN_VALUE);
                index = getMax();
                aux = listaAsientos.get(index);
            }
            contZlotys += aux;
            
            listaAsientos.set(index, aux - 1);
        }
        //System.out.println(listaAsientos);
        System.out.println(contZlotys);
    }

    private static void menor() {
        int index, aux, contZlotys = 0;
        for (int i = 0; i < personas; i++) {
            index = getMin();
            aux = listaAsientos.get(index);
            if (listaAsientos.get(index) <= 0) {
                listaAsientos.set(index, Integer.MAX_VALUE);
                index = getMin();
                aux = listaAsientos.get(index);
            }
            contZlotys += aux;
            
            listaAsientos.set(index, aux - 1);
        }
        //System.out.println(listaAsientos);
        System.out.println(contZlotys);
    }

    public static int getMax() {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < aviones; i++) {
            if (listaAsientos.get(i) > max) {
                max = listaAsientos.get(i);
                index = i;
            }
        }
        return index;
    }
    
    public static int getMin() {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < aviones; i++) {
            if (listaAsientos.get(i) < min) {
                min = listaAsientos.get(i);
                index = i;
            }
        }
        return index;
    }
    
}
