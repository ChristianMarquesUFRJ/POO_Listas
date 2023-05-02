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
// rm .\lista_4\exec_4\*.class; javac .\lista_4\exec_4\*.java; java lista_4.exec_4.FuncionarioTeste
///////////////////////////////////////////////////////////////

package lista_4.exec_4;

public class FuncionarioTeste {
    public static boolean testeGetProximoID(){
        return (Funcionario.getProximoID()==0);
    }
    public static boolean testeGetID(){
        int id = Funcionario.getProximoID();
        Funcionario funcionario = new Funcionario("Funcionario_" + Funcionario.getProximoID());
        return (funcionario.getID()==id);
    }
    public static boolean testeGetNome(){
        String nome = "Funcionario_" + Funcionario.getProximoID();
        Funcionario funcionario = new Funcionario(nome);
        return (funcionario.getNome()==nome);
    }
    public static boolean testeGetSalarioHora(){
        Funcionario funcionario = new Funcionario("Funcionario_" + Funcionario.getProximoID());
        return (funcionario.getSalarioHora()==Funcionario.SALARIO_HORA_MINIMO);
    }
    public static boolean testeGetHorasTrabalhadasMes(){
        double horas_trabalhadas = 10;
        Funcionario funcionario = new Funcionario("Funcionario_" + Funcionario.getProximoID());
        if (funcionario.getHorasTrabalhadasMes()!=0)
            return false;
        funcionario.adicionaDiaDeTrabalho(horas_trabalhadas);
        if (funcionario.getHorasTrabalhadasMes()!=horas_trabalhadas)
            return false;
        return true;
    }




    public static boolean testeConstrutorSimples(){
        int primeiro_id = Funcionario.getProximoID();
        int total_funcionarios = 10; 
        Funcionario [] funcionarios = new Funcionario[total_funcionarios];
        for (int i = 0; i < total_funcionarios; i++){
            funcionarios[i] = new Funcionario("Funcionario_" + (primeiro_id+i));
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

    // 
    public static boolean testeClone(){
        String nomes[] = {"Christian", "Oziara", "Ada", "Harry", "Anthony"};
        double salarios_hora[] = {15.0, 20.0, 25.0, 30.0, 35.0};
        int primeiro_id = Funcionario.getProximoID();
        int total_funcionarios = nomes.length; 
        Funcionario [] funcionarios = new Funcionario[total_funcionarios];
        Funcionario funcionario_clonado;
        for (int i = 0; i < funcionarios.length; i++){
            funcionarios[i] = new Funcionario("Funcionario_" + (primeiro_id+i), salarios_hora[i]);
            funcionario_clonado = funcionarios[i].clone();
            // System.out.println("Novo nome: " + funcionarios[i].getNome());
            if (funcionarios[i].getNome() != funcionario_clonado.getNome())
                return false;
            if (funcionarios[i].getSalarioHora() != funcionario_clonado.getSalarioHora())
                return false;
        }
        return true;
    }

    // 
    public static boolean testeEquals(){
        Funcionario funcionario_1 = new Funcionario("Christian", 15); //--> Esse 1
        Funcionario funcionario_2 = new Funcionario("Christian", 20);
        Funcionario funcionario_3 = new Funcionario("Christian", 15); //--> Igual a esse 1
        Funcionario funcionario_4 = new Funcionario("Oziara", 15); //--> Esse 2
        Funcionario funcionario_5 = new Funcionario("Oziara", 20);
        Funcionario funcionario_6 = new Funcionario("Oziara", 15); //--> Igual a esse 2
        if (funcionario_1.equals(funcionario_2) || funcionario_1.equals(funcionario_4) || funcionario_1.equals(funcionario_5) || funcionario_1.equals(funcionario_6))
        return false;
        if (funcionario_2.equals(funcionario_3) || funcionario_2.equals(funcionario_4) || funcionario_2.equals(funcionario_5) || funcionario_2.equals(funcionario_6))
            return false;
        if (funcionario_3.equals(funcionario_4) || funcionario_3.equals(funcionario_5) || funcionario_3.equals(funcionario_6))
            return false;
        if (funcionario_4.equals(funcionario_5))
            return false;
        if ((!funcionario_1.equals(funcionario_3)) || (!funcionario_4.equals(funcionario_6)))
            return false;
        return true;
    }


    public static void main(String[] args) {
        System.out.println("\n[TESTES UNITARIOS]");

        System.out.println(">> Teste de get ProximoID: " + (FuncionarioTeste.testeGetProximoID()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de get ID: " + (FuncionarioTeste.testeGetID()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de get Nome: " + (FuncionarioTeste.testeGetNome()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de get Salario/Hora: " + (FuncionarioTeste.testeGetSalarioHora()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de get Horas Trabalhadas/Mes: " + (FuncionarioTeste.testeGetHorasTrabalhadasMes()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Construtor Simples: " + (FuncionarioTeste.testeConstrutorSimples()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Construtor Completo: " + (FuncionarioTeste.testeConstrutorCompleto()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Atualizar Nome: " + (FuncionarioTeste.testeAtualizaNome()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Atualizar Salario/Hora: " + (FuncionarioTeste.testeAtualizaSalarioHora()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Adicionar dia de trabalho: " + (FuncionarioTeste.testeAdicionaDiaDeTrabalho()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Calcular Salario do Mes: " + (FuncionarioTeste.testeCalculaSalarioMes()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Reinicia Mes de Trabalho: " + (FuncionarioTeste.testeReuniciaMesTrabalho()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Clone: " + (FuncionarioTeste.testeClone()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Comparacao (equals): " + (FuncionarioTeste.testeEquals()?"Passou":"Nao Passou"));
        
        System.out.println("\n");
    }
    
}