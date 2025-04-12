package Services;


import Model.BilanFinancier2;
import repository.BilanFinancier2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BilanFinancierService2 {

    private final BilanFinancier2Repository bilanFinancier2Repository;

    @Autowired
    public BilanFinancierService2(BilanFinancier2Repository bilanFinancier2Repository) {
        this.bilanFinancier2Repository = bilanFinancier2Repository;
    }

    public List<BilanFinancier2> findAll() {
        return bilanFinancier2Repository.findAll();
    }

    public Optional<BilanFinancier2> findById(Integer id) {
        return bilanFinancier2Repository.findById(id);
    }

    public BilanFinancier2 save(BilanFinancier2 bilanFinancier2) {
        return bilanFinancier2Repository.save(bilanFinancier2);
    }

    public void deleteById(Integer id) {
        bilanFinancier2Repository.deleteById(id);
    }
}