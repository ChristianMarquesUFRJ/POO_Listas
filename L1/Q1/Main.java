/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Lista 1 - Questão 1
 */


import java.util.Scanner;

class Main{
    public static double calcularMediaTurma(){
        Scanner sc = new Scanner(System.in);
        double nota = 0.0;
        double media = 0.0;
        int numero_alunos = 0;
        for (; ; numero_alunos++){
            System.out.print("Insira a Média do aluno " + (numero_alunos+1) + ": ");
            nota = sc.nextDouble();
            // Se a nota for a condicao de saida, sai da coleta
            if (nota == -1.0) break;
            // Do contrario, continua incluindo a nota recebida no somatorio
            media += nota;
        }
        // Se a pessoa parou antes de inserir uma nota, retorna o aviso (-1.0)
        if (numero_alunos == 0)
            return -1.0;
        return media/numero_alunos;
    }
    public static void main(String[] args) {
        System.out.println("Insira a média de todos os alunos abaixo (encerrando com '-1'):");
        double media = calcularMediaTurma();
        if (media >= 0.0)
            System.out.println("A média final da turma é " + media);
        else
            System.out.println("Não é possível fazer a média da turma sem nota dos alunos!");
    }
}