package com.senai.jonatas.comprebem.controller;

import com.senai.jonatas.comprebem.dto.ProdutoRequestDTO;
import com.senai.jonatas.comprebem.dto.ProdutoResponseDTO;
import com.senai.jonatas.comprebem.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/produtos")
@RequiredArgsConstructor
@Tag(name = "Produtos", description = "Endpoints de gerenciamento e consulta de produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Operation(summary = "Listar produtos paginados com busca opcional por nome")
    @GetMapping
    public Page<ProdutoResponseDTO> findAll(
            @Parameter(description = "Termo de busca pelo nome do produto (não diferencia maiúsculas de minúsculas)", example = "cadeira")
            @RequestParam(required = false) String busca,
            @Parameter(description = "Número da página (0-indexed)", example = "0")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Quantidade de itens por página (padrão: 20, máximo: 50)", example = "20")
            @RequestParam(defaultValue = "20") int size
    ) {
        return produtoService.findAll(busca, page, size);
    }

    @Operation(summary = "Buscar produto por ID")
    @GetMapping("/{id}")
    public ProdutoResponseDTO findById(
            @Parameter(description = "ID do produto (UUID)", example = "00000000-0000-0000-0000-000000000000")
            @PathVariable("id") UUID id
    ) {
        return produtoService.findById(id);
    }

    @GetMapping("/filtro")
    public List<ProdutoResponseDTO> findByFiltro(String filtro) {
        return produtoService.findByFiltro(filtro);
    }

    @PostMapping
    public ProdutoResponseDTO save(@Valid @RequestBody ProdutoRequestDTO produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{produtoId}")
    public ProdutoResponseDTO update(@PathVariable UUID produtoId, @Valid @RequestBody ProdutoRequestDTO produto) {
        return produtoService.update(produtoId, produto);
    }

    @DeleteMapping
    public void delete(UUID produtoId) {
        produtoService.delete(produtoId);
    }
}
