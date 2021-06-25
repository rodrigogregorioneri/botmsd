package neri.rodrigo.botmsd.repository;

import neri.rodrigo.botmsd.model.estoque.Estoque;
import neri.rodrigo.botmsd.model.estoque.buscatotalestoqueporproduto.ITotalEstoquePorProduto;
import neri.rodrigo.botmsd.model.estoque.estoqueinfo.IEstoqueInfo;
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
    Page<IEstoqueInfo> buscaMarca2(Pageable pageable);




    @Query("SELECT entity.cod_produto AS codProduto ,entity.nomeproduto AS nomeProduto, ROUND(SUM(entity.total_estoque),0) AS somaEstoque FROM Estoque entity WHERE entity.nomeproduto LIKE %:nome% GROUP BY entity.cod_produto,entity.nomeproduto")
    Page<ITotalEstoquePorProduto> buscaTotalEstoquePorProduto(@Param("nome") String nome_produto, Pageable pageable);

}
