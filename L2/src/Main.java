/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Lista 2
 */

public class Main {
    
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario("Christian");
        Funcionario funcionario2 = new Funcionario("Oziara", 25.00);
        System.out.println("\n");
        System.out.println(">> Funcionarios Cadastrados:");
        System.out.println(funcionario1.info());
        System.out.println(funcionario2.info());
        System.out.println(">> Total de funcionarios cadastrados: " + Funcionario.getProximoID());

        System.out.println("\n");
        System.out.println(">> Alteracao de nome e salario:");
        funcionario1.atualizaNome("Chris");
        funcionario2.atualizaSalarioHora(22.5); // Nao atualiza pq eh menor do que o atual
        System.out.println(funcionario1.info());
        System.out.println(funcionario2.info());

        System.out.println("\n");
        System.out.println(">> Semana de trabalho:");
        for (int dia=0; dia < 5; dia++){
            funcionario1.adicionaDiaDeTrabalho(8);
            funcionario2.adicionaDiaDeTrabalho(4.5);
        }
        System.out.println(funcionario1.info());
        System.out.println(funcionario2.info());
    }
    
}