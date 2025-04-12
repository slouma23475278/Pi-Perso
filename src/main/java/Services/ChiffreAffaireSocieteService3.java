package Services;

import Model.ChiffreAffaireSociete2;
import repository.ChiffreAffaireSociete2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiffreAffaireSocieteService2 {

    private final ChiffreAffaireSociete2Repository chiffreAffaireSociete2Repository;

    @Autowired
    public ChiffreAffaireSocieteService2(ChiffreAffaireSociete2Repository chiffreAffaireSociete2Repository) {
        this.chiffreAffaireSociete2Repository = chiffreAffaireSociete2Repository;
    }

    public List<ChiffreAffaireSociete2> findAll() {
        return chiffreAffaireSociete2Repository.findAll();
    }

    public Optional<ChiffreAffaireSociete2> findById(Integer id) {
        return chiffreAffaireSociete2Repository.findById(id);
    }

    public ChiffreAffaireSociete2 save(ChiffreAffaireSociete2 chiffreAffaireSociete2) {
        return chiffreAffaireSociete2Repository.save(chiffreAffaireSociete2);
    }

    public void deleteById(Integer id) {
        chiffreAffaireSociete2Repository.deleteById(id);
    }
}