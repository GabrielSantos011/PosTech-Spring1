package br.com.fiap.pettech.repository;

import br.com.fiap.pettech.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//implementação do spring data jpa
//extendo a JpaRepository que é do tipo genérico
//passo a entidade e o tipo da primary key

//inversão de controle, o spring vai ser responsável pela instância dessa classe
//todas as vezes que fizermos uma injeção de dependência
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
