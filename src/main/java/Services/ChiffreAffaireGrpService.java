package Services;


import Model.ChiffreAffaireGrp;
import repository.ChiffreAffaireGrpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiffreAffaireGrpService {

    private final ChiffreAffaireGrpRepository chiffreAffaireGrpRepository;

    @Autowired
    public ChiffreAffaireGrpService(ChiffreAffaireGrpRepository chiffreAffaireGrpRepository) {
        this.chiffreAffaireGrpRepository = chiffreAffaireGrpRepository;
    }

    public List<ChiffreAffaireGrp> findAll() {
        return chiffreAffaireGrpRepository.findAll();
    }

    public Optional<ChiffreAffaireGrp> findById(Integer id) {
        return chiffreAffaireGrpRepository.findById(id);
    }

    public ChiffreAffaireGrp save(ChiffreAffaireGrp chiffreAffaireGrp) {
        return chiffreAffaireGrpRepository.save(chiffreAffaireGrp);
    }

    public void deleteById(Integer id) {
        chiffreAffaireGrpRepository.deleteById(id);
    }
}
