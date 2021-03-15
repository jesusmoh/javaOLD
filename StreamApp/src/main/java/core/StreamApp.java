/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

/**
 *
 * @author JOrtiz
 */
public class StreamApp {

    private List<String> lista;
    private List<String> numeros;
    private List<String> resultado;

    public StreamApp() {
        lista = new ArrayList<>();
        lista.add("Mito");
        lista.add("Code");
        lista.add("Jaime");
        lista.add("MitoCode");

        numeros = new ArrayList<>();
        numeros.add("1");
        numeros.add("2");
        numeros.add("3");
        numeros.add("4");
        numeros.add("5");
        numeros.add("6");
        numeros.add("7");
        numeros.add("8");
    }

    public static void main(String[] args) {
        StreamApp app = new StreamApp();
        app.filtrar();
    }

    public void filtrar() {
        lista.stream().filter(x -> x.startsWith("M")).forEach(x -> System.out.println(x));
        resultado = lista.stream().filter(x -> x.startsWith("M")).collect(Collectors.toList());
        System.out.println(resultado.toString());
    }

    ;
    public void ordenar() {
        lista.stream().sorted((x, y) -> y.compareTo(x)).forEach(x -> System.out.println(x));
        resultado = lista.stream().sorted((x, y) -> y.compareTo(x)).collect(Collectors.toList());
        System.out.println(resultado.toString());
    }

    ;
    public void transformar() {
        lista.stream().map(x -> x.toUpperCase()).forEach(x -> System.out.println(x));
        numeros.stream().map(x -> Integer.parseInt(x) + 1).forEach(x -> System.out.println(x));
    }

    ;
    public void limitar() {
        lista.stream().limit(2).forEach(x -> System.out.println(x));
    }

    ;
    public void contar() {
        int count = (int) lista.stream().count();
    }

    ;
    public void agrupar() {
        /*
        List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9, 0);

// Simplest groupingBy
System.out.println("Simplest groupingBy");
Map< String, List< Integer > > oddEvenNumbers = list.stream()
        //grouped with EVEN or ODD
        .collect(groupingBy(n -> n % 2 == 0 ? "EVEN" : "ODD"));
System.out.println("Even Numbers are : " + oddEvenNumbers.get("EVEN"));
System.out.println("ODD Numbers are : " + oddEvenNumbers.get("ODD"));
         */

    }
;
}
