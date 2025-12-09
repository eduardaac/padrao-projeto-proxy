package padroesestruturais.proxy;

import java.util.Arrays;
import java.util.List;

public class Conta implements IConta {

    private Integer numeroConta;
    private String titular;
    private String agencia;
    private Float saldo;
    private Float limite;

    public Conta(int numeroConta) {
        this.numeroConta = numeroConta;
        Conta objeto = BD.getConta(numeroConta);
        this.titular = objeto.titular;
        this.agencia = objeto.agencia;
        this.saldo = objeto.saldo;
        this.limite = objeto.limite;
    }

    public Conta(Integer numeroConta, String titular, String agencia, Float saldo, Float limite) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.agencia = agencia;
        this.saldo = saldo;
        this.limite = limite;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    @Override
    public List<String> obterDadosResumo() {
        return Arrays.asList(this.titular, this.agencia);
    }

    @Override
    public List<Float> consultarValores(Usuario usuario) {
        return Arrays.asList(this.saldo, this.limite);
    }
}