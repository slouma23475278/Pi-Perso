package Services;


import Model.BilanFinancier;
import repository.BilanFinancierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BilanFinancierService {

    private final BilanFinancierRepository bilanFinancierRepository;

    @Autowired
    public BilanFinancierService(BilanFinancierRepository bilanFinancierRepository) {
        this.bilanFinancierRepository = bilanFinancierRepository;
    }

    public List<BilanFinancier> findAll() {
        return bilanFinancierRepository.findAll();
    }

    public Optional<BilanFinancier> findById(Integer id) {
        return bilanFinancierRepository.findById(id);
    }

    public BilanFinancier save(BilanFinancier bilanFinancier) {
        return bilanFinancierRepository.save(bilanFinancier);
    }

    public void deleteById(Integer id) {
        bilanFinancierRepository.deleteById(id);
    }
}