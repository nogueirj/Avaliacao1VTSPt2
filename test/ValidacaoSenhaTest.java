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
    
    public ValidacaoSenhaTest() {
    }
    
     @Test
     public void teste1SenhaInferiorA5() {
         ArrayList<String> array = new ArrayList<>();
         array.add("abc123");
         Dicionario dic = mock(Dicionario.class);
         when(dic.getListaDeSenhasInvalidas()).thenReturn(array);
         VerificadorDeSenhas validador= new VerificadorDeSenhas(dic);
         boolean retorno = validador.validarNovaSenha("abc1");
         assertEquals(false, retorno);
     }
}
