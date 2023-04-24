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
// rm .\lista_3\exec_5\*.class      -> Remove todos os .class
// javac .\lista_3\exec_5\*.java    -> Gerar .class
// java lista_3.exec_5.ContaTeste   -> Rodar
///////////////////////////////////////////////////////////////

package lista_3.exec_5;

// Validacao de criacao de objetos da Conta. Nesse caso sao 10 criados. Cada um incrementa um contador
// Se todas seguirem a contagem de contas criadas, o contador sempre vai estar correto e a funcao retornara true.
public class ContaTeste {
    public static boolean testeConstrutor(){
        int total_contas_teste = 10; 
        Conta [] contas = new Conta[total_contas_teste];
        for (int i = 0; i < total_contas_teste; i++){
            contas[i] = new Conta();
            if (i+1 != Conta.total_criadas)
                return false;
        }
        return true;
    }

    // Inicialmente o saldo eh zero. Assim, se uma conta recem criada retornar zero eh pq o metodo 'pegaSaldo' esta correto.
    public static boolean testePegaSaldo(){
        Conta conta = new Conta();
        return (conta.pegaSaldo() == 0.0);
    }

    // Dado um array de valores de depositos e outro com as respostas esperadas apos cada chamada da funcao 'deposita',
    // cada caso eh validado e so retorna true se todos forem verdadeiros.
    public static boolean testeDeposita(){
        Conta conta = new Conta();
        // Apos os valores de depositos, logo em seguida seguem os repectivos saldos esperados:
        double deposito[] =    {10.47, 55.99, -32.27, 102.10, 0.01, -0.01};
        double saldo[] =       {10.47, 66.46, 66.46, 168.56, 168.57, 168.57};
        for (int i = 0; i < deposito.length; i++){
            conta.deposita(deposito[i]);
            double saldo_ = conta.pegaSaldo();
            if (saldo_ != saldo[i])
                return false;
        }
        return true;
    }

    // Dado um deposito grande, eh criado array de valores de saque e outro com as respostas esperadas apos cada chamada da funcao 
    // 'saca', cada caso eh validado e so retorna true se todos forem verdadeiros.
    public static boolean testeSaca(){
        double saldo_inicial = 100.00;
        Conta conta = new Conta();
        conta.deposita(saldo_inicial);
        // Valores de saque para validacao, apos, seu saldo esperado e seu status retornado da funcao:
        double saque[] =    {10.47, 55.99, -32.27, 0.01, -0.01, 102.10, 33.54, 33.53, 33.52};
        double saldo[] =    {89.53, 33.54, 33.54, 33.53, 33.53, 33.53, 33.53, 33.53, 0.01};
        boolean status[] =  {true, true, false, true, false, false, false, false, true};
        for (int i = 0; i < saque.length; i++)
            if ((conta.saca(saque[i]) != status[i]) || (conta.pegaSaldo() != saldo[i]))
                return false;
        return true;
    }
    
    public static void main(String[] args){
        System.out.println("\n[TESTES UNITARIOS]");

        System.out.println(">> Teste de Construtor: " + (ContaTeste.testeConstrutor()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Pegar Saldo: " + (ContaTeste.testePegaSaldo()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Deposito: " + (ContaTeste.testeDeposita()?"Passou":"Nao Passou"));
        System.out.println(">> Teste de Saque: " + (ContaTeste.testeSaca()?"Passou":"Nao Passou"));

        System.out.println("\n");
    }
}
