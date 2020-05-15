package com.desafio.itau.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * Classe responsavel por validar Senhas
 */
@Service
public class SenhaService {

    /**
     *
     * @param senha enviada para validação
     * @return true se senha for valida, false se senha não válida
     */
    public static boolean isValid(final String senha) {
        Pattern erMatcher = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{9,}$");
        Pattern erFind = Pattern.compile("(([A-Za-z \\d])(\\2)+)");

        if (senha == null || senha.isEmpty()) {
            return false;
        }
        else if(erFind.matcher(senha).find() || !erMatcher.matcher(senha).matches()){
            return false;
        }else
            return  true;
    }

}
