package repository;


import Model.ChiffreAffaireSociete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiffreAffaireSocieteRepository extends JpaRepository<ChiffreAffaireSociete, Integer> {
//    List<DBloc> findByNomBlocLike(String nomBloc);

}