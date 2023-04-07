/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Lista 1 - Questão 2
 */

import java.util.Scanner;

class Main{
    static int [] quantidade_carnes = new int[3];
    static int [] quantidade_pedidos = new int[3];
    public enum Carnes{
        FRANGO, BIFE, MASSA;
    }
    public static void obterQuantidadeCarne(Carnes carne){
        Scanner sc = new Scanner(System.in);
        if (carne == Carnes.FRANGO){
            System.out.print("Insira a quantidade de Frango: ");
            quantidade_carnes[0] = sc.nextInt();
        }
        else if (carne == Carnes.BIFE){
            System.out.print("Insira a quantidade de Bife: ");
            quantidade_carnes[1] = sc.nextInt();
        }
        else{
            System.out.print("Insira a quantidade de Massa: ");
            quantidade_carnes[2] = sc.nextInt();
        }
    }
    public static void obterNumeroPedidosCarne(Carnes carne){
        Scanner sc = new Scanner(System.in);
        if (carne == Carnes.FRANGO){
            System.out.print("Insira a quantidade de pedidos de Frango: ");
            quantidade_pedidos[0] = sc.nextInt();
        }
        else if (carne == Carnes.BIFE){
            System.out.print("Insira a quantidade de pedidos de Bife: ");
            quantidade_pedidos[1] = sc.nextInt();
        }
        else{
            System.out.print("Insira a quantidade de pedidos de Massa: ");
            quantidade_pedidos[2] = sc.nextInt();
        }
    }
    public static int calcularPassageirosNaoAtendidos(){
        int total = 0;
        for (int i = 0; i < quantidade_pedidos.length; i++)
            if (quantidade_pedidos[i] > quantidade_carnes[i])
                total += quantidade_pedidos[i] - quantidade_carnes[i];
        return total;
    }
    public static void main(String[] args) {
        System.out.println("Insira, abaixo, primeiro a quantidade de refeições de cada carne e suas respectivas quantidades de pedidos:");
        obterQuantidadeCarne(Carnes.FRANGO);
        obterQuantidadeCarne(Carnes.BIFE);
        obterQuantidadeCarne(Carnes.MASSA);
        obterNumeroPedidosCarne(Carnes.FRANGO);
        obterNumeroPedidosCarne(Carnes.BIFE);
        obterNumeroPedidosCarne(Carnes.MASSA);
        int total_nao_atendidos = calcularPassageirosNaoAtendidos();
        System.out.println("Assim, existem " + total_nao_atendidos + " clientes que não poderão ser atendidos");
    }
}