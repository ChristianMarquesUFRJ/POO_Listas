import java.util.Scanner;

/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Lista 1 - Questão 4
 */

import java.util.Scanner;

public class Main { 
    public enum Operacao{
        SOMA, SUBTRACAO, MULTIPLICACAO, DIVISAO, SAIR, INVALIDO;
        public static String converterCodigoTexto(Operacao op){
            if (op == Operacao.SOMA)
            return "+";
            if (op == Operacao.SUBTRACAO)
                return "-";
            if (op == Operacao.MULTIPLICACAO)
                return "*";
            if (op == Operacao.DIVISAO)
                return "/";
            if (op == Operacao.SAIR)
                return "s";
            return "";
        }
        public static Operacao converterTextoCodigo(char entrada){
            if (entrada == '+')
                return Operacao.SOMA;
            if (entrada == '-')
                return Operacao.SUBTRACAO;
            if (entrada == '*')
                return Operacao.MULTIPLICACAO;
            if (entrada == '/')
                return Operacao.DIVISAO;
            if ((entrada == 's') || (entrada == 'S'))
                return Operacao.SAIR;
            return Operacao.INVALIDO;
        }
    }

    public static void mostrarMenu(){
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("MENU INTERATIVO DE OPERAÇÕES");
        System.out.println("-----------------------------");
        System.out.println("> Escolha uma das operações abaixo para realizar a conta:");
        System.out.println("-----------------------------");
        System.out.println("'+' Realizará a Soma de 2 numeros");
        System.out.println("'-' Realizará a Subtração de 2 numeros");
        System.out.println("'*' Realizará a Multiplicação de 2 numeros");
        System.out.println("'/' Realizará a Divisão de 2 numeros");
        System.out.println("'S/s' Fecha a calculadora");
        System.out.println("-----------------------------");
        System.out.print(">> Digite qual das opções acima deseja[+,-,*,/,S]: ");
    }
    public static Double obterNumero(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o " + msg + " da Operação escolhida anteriormente: ");
        return sc.nextDouble();
    }
    public static Operacao obterOperacao(){
        Scanner sc = new Scanner(System.in);
        mostrarMenu();
        char entrada = sc.nextLine().charAt(0);
        return Operacao.converterTextoCodigo(entrada);
    }
    public static double calcularExpressao(Operacao operacao, double n1, double n2){
        if (operacao == Operacao.SOMA)
            return (n1 + n2);
        if (operacao == Operacao.SUBTRACAO)
            return (n1 - n2);
        if (operacao == Operacao.MULTIPLICACAO)
            return (n1 * n2);
        return (n1 / n2);
    }
    public static void main(String[] args){
        Operacao operacao;
        do{
            operacao = obterOperacao();
            if (operacao == Operacao.SAIR){
                break;
            }
            if ((operacao != Operacao.SAIR) && (operacao != Operacao.INVALIDO)){
                double numero_1 = obterNumero("Primeiro número");
                double numero_2 = obterNumero("Segundo número");
                double resultado = calcularExpressao(operacao, numero_1, numero_2);
                System.out.println("> Resposta: " + numero_1 + " " + Operacao.converterCodigoTexto(operacao) + " " + numero_2 + " = " + resultado);
            }
            else if (operacao == Operacao.INVALIDO)
                System.out.println(">> A opção inserida não existe!");
        } while(operacao != Operacao.SAIR);
    }
}
