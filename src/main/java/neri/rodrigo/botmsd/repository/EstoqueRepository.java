package neri.rodrigo.botmsd.repository;

import neri.rodrigo.botmsd.model.Estoque;
import neri.rodrigo.botmsd.model.IResponse;
import neri.rodrigo.botmsd.model.ResponseTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, Integer>, PagingAndSortingRepository<Estoque, Integer> {


    @Query("SELECT entity FROM Estoque entity WHERE entity.marca = :marca")
    Page<Estoque> buscaMarca(@Param("marca") String marca, Pageable pageable);

    @Query("SELECT entity.cod_produto AS codProduto, entity.marca AS produto, entity.nome_centro_distribuicao AS nomeCentroDistribuicao, SUM(entity.total_estoque) AS quantidade, SUM(entity.valor_total) AS valorTotal FROM Estoque entity GROUP BY entity.cod_produto, entity.marca, entity.nome_centro_distribuicao")
    List<IResponse> buscaMarca2(Pageable pageable);

}
