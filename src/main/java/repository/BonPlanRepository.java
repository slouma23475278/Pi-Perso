package repository;
import Model.BonPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonPlanRepository extends JpaRepository<BonPlan, Integer> {
//    List<DBloc> findByNomBlocLike(String nomBloc);

}