/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Lista 2
 */

public class Funcionario {
    private final int id;
    private String nome;
    private double horas_trabalhadas_mes;
    private double salario_hora = Funcionario.SALARIO_HORA_MINIMO;
    private static int proximo_id = 0;
    public static final double SALARIO_HORA_MINIMO = 12.50;
    private static final double HORA_MINIMA_TRABALHADA_DIA = 4.0;
    private static final double HORA_MAXIMA_TRABALHADA_DIA = 24.0;
    
    ////////////////////////////////////////////////////////////////////
    // Construtores
    ////////////////////////////////////////////////////////////////////
    public Funcionario(String nome){
        this.id = Funcionario.proximo_id;
        Funcionario.proximo_id++;
        this.atualizarNome(nome);
        this.atualizarSalarioHora(Funcionario.SALARIO_HORA_MINIMO);
        this.reiniciarMesTrabalho();
    }
    public Funcionario(String nome, double salario_hora){
        this.id = Funcionario.proximo_id;
        Funcionario.proximo_id++;
        this.atualizarNome(nome);
        this.atualizarSalarioHora(salario_hora);
        this.reiniciarMesTrabalho();
    }
    
    ////////////////////////////////////////////////////////////////////
    // Nome
    ////////////////////////////////////////////////////////////////////
    public void atualizarNome(String novo_nome){
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
    public void atualizarSalarioHora(double novo_salario_hora){
        // 'novo_salario_hora' tem que ser maior que 12.50 e nao pode ser menor do que o atual pra atualizar
        if ((novo_salario_hora > this.salario_hora) && (novo_salario_hora >= Funcionario.SALARIO_HORA_MINIMO))
            this.salario_hora = novo_salario_hora;
    }
    public double getSalarioHora(){
        return this.salario_hora;
    }
    
    ////////////////////////////////////////////////////////////////////
    // ID
    ////////////////////////////////////////////////////////////////////
    public int getID(){
        return this.id;
    }
    public static int getProximoID(){
        return Funcionario.proximo_id;
    }
    
    ////////////////////////////////////////////////////////////////////
    // Trabalho
    ////////////////////////////////////////////////////////////////////
    public void adicionarDiaDeTrabalho(double horas_trabalhadas_dia){
        // 'horas_trabalhadas_dia' tem que ser entre 4h e 24h para atualizar
        if ((horas_trabalhadas_dia >= Funcionario.HORA_MINIMA_TRABALHADA_DIA) && (horas_trabalhadas_dia <= Funcionario.HORA_MAXIMA_TRABALHADA_DIA))
            this.horas_trabalhadas_mes += horas_trabalhadas_dia;
    }
    public double calcularSalarioMes(){
        return this.horas_trabalhadas_mes * this.salario_hora;
    }
    public void reiniciarMesTrabalho(){
        this.horas_trabalhadas_mes = 0.0;
    }
    
    ////////////////////////////////////////////////////////////////////
    // Visualizador de informacoes
    ////////////////////////////////////////////////////////////////////
    public String info(){
        return "ID: " + this.getID() + " | Nome: " + this.getNome() + " | Salario/hora: R$" + this.getSalarioHora() + " | Horas trabalhadas nesse mes: " + this.horas_trabalhadas_mes + "h | Salario nesse mes: R$ " + this.calcularSalarioMes();
    }
}