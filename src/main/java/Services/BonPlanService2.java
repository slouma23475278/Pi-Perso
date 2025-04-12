package Services;

import Model.BonPlan1;
import repository.BonPlan1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BonPlanService1 {

    private final BonPlan1Repository bonPlan1Repository;

    @Autowired
    public BonPlanService1(BonPlan1Repository bonPlan1Repository) {
        this.bonPlan1Repository = bonPlan1Repository;
    }

    public List<BonPlan1> findAll() {
        return bonPlan1Repository.findAll();
    }

    public Optional<BonPlan1> findById(Integer id) {
        return bonPlan1Repository.findById(id);
    }

    public BonPlan1 save(BonPlan1 bonPlan1) {
        return bonPlan1Repository.save(bonPlan1);
    }

    public void deleteById(Integer id) {
        bonPlan1Repository.deleteById(id);
    }
}
