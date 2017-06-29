/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author julionogueira
 */
public class ValidacaoSenhaTest {

    private final Dicionario dic;
    private final VerificadorDeSenhas verificador;
    
    public ValidacaoSenhaTest() {
        dic = mock(Dicionario.class);
        verificador = new VerificadorDeSenhas(dic);
    }

    @Test
    public void teste1SenhaInferiorA5() {
        when(dic.getListaDeSenhasInvalidas()).thenReturn(new ArrayList<>());
        boolean retorno = verificador.validarNovaSenha("abc1");
        assertFalse(retorno);
    }

    @Test
    public void testeSenhaForaDoPadrao() {
        when(dic.getListaDeSenhasInvalidas()).thenReturn(new ArrayList<>());
        boolean retorno = verificador.validarNovaSenha("*&%$3456");
        assertFalse(retorno);
    }

    @Test
    public void testeSemSenhaExistente() {
        ArrayList<String> array = new ArrayList<>();
        array.add("abc123");
        when(dic.getListaDeSenhasInvalidas()).thenReturn(array);
        boolean retorno = verificador.validarNovaSenha("abc1234");
        assertTrue(retorno);
    }
    
    @Test
    public void testeComSenhaExistente() {
        ArrayList<String> array = new ArrayList<>();
        array.add("abc123");
        when(dic.getListaDeSenhasInvalidas()).thenReturn(array);
        boolean retorno = verificador.validarNovaSenha("abc123");
        assertFalse(retorno);
    }
}
