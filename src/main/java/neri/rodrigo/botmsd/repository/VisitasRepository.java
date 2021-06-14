package neri.rodrigo.botmsd.repository;

import neri.rodrigo.botmsd.model.estoque.Estoque;
import neri.rodrigo.botmsd.model.visitas.Visitas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VisitasRepository extends JpaRepository<Visitas, Integer> {

//    @Query("SELECT entity FROM Visitas entity WHERE entity.marca = :marca")
//    Page<Visitas> buscaMarca(Pageable pageable);
}
