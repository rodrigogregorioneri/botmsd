package neri.rodrigo.botmsd.repository;

import neri.rodrigo.botmsd.model.estoque.Estoque;
import neri.rodrigo.botmsd.model.vendas.Vendas;
import neri.rodrigo.botmsd.model.vendas.realizadofamiliaessemes.IRealizadoFamiliaEsseMes;
import neri.rodrigo.botmsd.model.vendas.realizadoparaoclienteenumdeterminadoperiodo.IRealizadoParaOclienteEnumDeterminadoPeriodo;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotafamiliaproduto.IRealizadoXcotaFamiliaProduto;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotaporprodutoevendedor.IRealizadoXcotaPorProdutoEvendedor;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotaporvendedornomes.IRealizadoXcotaPorVendedorNoMes;
import neri.rodrigo.botmsd.model.vendas.vendasxcota.IVendasXcota;
import neri.rodrigo.botmsd.model.visitas.visitasitentdois.IVistasItentDois;
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

    @Query("SELECT entity.grupo_mercado AS grupoMercado, entity.regional AS regional, entity.vendedor AS vendedor, entity.nome_familia_produto AS nomeFamiliaProduto, entity.produto AS produto, entity.ano AS ano, entity.mes AS mes, SUM(entity.valor_liquido_cota) AS valorLiquidoCota, SUM(entity.valor_liquido) AS valorLiquido FROM Vendas entity GROUP BY entity.grupo_mercado, entity.regional, entity.vendedor, entity.nome_familia_produto, entity.produto, entity.ano, entity.mes")
    Page<IRealizadoXcotaFamiliaProduto> realizadoXcotaFamiliaProduto(Pageable pageable);

    @Query("SELECT entity.grupo_mercado AS grupoMercado, entity.produto AS produto, entity.ano AS ano, entity.mes AS mes, SUM(entity.valor_liquido_cota) AS valorLiquidoCota, SUM(entity.valor_liquido) AS valorLiquido FROM Vendas entity GROUP BY entity.grupo_mercado, entity.vendedor, entity.produto, entity.ano, entity.mes")
    Page<IRealizadoXcotaPorProdutoEvendedor> realizadoXcotaPorProdutoEvendedor(Pageable pageable);

    @Query("SELECT entity.grupo_mercado AS grupoMercado, entity.vendedor AS vendedor, entity.produto AS produto, entity.ano AS ano, entity.mes AS mes, SUM(entity.valor_liquido_cota) AS valorLiquidoCota, SUM(valor_liquido) AS valorLiquido FROM Vendas entity GROUP BY entity.grupo_mercado, entity.vendedor, entity.produto, entity.ano, entity.mes")
    Page<IRealizadoXcotaPorVendedorNoMes> realizadoXcotaPorVendedorNoMes(Pageable pageable);

    @Query("SELECT entity.grupo_mercado AS grupoMercado, entity.regional AS regional, entity.vendedor AS vendedor, entity.cliente AS cliente, entity.ano AS ano, entity.mes AS mes, SUM(valor_liquido) AS valorLiquido FROM Vendas entity GROUP BY entity.grupo_mercado, entity.regional, entity.vendedor, entity.cliente, entity.ano, entity.mes")
    Page<IRealizadoParaOclienteEnumDeterminadoPeriodo> realizadoParaOclienteEmUmDeterminadoPeriodo(Pageable pageable);

    @Query(value = "SELECT NOMEFAMILIAPRODUTO as familia\n" +
            "\t\t,ANO\n" +
            "\t\t,MES\n" +
            "\t\t,sum(VALORLIQUIDO_COTA) as Meta\n" +
            "\t\t,sum(VALORLIQUIDO) as Realizado\n" +
            "\t\t,(case when sum(VALORLIQUIDO_COTA) = '0.00' \n" +
            "\t\t\tthen cast(round((sum(VALORLIQUIDO) * 100) / 100, 2) as decimal(10,2))\n" +
            "\t\t\telse cast(round((sum(VALORLIQUIDO) * 100) / sum(VALORLIQUIDO_COTA), 2) as decimal(10,2))\n" +
            "\t\t end) as [Desempenho%]\n" +
            "FROM [DB_Hackaton].[dbo].[TB_Vendas]\n" +
            "where 1=1\n" +
            "and NOMEFAMILIAPRODUTO like '%ANTIPARASITÁRIOS%'\n" +
            "and ANO = year(GETDATE())\n" +
            "and MES = month(GETDATE()) - 2\n" +
            "group by NOMEFAMILIAPRODUTO, ANO, MES\n" +
            "order by NOMEFAMILIAPRODUTO, ANO, MES", nativeQuery = true)
    Page<IRealizadoFamiliaEsseMes> realizadoFamiliaEsseMes(@Param("regional") String regional, Pageable pageable);

}
