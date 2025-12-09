package padroesestruturais.proxy;

import java.util.List;

public interface IConta {
    List<String> obterDadosResumo();
    List<Float> consultarValores(Usuario usuario);
}