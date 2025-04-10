package repository;

import Model.BilanFinancier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilanFinancierRepository extends JpaRepository<BilanFinancier, Integer> {
//    List<DBloc> findByNomBlocLike(String nomBloc);

}
