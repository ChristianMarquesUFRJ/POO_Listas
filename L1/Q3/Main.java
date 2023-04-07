import java.util.Scanner;

/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Lista 1 - Questão 3
 */

import java.util.Scanner;
import java.text.DecimalFormat; 

public class Main {
    static double PI = 3.14159;
    private static final DecimalFormat formatacao_decimal = new DecimalFormat("0.00000");  
    public static double obterRaioEsfera(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o Raio da Esfera [cm] para obter seu volume [cm³]: ");
        return sc.nextDouble();
    }
    public static double calcularVolumeEsfera(double raio){
        return (raio * raio * raio * PI * (4.0/3.0));
    }
    public static void main(String[] args){
        double raio = obterRaioEsfera();
        double volume = calcularVolumeEsfera(raio);
        System.out.println("Volume esfera[R(" + raio + "cm)] = " + formatacao_decimal.format(volume) + "cm³");
    }
}