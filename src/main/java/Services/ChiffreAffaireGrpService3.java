package Services;


import Model.ChiffreAffaireGrp2;
import repository.ChiffreAffaire2GrpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiffreAffaireGrpService2 {

    private final ChiffreAffaire2GrpRepository chiffreAffaire2GrpRepository;

    @Autowired
    public ChiffreAffaireGrpService2(ChiffreAffaire2GrpRepository chiffreAffaire2GrpRepository) {
        this.chiffreAffaire2GrpRepository = chiffreAffaire2GrpRepository;
    }

    public List<ChiffreAffaireGrp2> findAll() {
        return chiffreAffaire2GrpRepository.findAll();
    }

    public Optional<ChiffreAffaireGrp2> findById(Integer id) {
        return chiffreAffaire2GrpRepository.findById(id);
    }

    public ChiffreAffaireGrp2 save(ChiffreAffaireGrp2 chiffreAffaireGrp2) {
        return chiffreAffaire2GrpRepository.save(chiffreAffaireGrp2);
    }

    public void deleteById(Integer id) {
        chiffreAffaire2GrpRepository.deleteById(id);
    }
}
