/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Lista 2
 */

package lista_4.exec_4;

public class Funcionario {
    private final int ID_FUNC;
    private String nome;
    private double horasTrabalhadasMes = 0.0;
    private double salarioHora = Funcionario.SALARIO_HORA_MINIMO;
    private static int proxID = 0;
    public static final double SALARIO_HORA_MINIMO = 12.50;
    private static final double HORA_MINIMA_TRABALHADA_DIA = 4.0;
    private static final double HORA_MAXIMA_TRABALHADA_DIA = 24.0;
    
    ////////////////////////////////////////////////////////////////////
    // Construtores
    ////////////////////////////////////////////////////////////////////
    public Funcionario(String nome){
        this.ID_FUNC = Funcionario.proxID;
        Funcionario.proxID++;
        this.atualizaNome(nome);
        this.atualizaSalarioHora(Funcionario.SALARIO_HORA_MINIMO);
    }
    public Funcionario(String nome, double salarioHora){
        this.ID_FUNC = Funcionario.proxID;
        Funcionario.proxID++;
        this.atualizaNome(nome);
        this.atualizaSalarioHora(salarioHora);
    }
    
    ////////////////////////////////////////////////////////////////////
    // Nome
    ////////////////////////////////////////////////////////////////////
    public void atualizaNome(String novo_nome){
        // 'novo_nome' tem que ser diferente do nome atual para atualizar
        if (this.nome != novo_nome)
            this.nome = novo_nome;
    }
    public String getNome(){
        return this.nome;
    }
    
    ////////////////////////////////////////////////////////////////////
    // Salario Hora
    ////////////////////////////////////////////////////////////////////
    public void atualizaSalarioHora(double novo_salario_hora){
        // 'novo_salario_hora' tem que ser maior que 12.50 e nao pode ser menor do que o atual pra atualizar
        if ((novo_salario_hora > this.salarioHora) && (novo_salario_hora >= Funcionario.SALARIO_HORA_MINIMO))
            this.salarioHora = novo_salario_hora;
    }
    public double getSalarioHora(){
        return this.salarioHora;
    }
    
    ////////////////////////////////////////////////////////////////////
    // ID
    ////////////////////////////////////////////////////////////////////
    public int getID(){
        return this.ID_FUNC;
    }
    public static int getProximoID(){
        return Funcionario.proxID;
    }
    
    ////////////////////////////////////////////////////////////////////
    // Trabalho
    ////////////////////////////////////////////////////////////////////
    public void adicionaDiaDeTrabalho(double horas_trabalhadas_dia){
        // 'horas_trabalhadas_dia' tem que ser entre 4h e 24h para atualizar
        if ((horas_trabalhadas_dia >= Funcionario.HORA_MINIMA_TRABALHADA_DIA) && (horas_trabalhadas_dia <= Funcionario.HORA_MAXIMA_TRABALHADA_DIA))
            this.horasTrabalhadasMes += horas_trabalhadas_dia;
    }
    public double getHorasTrabalhadasMes(){
        return this.horasTrabalhadasMes;
    }
    public double calculaSalarioMes(){
        return this.horasTrabalhadasMes * this.salarioHora;
    }
    public void reiniciaMesTrabalho(){
        this.horasTrabalhadasMes = 0.0;
    }
    
    ////////////////////////////////////////////////////////////////////
    // Visualizador de informacoes
    ////////////////////////////////////////////////////////////////////
    public String info(){
        return "ID: " + this.getID() + " | Nome: " + this.getNome() + " | Salario/hora: R$" + this.getSalarioHora() + " | Horas trabalhadas nesse mes: " + this.horasTrabalhadasMes + "h | Salario nesse mes: R$ " + this.calculaSalarioMes();
    }
    
    ////////////////////////////////////////////////////////////////////
    // Sobrecarga de metodos existentes
    ////////////////////////////////////////////////////////////////////
    public Funcionario clone(){
        return new Funcionario(this.getNome(), this.getSalarioHora());
    }
    public boolean equals(Funcionario funcionario){
        if ((this.getNome() != funcionario.getNome()) || (this.getSalarioHora() != funcionario.getSalarioHora()))
            return false;
        return true;
    }
}