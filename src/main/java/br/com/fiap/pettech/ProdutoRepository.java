package br.com.fiap.pettech;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

//implementação do spring data jpa
//extendo a JpaRepository que é do tipo genérico
//passo a entidade e o tipo da primary key
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
