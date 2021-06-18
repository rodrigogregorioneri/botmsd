package neri.rodrigo.botmsd.repository;

import neri.rodrigo.botmsd.model.estoque.Estoque;
import neri.rodrigo.botmsd.model.visitas.Visitas;
import neri.rodrigo.botmsd.model.visitas.visitasitentdois.IVistasItentDois;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VisitasRepository extends JpaRepository<Visitas, Integer> {

//    @Query("SELECT entity.regional AS regional, entity.acao AS acao, entity.status_visita AS statusVisita, count(entity) AS qtdVisitas  \n" +
////            "  FROM Visitas entity \n" +
////            "  where 1=1\n" +
////            "  and entity.regional like %:regional%\n" +
////            "  and entity.ano = year(GETDATE())\n" +
////            "  and entity.mes = month(GETDATE())\n" +
////            "  and entity.status_visita <> ' '\n" +
////            "  group by entity.regional, entity.acao, entity.status_visita\n" +
////            "  order by entity.regional")
////    Page<IVistasItentDois> intent2(@Param("regional") String regional, Pageable pageable);



    @Query(value = "SELECT regional, acao, statusVisita, count(*) as qtdVisitas  \n" +
            "  FROM [DB_Hackaton].[dbo].[TB_Visitas]\n" +
            "  where 1=1\n" +
            "  and REGIONAL like '%REGIONAL 42%'\n" +
            "  and ANO = year(GETDATE())\n" +
            "  and MES = month(GETDATE())\n" +
            "  and STATUS_VISITA <> ' '\n" +
            "  group by REGIONAL, ACAO, STATUS_VISITA\n" +
            "  order by REGIONAL", nativeQuery = true)
    Page<IVistasItentDois> intent2(@Param("regional") String regional, Pageable pageable);
}
