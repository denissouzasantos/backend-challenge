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
        Pattern regex = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{9,}$");

        if (senha == null || senha.isEmpty()) {
            return false;
        }
        else if(!regex.matcher(senha).matches()){
            return false;
        }else
            return  true;
    }

    public static void main(String[] args) {
        boolean res =isValid("AbTp9!foo");
        System.out.printf(" resposta %s", res);
    }
}
