package repository;


import Model.ChiffreAffaireSociete2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiffreAffaireSociete2Repository extends JpaRepository<ChiffreAffaireSociete2, Integer> {
//    List<DBloc> findByNomBlocLike(String nomBloc);

}