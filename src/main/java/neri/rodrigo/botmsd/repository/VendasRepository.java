package neri.rodrigo.botmsd.repository;

import neri.rodrigo.botmsd.model.vendas.Vendas;
import neri.rodrigo.botmsd.model.vendas.desempenhodevendasdogerenteyparaprodutox.IDesempenhoDeVendasDoGerenteYparaProdutoX;
import neri.rodrigo.botmsd.model.vendas.itentcinco.IItent5;
import neri.rodrigo.botmsd.model.vendas.itentdez.IItent10;
import neri.rodrigo.botmsd.model.vendas.itentnove.IItent9;
import neri.rodrigo.botmsd.model.vendas.itentquatro.IItent4;
import neri.rodrigo.botmsd.model.vendas.itentseis.IItent6;
import neri.rodrigo.botmsd.model.vendas.quantidadedevendastotaiparacadacliente.IQuantidadeDeVendasTotalParaCadaCliente;
import neri.rodrigo.botmsd.model.vendas.quantoaregionaixvendeuessemes.IQuantoAregionalXvendeuEsseMes;
import neri.rodrigo.botmsd.model.vendas.realizadodocolaboradorxessemes.IRealizadoDoColaboradorXesseMes;
import neri.rodrigo.botmsd.model.vendas.realizadofamiliaessemes.IRealizadoFamiliaEsseMes;
import neri.rodrigo.botmsd.model.vendas.realizadoparaoclienteenumdeterminadoperiodo.IRealizadoParaOclienteEnumDeterminadoPeriodo;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotafamiliaproduto.IRealizadoXcotaFamiliaProduto;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotaporprodutoevendedor.IRealizadoXcotaPorProdutoEvendedor;
import neri.rodrigo.botmsd.model.vendas.realizadoxcotaporvendedornomes.IRealizadoXcotaPorVendedorNoMes;
import neri.rodrigo.botmsd.model.vendas.somadevendasrealizadasparacadaclienteseumamesmaregional.ISomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional;
import neri.rodrigo.botmsd.model.vendas.vendasxcota.IVendasXcota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    //  intent 8 - Qual o realizado da familia X esse mês?
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
            "and NOMEFAMILIAPRODUTO like %:familiaproduto%\n" +
            "and ANO = year(GETDATE())\n" +
            "and MES = month(GETDATE()) - 2\n" +
            "group by NOMEFAMILIAPRODUTO, ANO, MES\n" +
            "order by NOMEFAMILIAPRODUTO, ANO, MES", nativeQuery = true)
    Page<IRealizadoFamiliaEsseMes> realizadoFamiliaEsseMes(@Param("familiaproduto") String familiaproduto, Pageable pageable);


    // FIAP intent 3
    @Query(value = "SELECT VENDEDOR\n" +
            "\t\t,PRODUTO\n" +
            "\t\t,sum(VALORLIQUIDO_COTA) as Meta\n" +
            "\t\t,sum(VALORLIQUIDO) as Realizado\n" +
            "\t\t,(case when sum(VALORLIQUIDO_COTA) = '0.00' \n" +
            "\t\t\tthen cast(round((sum(VALORLIQUIDO) * 100) / 100, 2) as decimal(10,2))\n" +
            "\t\t\telse cast(round((sum(VALORLIQUIDO) * 100) / sum(VALORLIQUIDO_COTA), 2) as decimal(10,2))\n" +
            "\t\t end) as [Desempenho%]\n" +
            "FROM [DB_Hackaton].[dbo].[TB_Vendas]\n" +
            "where 1=1\n" +
            "and VENDEDOR = :vendedor \n" +
            "and PRODUTO like %:produto%\n" +
            "group by VENDEDOR, PRODUTO\n" +
            "order by VENDEDOR, PRODUTO",nativeQuery = true)
    Page<IDesempenhoDeVendasDoGerenteYparaProdutoX> desempenhoDeVendasDoGerenteYparaProdutoX(@Param("vendedor") String vendedor, @Param("produto") String produto, Pageable pageable);

    //  Intent 7 - Qual o realizado do colaborador X esse mês?
    @Query(value = "SELECT \n" +
            " VENDEDOR ,sum(VALORLIQUIDO) AS Realizado,sum(VALORLIQUIDO_COTA) AS Cota\n" +
            "FROM TB_VENDAS\n" +
            "WHERE VENDEDOR = :vendedor and MES=month(GETDATE()) -2\n" +
            "GROUP BY VENDEDOR",nativeQuery = true)
    Page<IRealizadoDoColaboradorXesseMes> realizadoDoColaboradorXesseMes(@Param("vendedor") String vendedor, Pageable pageable);


    // Intent 11 - Quanto o vendedor x vendeu esse mês
    @Query(value = "SELECT \n" +
            " VENDEDOR ,Cliente,SUM(VALORLIQUIDO) AS vendasRealizadas\n" +
            "FROM TB_VENDAS\n" +
            "WHERE VENDEDOR = :vendedor\n" +
            "and CLIENTE = :cliente\n" +
            "and ANO = year(GETDATE())\n" +
            "and MES=month(GETDATE()) -2\n" +
            "GROUP BY Cliente",nativeQuery = true)
    Page<IQuantidadeDeVendasTotalParaCadaCliente> quantidadeDeVendasTotalParaCadaCliente(@Param("vendedor") String vendedor, @Param("cliente") String cliente, Pageable pageable);


    // Itent 12 Quanto a regional X  vendeu esse mês? ✔
    @Query(value = "SELECT REGIONAL,MES,SUM(VALORLIQUIDO) AS VENDIDO\n" +
            "FROM TB_VENDAS\n" +
            "WHERE REGIONAL = :regional and ANO = year(GETDATE())and MES= month(GETDATE()) -2\n" +
            "GROUP BY REGIONAL,MES",nativeQuery = true)
    Page<ISomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional>  somaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional(@Param("regional") String regional, Pageable pageable);


    // Itent 4
    @Query(value = "SELECT PRODUTO as Linha\n" +
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
            "and PRODUTO like '%:produto%'\n" +
            "and ANO = year(GETDATE())\n" +
            "and MES = month(GETDATE()) - 2\n" +
            "group by PRODUTO, ANO, MES\n" +
            "order by PRODUTO, ANO, MES",nativeQuery = true)
    Page<IItent4> itent4(@Param("produto") String produto, Pageable pageable);

    // Itent 5
    @Query(value = "SELECT REGIONAL\n" +
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
            "and REGIONAL like '%:regional%'\n" +
            "and ANO = year(GETDATE())\n" +
            "and MES = month(GETDATE()) - 2\n" +
            "group by REGIONAL, ANO, MES\n" +
            "order by REGIONAL, ANO, MES",nativeQuery = true)
    Page<IItent5> itent5(@Param("regional") String regional, Pageable pageable);

    // Itent 6
    @Query(value = "SELECT PRODUTO\n" +
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
            "and PRODUTO like %:produto%\n" +
            "and ANO = year(GETDATE())\n" +
            "and MES = month(GETDATE()) - 2\n" +
            "group by PRODUTO, ANO, MES\n" +
            "order by PRODUTO, ANO, MES",nativeQuery = true)
    Page<IItent6> itent6(@Param("produto") String produto, Pageable pageable);

    // Itent 9
    @Query(value = "SELECT \n" +
            " VENDEDOR ,Cliente,SUM(VALORLIQUIDO) AS Realizado\n" +
            "FROM TB_VENDAS\n" +
            "WHERE VENDEDOR = :vendedor and CLIENTE = :cliente and ANO = year(GETDATE()) and MES = month(GETDATE()) -2\n" +
            "GROUP BY VENDEDOR,Cliente,ANO,MES",nativeQuery = true)
    Page<IItent9> itent9(@Param("vendedor") String vendedor, @Param("cliente") String cliente,Pageable pageable);

    // Itent 10
    @Query(value = "SELECT TB_VENDAS.VENDEDOR\n" +
            "\t\t,TB_VENDAS.PRODUTO\n" +
            "\t\t,vendido_ano_passado.VENDIDO as vendido_ano_passado\n" +
            "\t\t,SUM(VALORLIQUIDO) AS vendido_ano_atual\n" +
            "\t\t,(case when vendido_ano_passado.VENDIDO = '0.00' \n" +
            "\t\t\t\tthen cast(round((sum(VALORLIQUIDO) * 100) / 100, 2) as decimal(10,2))\n" +
            "\t\t\t\telse cast(round((sum(VALORLIQUIDO) * 100) / sum(vendido_ano_passado.VENDIDO), 2) as decimal(10,2))\n" +
            "\t\t\t end) as [Desempenho%]\n" +
            "\tFROM TB_VENDAS \n" +
            "\t, (SELECT SUM(VALORLIQUIDO) AS VENDIDO\n" +
            "\t\t\t,VENDEDOR\n" +
            "\t\t\t,PRODUTO\n" +
            "\t\t\tFROM TB_VENDAS as tb_vendas_ano_passado\n" +
            "\t\t\tWHERE 1=1\n" +
            "\t\t\tand ANO = year(GETDATE()) - 1\n" +
            "\t\t\tand MES = month(GETDATE()) -2\n" +
            "\t\t\tGROUP BY VENDEDOR, PRODUTO\n" +
            "\t\t) as vendido_ano_passado\n" +
            "\tWHERE 1=1\n" +
            "\tand ANO = year(GETDATE())\n" +
            "\tand MES = month(GETDATE()) -2\n" +
            "\tand vendido_ano_passado.VENDEDOR = TB_VENDAS.VENDEDOR\n" +
            "\tand vendido_ano_passado.PRODUTO = TB_VENDAS.PRODUTO\n" +
            "\tGROUP BY TB_VENDAS.VENDEDOR, TB_VENDAS.PRODUTO, ANO, MES, vendido_ano_passado.VENDIDO\n" +
            "\torder by TB_VENDAS.VENDEDOR, TB_VENDAS.PRODUTO",nativeQuery = true)
    Page<IItent10> itent10(Pageable pageable);

}
