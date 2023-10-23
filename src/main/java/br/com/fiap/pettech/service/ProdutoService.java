package br.com.fiap.pettech.service;

import br.com.fiap.pettech.controller.exception.ControllerNotFoundException;
import br.com.fiap.pettech.dto.ProdutoDTO;
import br.com.fiap.pettech.entities.Produto;
import br.com.fiap.pettech.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

//essa notação vai fazer a inversão do controle dessa classe para o spring
//ou seja, o spring vai ser responsável pela instância dessa classe
//todas as vezes que fizermos uma injeção de dependência
//as 3 anotações que fazem a inversão de controle são
//@Service, @Component e @Repository
@Service
public class ProdutoService {

    //fazendo a injeção de dependência
    @Autowired
    private ProdutoRepository repo;

    public Collection<ProdutoDTO> findAll() {
        //método do JpaRepository
        var produtos = repo.findAll();
        return  produtos
                .stream()
                .map(this::toProdutoDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO findById(UUID id) {
        var produto = repo.findById(id).orElseThrow(() -> new ControllerNotFoundException("Produto não encontrado"));
        return toProdutoDTO(produto);
    }

    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        var produto = toProduto(produtoDTO);
        produto = repo.save(produto);
        return toProdutoDTO(produto);
    }

    public ProdutoDTO update(UUID id, ProdutoDTO produtoDTO) {
        try {
            Produto buscaProduto = repo.getReferenceById(id);
            buscaProduto.setNome(produtoDTO.nome());
            buscaProduto.setDescricao(produtoDTO.descricao());
            buscaProduto.setUrlDaImagem(produtoDTO.urlDaImagem());
            buscaProduto.setPreco(produtoDTO.preco());
            buscaProduto = repo.save(buscaProduto);

            return toProdutoDTO(buscaProduto);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Produto não encontrado");
        }
    }

    public  void delete(UUID id) {
        repo.deleteById(id);
    }

    private ProdutoDTO toProdutoDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getUrlDaImagem()
        );
    }
    private Produto toProduto(ProdutoDTO produtoDTO) {
        return new Produto(
                produtoDTO.id(),
                produtoDTO.nome(),
                produtoDTO.descricao(),
                produtoDTO.preco(),
                produtoDTO.urlDaImagem()
        );
    }

}
