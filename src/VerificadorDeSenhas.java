/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julionogueira
 */
public class VerificadorDeSenhas {

    Dicionario dic;

    public VerificadorDeSenhas(Dicionario dic) {
        this.dic = dic;
    }

    public boolean validarNovaSenha(String senhaFornecida) {
        String primeiroC = senhaFornecida.substring(0, 1);
        String restante = senhaFornecida.substring(1, senhaFornecida.length());
        if (senhaFornecida.length() >= 5 && senhaFornecida.length() <= 10) {
            if (primeiroC.matches("\\w")) {
                if (restante.matches("\\w+")) {
                    if (!dic.getListaDeSenhasInvalidas().contains(senhaFornecida)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
