package neri.rodrigo.botmsd.repository;

import neri.rodrigo.botmsd.model.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, Integer> {


//    @Query(name="select * from TB_Estoque where marca = 'AFTOSA'", nativeQuery = true)
//    List<EstoqueModel> findAllMarcas(String marca);

}
