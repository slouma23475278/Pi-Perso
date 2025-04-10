package repository;

import Model.OperationFinanciere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationFinanciereRepository extends JpaRepository<OperationFinanciere, Integer> {
//    List<DBloc> findByNomBlocLike(String nomBloc);

}