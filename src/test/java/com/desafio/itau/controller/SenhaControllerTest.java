package com.desafio.itau.controller;

import com.desafio.itau.ItauApplication;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItauApplication.class)
public class SenhaControllerTest {

    private transient MockMvc mockMvc;

    @Autowired
    private transient SenhaController senhaController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(senhaController).build();
    }

    /**
     * Teste enviando uma string vazia
     * @throws Exception se houver alguma excecao
     */
    @Test
    public void empty() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/senha/isValid")
                .param("senha", ""))
                .andExpect(MockMvcResultMatchers.content().string("false"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Cenario sem um caracter numerico
     * @throws Exception se houver alguma excecao
     */
    @Test
    public void semDigito() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/senha/isValid")
                .param("senha", "AAAbbbCc!"))
                .andExpect(MockMvcResultMatchers.content().string("false"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Cenario sem um caracter maiusculo
     * @throws Exception se houver alguma excecao
     */
    @Test
    public void semCaracterMaiusculo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/senha/isValid")
                .param("senha", "aaaddff34cr!"))
                .andExpect(MockMvcResultMatchers.content().string("false"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Cenario sem um caracter minusculo
     * @throws Exception se houver alguma excecao
     */
    @Test
    public void semCaracterMinusculo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/senha/isValid")
                .param("senha", "AAAbbbCT!"))
                .andExpect(MockMvcResultMatchers.content().string("false"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    /**
     * Cenario sem a quantidade minima de caracter
     * @throws Exception se houver alguma excecao
     */
    @Test
    public void semSizeMinimo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/senha/isValid")
                .param("senha", "Abp9!fok"))
                .andExpect(MockMvcResultMatchers.content().string("false"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Cenario em que a senha é valida, respeitando todos os requisitos
     * @throws Exception se houver alguma execao
     */
    @Test
    public void valida() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/senha/isValid")
                .param("senha", "AbTp9!fok!"))
                .andExpect(MockMvcResultMatchers.content().string("true"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
