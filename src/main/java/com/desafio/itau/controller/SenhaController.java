package com.desafio.itau.controller;

import com.desafio.itau.service.SenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Classe responsavel pelo controle de acesso, endpoint da api
 */
@RestController
@RequestMapping("senha")
public class SenhaController {

    @Autowired
    private transient SenhaService senhaService;

    /**
     *
     * @param senha enviada para validação
     * @return true se senha for valida, false se senha não válida
     */
    @GetMapping("isValid")
    public ResponseEntity<Boolean> isValid(@RequestParam("senha") String senha) {
        return ResponseEntity.ok(this.senhaService.isValid(senha));
    }
}
