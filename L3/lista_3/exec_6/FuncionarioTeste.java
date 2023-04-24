/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Lista 3
 */

///////////////////////////////////////////////////////////////
// COMANDOS UTILIZADOS PARA O TESTE
///////////////////////////////////////////////////////////////
// rm .\lista_3\exec_6\*.class; javac .\lista_3\exec_6\*.java; java lista_3.exec_6.FuncionarioTeste
///////////////////////////////////////////////////////////////

package lista_3.exec_6;

public class FuncionarioTeste {
    public static boolean testeConstrutorSimples(){
        int primeiro_id = Funcionario.getProximoID();
        int total_funcionarios = 10; 
        int ultimo_id = primeiro_id + total_funcionarios; 
        Funcionario [] funcionarios = new Funcionario[total_funcionarios];
        for (int i = primeiro_id; i < ultimo_id; i++){
            funcionarios[i] = new Funcionario("Funcionario_" + primeiro_id+i);
            if (primeiro_id+i+1 != Funcionario.getProximoID())
                return false;
        }
        return true;
    }

    public static boolean testeConstrutorCompleto(){
        int primeiro_id = Funcionario.getProximoID();
        int total_funcionarios = 10; 
        int ultimo_id = primeiro_id + total_funcionarios; 
        Funcionario [] funcionarios = new Funcionario[total_funcionarios];
        for (int i = 0; i < funcionarios.length; i++){
            funcionarios[i] = new Funcionario("Funcionario_" + (primeiro_id+i), 30.00);
            // System.out.println("ID: " + i + " | TAMANHO: " + funcionarios.length);
            // System.out.println("ID: " + funcionarios[i].getID());
            if (primeiro_id+i+1 != Funcionario.getProximoID())
                return false;
        }
        return true;
    }

    // 
    public static boolean testeAtualizaNome(){
        //
        String nomes[] = {"Christian", "Oziara", "Ada", "Harry", "Anthony"};
        int primeiro_id = Funcionario.getProximoID();
        int total_funcionarios = nomes.length; 
        int ultimo_id = primeiro_id + total_funcionarios; 
        Funcionario [] funcionarios = new Funcionario[total_funcionarios];
        for (int i = 0; i < funcionarios.length; i++){
            funcionarios[i] = new Funcionario("Funcionario_" + (primeiro_id+i), 30.00);
            funcionarios[i].atualizaNome(nomes[i]);
            // System.out.println("Novo nome: " + funcionarios[i].getNome());
            if (funcionarios[i].getNome() != nomes[i])
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("\n[TESTES UNITARIOS]");

        System.out.println(">> Teste de Construtor Simples: " + (FuncionarioTeste.testeConstrutorSimples()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Construtor Completo: " + (FuncionarioTeste.testeConstrutorCompleto()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Atualizar Nome: " + (FuncionarioTeste.testeAtualizaNome()?"Passou":"Nao Passou"));
        
        System.out.println("\n");
        // Funcionario funcionario1 = new Funcionario("Christian");
        // Funcionario funcionario2 = new Funcionario("Oziara", 25.00);
        // System.out.println("\n");
        // System.out.println(">> Funcionarios Cadastrados:");
        // System.out.println(funcionario1.info());
        // System.out.println(funcionario2.info());
        // System.out.println(">> Total de funcionarios cadastrados: " + Funcionario.getProximoID());

        // System.out.println("\n");
        // System.out.println(">> Alteracao de nome e salario:");
        // funcionario1.atualizaNome("Chris");
        // funcionario2.atualizaSalarioHora(22.5); // Nao atualiza pq eh menor do que o atual
        // System.out.println(funcionario1.info());
        // System.out.println(funcionario2.info());

        // System.out.println("\n");
        // System.out.println(">> Semana de trabalho:");
        // for (int dia=0; dia < 5; dia++){
        //     funcionario1.adicionaDiaDeTrabalho(8);
        //     funcionario2.adicionaDiaDeTrabalho(4.5);
        // }
        // System.out.println(funcionario1.info());
        // System.out.println(funcionario2.info());
    }
    
}