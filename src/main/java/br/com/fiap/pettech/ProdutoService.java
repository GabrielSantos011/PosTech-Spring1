package br.com.fiap.pettech;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

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

    public Collection<Produto> findAll() {
        //método do JpaRepository
        var produtos = repo.findAll();
        return  produtos;
    }

    public Produto findById(UUID id) {
        var produto = repo.findById(id).orElseThrow(() -> new ControllerNotFoundException("Produto não encontrado"));
        return produto;
    }

    public Produto save(Produto produto) {
        produto = repo.save(produto);
        return produto;
    }

    public Produto update(UUID id, Produto produto) {
        try {
            Produto buscaProduto = repo.getOne(id);
            buscaProduto.setNome(produto.getNome());
            buscaProduto.setDescricao(produto.getDescricao());
            buscaProduto.setUrlDaImagem(produto.getUrlDaImagem());
            buscaProduto.setPreco(produto.getPreco());
            buscaProduto = repo.save(buscaProduto);

            return buscaProduto;
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Produto não encontrado");
        }
    }

    public  void delete(UUID id) {
        repo.deleteById(id);
    }

}
