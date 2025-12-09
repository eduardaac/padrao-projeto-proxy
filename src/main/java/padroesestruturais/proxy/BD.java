package padroesestruturais.proxy;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Conta> contas = new HashMap<>();

    public static Conta getConta(Integer numeroConta) {
        return contas.get(numeroConta);
    }

    public static void addConta(Conta conta) {
        contas.put(conta.getNumeroConta(), conta);
    }
}