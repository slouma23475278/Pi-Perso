package Services;

import Model.ChiffreAffaireSociete;
import repository.ChiffreAffaireSocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiffreAffaireSocieteService {

    private final ChiffreAffaireSocieteRepository chiffreAffaireSocieteRepository;

    @Autowired
    public ChiffreAffaireSocieteService(ChiffreAffaireSocieteRepository chiffreAffaireSocieteRepository) {
        this.chiffreAffaireSocieteRepository = chiffreAffaireSocieteRepository;
    }

    public List<ChiffreAffaireSociete> findAll() {
        return chiffreAffaireSocieteRepository.findAll();
    }

    public Optional<ChiffreAffaireSociete> findById(Integer id) {
        return chiffreAffaireSocieteRepository.findById(id);
    }

    public ChiffreAffaireSociete save(ChiffreAffaireSociete chiffreAffaireSociete) {
        return chiffreAffaireSocieteRepository.save(chiffreAffaireSociete);
    }

    public void deleteById(Integer id) {
        chiffreAffaireSocieteRepository.deleteById(id);
    }
}