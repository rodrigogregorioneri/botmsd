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



    @Query(value = "SELECT regional, acao, STATUS_VISITA, count(*) as qtdVisitas  \n" +
            "  FROM [DB_Hackaton].[dbo].[TB_Visitas]\n" +
            "  where 1=1\n" +
            "  and REGIONAL like %:regional%\n" +
            "  and ANO = year(GETDATE())\n" +
            "  and MES = month(GETDATE())\n" +
            "  and STATUS_VISITA <> ' '\n" +
            "  group by REGIONAL, ACAO, STATUS_VISITA\n" +
            "  order by REGIONAL", nativeQuery = true)
    Page<IVistasItentDois> intent2(@Param("regional") String regional, Pageable pageable);




}
