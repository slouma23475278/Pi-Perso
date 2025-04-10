package repository;

import Model.BilanFinancier2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilanFinancier2Repository extends JpaRepository<BilanFinancier2, Integer> {
//    List<DBloc> findByNomBlocLike(String nomBloc);

}
