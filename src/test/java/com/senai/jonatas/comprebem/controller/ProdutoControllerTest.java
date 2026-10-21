package com.senai.jonatas.comprebem.controller;

import com.senai.jonatas.comprebem.entity.Produto;
import com.senai.jonatas.comprebem.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class ProdutoControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Autowired
    private ProdutoRepository produtoRepository;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    @DisplayName("1. /api/v1/produtos sem parâmetros: retorna 20 itens e total de 60")
    void testListarProdutosSemParametros() throws Exception {
        mockMvc.perform(get("/api/v1/produtos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(20)))
                .andExpect(jsonPath("$.totalElements", is(60)))
                .andExpect(jsonPath("$.totalPages", is(3)))
                .andExpect(jsonPath("$.number", is(0)))
                .andExpect(jsonPath("$.size", is(20)));
    }

    @Test
    @DisplayName("2. /api/v1/produtos?page=2: retorna a última página")
    void testListarProdutosUltimaPagina() throws Exception {
        mockMvc.perform(get("/api/v1/produtos")
                        .param("page", "2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(20)))
                .andExpect(jsonPath("$.number", is(2)))
                .andExpect(jsonPath("$.last", is(true)))
                .andExpect(jsonPath("$.totalElements", is(60)));
    }

    @Test
    @DisplayName("3. /api/v1/produtos?size=500: respeita o limite máximo de 50")
    void testListarProdutosLimiteMaximo50() throws Exception {
        mockMvc.perform(get("/api/v1/produtos")
                        .param("size", "500")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(50)))
                .andExpect(jsonPath("$.size", is(50)))
                .andExpect(jsonPath("$.totalElements", is(60)));
    }

    @Test
    @DisplayName("4. /api/v1/produtos?busca=cadeira: busca case-insensitive por nome")
    void testBuscarProdutosPorNomeCaseInsensitive() throws Exception {
        mockMvc.perform(get("/api/v1/produtos")
                        .param("busca", "cadeira")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", greaterThan(0)))
                .andExpect(jsonPath("$.content[*].nome", everyItem(containsStringIgnoringCase("cadeira"))));

        // Testar também em maiúsculas
        mockMvc.perform(get("/api/v1/produtos")
                        .param("busca", "CADEIRA")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", greaterThan(0)))
                .andExpect(jsonPath("$.content[*].nome", everyItem(containsStringIgnoringCase("cadeira"))));
    }

    @Test
    @DisplayName("5. /api/v1/produtos/{id}: retorna 200 para ID existente e 404 para ID inexistente")
    void testBuscarPorId() throws Exception {
        Produto existente = produtoRepository.findAll().getFirst();

        // ID existente -> 200 OK
        mockMvc.perform(get("/api/v1/produtos/{id}", existente.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.produtoId", is(existente.getId().toString())))
                .andExpect(jsonPath("$.nome", is(existente.getNome())));

        // ID inexistente -> 404 Not Found (e não 500)
        UUID idInexistente = UUID.fromString("00000000-0000-0000-0000-000000000000");
        mockMvc.perform(get("/api/v1/produtos/{id}", idInexistente)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status", is(404)))
                .andExpect(jsonPath("$.error", is("Not Found")));
    }
}
