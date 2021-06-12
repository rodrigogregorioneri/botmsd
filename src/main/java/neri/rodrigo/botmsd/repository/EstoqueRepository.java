package neri.rodrigo.botmsd.repository;

import neri.rodrigo.botmsd.model.Estoque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, Integer>, PagingAndSortingRepository<Estoque, Integer> {


    @Query("SELECT entity FROM Estoque entity WHERE entity.marca = :marca")
    Page<Estoque> buscaMarca(@Param("marca") String marca, Pageable pageable);

}
