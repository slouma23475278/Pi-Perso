package repository;

import Model.Article3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Article3Repository extends JpaRepository<Article3, Integer> {
//    List<DBloc> findByNomBlocLike(String nomBloc);
}
