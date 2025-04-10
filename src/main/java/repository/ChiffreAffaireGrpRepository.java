package repository;

import Model.ChiffreAffaireGrp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiffreAffaireGrpRepository extends JpaRepository<ChiffreAffaireGrp, Integer> {
//    List<DBloc> findByNomBlocLike(String nomBloc);

}