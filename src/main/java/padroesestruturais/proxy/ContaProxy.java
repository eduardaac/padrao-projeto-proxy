package padroesestruturais.proxy;

import java.util.List;

public class ContaProxy implements IConta {

    private Conta conta;
    private Integer numeroConta;

    public ContaProxy(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    @Override
    public List<String> obterDadosResumo() {
        if (this.conta == null) {
            this.conta = new Conta(this.numeroConta);
        }
        return this.conta.obterDadosResumo();
    }

    @Override
    public List<Float> consultarValores(Usuario usuario) {
        if (!usuario.isGerente()) {
            throw new IllegalArgumentException("Usuário não autorizado");
        }
        if (this.conta == null) {
            this.conta = new Conta(this.numeroConta);
        }
        return this.conta.consultarValores(usuario);
    }
}