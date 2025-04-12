package repository;

import Model.ChiffreAffaireGrp2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiffreAffaire2GrpRepository extends JpaRepository<ChiffreAffaireGrp2, Integer> {
//    List<DBloc> findByNomBlocLike(String nomBloc);

}