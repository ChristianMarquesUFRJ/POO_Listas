import java.util.Scanner;

/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Lista 1 - Questão 5
 */

import java.util.Scanner;
import java.text.DecimalFormat; 

public class Main {
    static double CONSUMO_KML = 12.0;
    private static final DecimalFormat formatacao_decimal = new DecimalFormat("0.000");  
    public static int obterTempo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o tempo gasto na viagem [h]: ");
        return sc.nextInt();
    }
    public static double obterVelocidade(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira a velocidade média durante o trajeto [km/h]: ");
        return sc.nextDouble();
    }
    public static double calcularDistancia(int tempo, double velocidade){
        return (velocidade*tempo);
    }
    public static double calcularLitros(double distancia){
        return (CONSUMO_KML/distancia);
    }
    public static void main(String[] args){
        int tempo = obterTempo();
        double velocidade = obterVelocidade();
        double distancia = calcularDistancia(tempo, velocidade);
        double litros = calcularLitros(distancia);
        System.out.println(">> Serão percorridos " + formatacao_decimal.format(distancia) + "Km e " + formatacao_decimal.format(litros) + "L necessários");
    }
}