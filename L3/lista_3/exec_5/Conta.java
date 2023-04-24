/*
 * UNIVERSIDADE FEDERAL DO RIO DE JANEIRO
 * DISCIPLINA: Introdução à Programação Orientada à Objetos
 * PROFESSORA: Rafaela Correia Brum
 * ALUNO: Christian Marques de Oliveira Silva
 * DRE: 117.214.742
 * Lista 3
 */

package lista_3.exec_5;
import java.math.BigDecimal;

public class Conta {
    public static int total_criadas = 0;
    private double saldo = 0.0;
    
    public Conta(){
        Conta.total_criadas++;
    }

    //////////////////////////////////////////////////////////////////////
    // IMPLEMENTACOES DE SOBRECARGA PARA RESOLVER PROBLEMAS DE PONTO 
    // FLUTUANTE NA ADICAO E SUBTRACAO:
    //  -> Ex.: 10.47 + 55.99 = 66.460000000001 (acontecia anteriormente)
    //////////////////////////////////////////////////////////////////////
    public static double add(double parcel_1, double parcel_2) {
        BigDecimal b1 = new BigDecimal(Double.toString(parcel_1));
        BigDecimal b2 = new BigDecimal(Double.toString(parcel_2));
        return b1.add(b2).doubleValue();
    }
    public static double sub(double minuend, double subtrahend) {
        BigDecimal b1 = new BigDecimal(Double.toString(minuend));
        BigDecimal b2 = new BigDecimal(Double.toString(subtrahend));
        return b1.subtract(b2).doubleValue();
    }
    //////////////////////////////////////////////////////////////////////

    public void deposita(double deposito){
        if (deposito >= 0.0)
            this.saldo = Conta.add(this.saldo, deposito);
    }

    public double pegaSaldo(){
        return this.saldo;
    }

    public boolean saca(double valor_saque){
        if ((valor_saque < this.saldo) && (valor_saque >= 0.0)){
            this.saldo = Conta.sub(this.saldo, valor_saque);
            return true;
        }
        return false;
    }
}
