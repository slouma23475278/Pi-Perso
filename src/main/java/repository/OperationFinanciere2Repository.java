package repository;

import Model.OperationFinanciere2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationFinanciere2Repository extends JpaRepository<OperationFinanciere2, Integer> {
//    List<DBloc> findByNomBlocLike(String nomBloc);

}