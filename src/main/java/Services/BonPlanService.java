package Services;

import Model.BonPlan;
import repository.BonPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BonPlanService {

    private final BonPlanRepository bonPlanRepository;

    @Autowired
    public BonPlanService(BonPlanRepository bonPlanRepository) {
        this.bonPlanRepository = bonPlanRepository;
    }

    public List<BonPlan> findAll() {
        return bonPlanRepository.findAll();
    }

    public Optional<BonPlan> findById(Integer id) {
        return bonPlanRepository.findById(id);
    }

    public BonPlan save(BonPlan bonPlan) {
        return bonPlanRepository.save(bonPlan);
    }

    public void deleteById(Integer id) {
        bonPlanRepository.deleteById(id);
    }
}
