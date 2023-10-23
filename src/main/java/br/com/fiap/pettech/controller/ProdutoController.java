package br.com.fiap.pettech.controller;

import br.com.fiap.pettech.dto.ProdutoDTO;
import br.com.fiap.pettech.entities.Produto;
import br.com.fiap.pettech.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

//controladora da nossa api rest
@RestController
//mapeamento de url
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    public ProdutoService service;

    @GetMapping("/listar")
    public ResponseEntity<Collection<ProdutoDTO>> findAll() {
        var produtos = service.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable UUID id) {
        var produto = service.findById(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produto) {
        produto = service.save(produto);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(produto);
    }

    @PutMapping("/atualiza/{id}")
    public ResponseEntity<ProdutoDTO> update(@RequestBody ProdutoDTO produto, @PathVariable UUID id) {
        produto = service.update(id, produto);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
