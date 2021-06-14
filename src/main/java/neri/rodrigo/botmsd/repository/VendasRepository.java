package neri.rodrigo.botmsd.repository;

import neri.rodrigo.botmsd.model.estoque.Estoque;
import neri.rodrigo.botmsd.model.vendas.Vendas;
import neri.rodrigo.botmsd.model.vendas.vendasxcota.IVendasXcota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface VendasRepository extends CrudRepository<Vendas, Integer>, PagingAndSortingRepository<Vendas, Integer> {

    // ---------------------------------INFORMAÇÕES DE VENDAS X COTA POR UNIDADE DE NEGÓCIO E REGIONAL YTD e Mês ----- INTENÇÃO 4 e 6 -----------------------
    @Query("SELECT entity.grupo_mercado AS grupoMercado, entity.regional AS regional, entity.ano AS ano, entity.mes AS mes, SUM(entity.valor_liquido_cota) AS valorLiquidoCota, SUM(valor_liquido) AS valorLiquido FROM Vendas entity GROUP BY entity.grupo_mercado, entity.regional,entity.ano, entity.mes")
    Page<IVendasXcota> vendasXcota(Pageable pageable);


}
