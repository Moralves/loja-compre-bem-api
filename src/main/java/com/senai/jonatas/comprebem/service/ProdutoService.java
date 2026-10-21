package com.senai.jonatas.comprebem.service;

import com.senai.jonatas.comprebem.dto.ProdutoRequestDTO;
import com.senai.jonatas.comprebem.dto.ProdutoResponseDTO;
import com.senai.jonatas.comprebem.entity.Produto;
import com.senai.jonatas.comprebem.exception.ResourceNotFoundException;
import com.senai.jonatas.comprebem.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 50;

    private final ProdutoRepository produtoRepository;

    public Page<ProdutoResponseDTO> findAll(String busca, int page, int size) {
        int targetPage = Math.max(page, 0);
        int targetSize = (size > MAX_PAGE_SIZE) ? MAX_PAGE_SIZE : (size < 1 ? DEFAULT_PAGE_SIZE : size);
        Pageable pageable = PageRequest.of(targetPage, targetSize);

        Page<Produto> produtos;
        if (busca != null && !busca.trim().isEmpty()) {
            produtos = produtoRepository.findByNomeContainingIgnoreCase(busca.trim(), pageable);
        } else {
            produtos = produtoRepository.findAll(pageable);
        }

        return produtos.map(ProdutoResponseDTO::toDto);
    }

    public List<ProdutoResponseDTO> findAllList() {
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoResponseDTO::toDto)
                .toList();
    }

    public ProdutoResponseDTO findById(UUID id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));

        return ProdutoResponseDTO.toDto(produto);
    }

    public List<ProdutoResponseDTO> findByFiltro(String filtro) {
        return produtoRepository.findByFiltro(filtro)
                .stream()
                .map(ProdutoResponseDTO::toDto)
                .toList();
    }

    public ProdutoResponseDTO save(ProdutoRequestDTO produto) {
        Produto produtoSalvo = produtoRepository.save(Produto.toEntity(produto));
        return ProdutoResponseDTO.toDto(produtoSalvo);
    }

    public void delete(UUID produtoId) {
        if (!produtoRepository.existsById(produtoId)) {
            throw new ResourceNotFoundException("Produto não encontrado com id: " + produtoId);
        }
        produtoRepository.deleteById(produtoId);
    }

    public ProdutoResponseDTO update(UUID produtoId, ProdutoRequestDTO produto) {
        Produto produtoExistente = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + produtoId));

        produtoExistente.setNome(produto.nome());
        produtoExistente.setDescricao(produto.descricao());
        produtoExistente.setPreco(produto.preco());
        produtoExistente.setCategoria(produto.categoria());
        produtoExistente.setImagem(produto.imagem());

        Produto produtoAtualizado = produtoRepository.save(produtoExistente);
        return ProdutoResponseDTO.toDto(produtoAtualizado);
    }
}
