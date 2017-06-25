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
    
    public boolean validarNovaSenha(String senhaFornecida){
        if(senhaFornecida.length() >= 5 && senhaFornecida.length() <= 10){
            if(senhaFornecida.substring(0, 1).matches("\\w")){
                if(senhaFornecida.substring(1, senhaFornecida.length()).matches("\\w")){
                    if(!dic.getListaDeSenhasInvalidas().contains(senhaFornecida)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
