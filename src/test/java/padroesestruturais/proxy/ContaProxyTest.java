package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ContaProxyTest {

    @BeforeEach
    void setUp() {
        BD.addConta(new Conta(123, "Carlos", "Centro", 5000.0f, 2000.0f));
        BD.addConta(new Conta(456, "Fernanda", "Zona Sul", 15000.0f, 5000.0f));
    }

    @Test
    void deveRetornarResumoConta() {
        ContaProxy conta = new ContaProxy(123);

        assertEquals(Arrays.asList("Carlos", "Centro"), conta.obterDadosResumo());
    }

    @Test
    void deveRetornarValoresConta() {
        Usuario usuario = new Usuario("Roberto", true); // É gerente
        ContaProxy conta = new ContaProxy(456);

        assertEquals(Arrays.asList(15000.0f, 5000.0f), conta.consultarValores(usuario));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarValores() {
        try {
            Usuario usuario = new Usuario("Julia", false); // Não é gerente
            ContaProxy conta = new ContaProxy(456);

            conta.consultarValores(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Usuário não autorizado", e.getMessage());
        }
    }
}