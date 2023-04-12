/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Lista 1 - Questão 6
 */

import java.util.Scanner;
import java.util.Random; 

public class Main {
    public static void main(String[] args){
        Random rd = new Random(); 
        Scanner sc = new Scanner(System.in);
        char resposta;
        int maximo = 100;
        int numero = 0;
        int qtd_tentativas = 0;
        System.out.println("Olá! Vamos jogar um jogo!?");
        System.out.println("Você pensa no número e me diz se acertei...");
        System.out.println("Vamos lá!?");
        System.out.print(">> Digite a tecla 'enter' para continuar: ");
        sc.nextLine();
        do{
            numero = rd.nextInt(maximo);
            System.out.println("O número que você pensou foi " + numero + "?");
            System.out.print(">> Se acertei, digite 'S' ou 's'; do contrário, qualquer tecla: ");
            qtd_tentativas++;
            resposta = sc.nextLine().charAt(0);
        } while((resposta != 'S') && (resposta != 's'));
        System.out.println(">> Obrigado por jogar!");
        System.out.println(">> Só precisei de " + qtd_tentativas + " para acertar! :D");
    }
}