package repository;
import Model.BonPlan1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonPlan1Repository extends JpaRepository<BonPlan1, Integer> {
//    List<DBloc> findByNomBlocLike(String nomBloc);

}