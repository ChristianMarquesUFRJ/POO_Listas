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

    // 
    public static boolean testeAtualizaSalarioHora(){
        // Validacao de valores com base o 12.50 (minimo)
        double salarios[] = {-10.00, 12.49, 12.51, 30.00};
        boolean status[] = {false, false, true, true};
        int primeiro_id = Funcionario.getProximoID();
        int total_funcionarios = salarios.length; 
        Funcionario [] funcionarios = new Funcionario[total_funcionarios];
        for (int i = 0; i < funcionarios.length; i++){
            funcionarios[i] = new Funcionario("Funcionario_" + (primeiro_id+i));
            funcionarios[i].atualizaSalarioHora(salarios[i]);
            // System.out.println("Novo nome: " + funcionarios[i].getNome());
            if ((funcionarios[i].getSalarioHora() != salarios[i]) == status[i])
                return false;
        }
        // Validacao com base em um valor acima do atual
        double novos_salarios[] = {30.00, 60.00, 90.00};
        primeiro_id = Funcionario.getProximoID();
        total_funcionarios = novos_salarios.length; 
        Funcionario [] novos_funcionarios = new Funcionario[total_funcionarios];
        for (int i = 0; i < novos_funcionarios.length; i++){
            novos_funcionarios[i] = new Funcionario("Funcionario_" + (primeiro_id+i), novos_salarios[i]);
            // Validacao da insercao de um valor menor do que o atual nao pode ocorrer
            novos_funcionarios[i].atualizaSalarioHora(novos_salarios[i]-10);
            if (novos_funcionarios[i].getSalarioHora() == (novos_salarios[i]-10))
                return false;
            // Validacao da insercao de um valor maior do que o atual deve ocorrer
            novos_funcionarios[i].atualizaSalarioHora(novos_salarios[i]+10);
            if (novos_funcionarios[i].getSalarioHora() != (novos_salarios[i]+10))
                return false;
        }
        return true;
    }

    // 
    public static boolean testeAdicionaDiaDeTrabalho(){
        Funcionario funcionario = new Funcionario("Funcionario_" + Funcionario.getProximoID());
        // Apos os valores de horas_trabalhadas, logo em seguida seguem os repectivos totais esperados:
        double horas_trabalhadas[] =    {0, 2, 4, 8, 16, 32};
        double total_trabalhado[] =     {0, 0, 4, 12, 28, 28};
        for (int i = 0; i < horas_trabalhadas.length; i++){
            funcionario.adicionaDiaDeTrabalho(horas_trabalhadas[i]);
            if (funcionario.getHorasTrabalhadasMes() != total_trabalhado[i])
                return false;
        }
        return true;
    }

    // 
    public static boolean testeCalculaSalarioMes(){
        double salario_hora = 20.00;
        Funcionario funcionario = new Funcionario("Funcionario_" + Funcionario.getProximoID(), salario_hora);
        double horas_trabalhadas[] = {4, 8, 16, 24};
        double somatorio_horas = 0.0;
        for (int i = 0; i < horas_trabalhadas.length; i++){
            somatorio_horas += horas_trabalhadas[i];
            funcionario.adicionaDiaDeTrabalho(horas_trabalhadas[i]);
        }
        return (funcionario.calculaSalarioMes()==(somatorio_horas*salario_hora));
    }

    // 
    public static boolean testeReuniciaMesTrabalho(){
        double salario_hora = 20.00;
        Funcionario funcionario = new Funcionario("Funcionario_" + Funcionario.getProximoID(), salario_hora);
        double horas_trabalhadas[] = {4, 8, 16, 24};
        for (int i = 0; i < horas_trabalhadas.length; i++)
            funcionario.adicionaDiaDeTrabalho(horas_trabalhadas[i]);
        funcionario.reiniciaMesTrabalho();
        return (funcionario.getHorasTrabalhadasMes()==0.0);
    }

    public static void main(String[] args) {
        System.out.println("\n[TESTES UNITARIOS]");

        System.out.println(">> Teste de Construtor Simples: " + (FuncionarioTeste.testeConstrutorSimples()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Construtor Completo: " + (FuncionarioTeste.testeConstrutorCompleto()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Atualizar Nome: " + (FuncionarioTeste.testeAtualizaNome()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Atualizar Salario/Hora: " + (FuncionarioTeste.testeAtualizaSalarioHora()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Adicionar dia de trabalho: " + (FuncionarioTeste.testeAdicionaDiaDeTrabalho()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Calcular Salario do Mes: " + (FuncionarioTeste.testeCalculaSalarioMes()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Reinicia Mes de Trabalho: " + (FuncionarioTeste.testeReuniciaMesTrabalho()?"Passou":"Nao Passou"));
        
        System.out.println("\n");
    }
    
}