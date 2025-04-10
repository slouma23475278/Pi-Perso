package Controller;

import Model.BonPlan1;
import Services.BonPlanService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bonplan")
public class BonPlanController1 {

    private final BonPlanService1 bonPlanService1;

    @Autowired
    public BonPlanController1(BonPlanService1 bonPlanService1) {
        this.bonPlanService1 = bonPlanService1;
    }

    @GetMapping
    public ResponseEntity<List<BonPlan1>> getAllBonPlans() {
        List<BonPlan1> bonPlan1s = bonPlanService1.findAll();
        return new ResponseEntity<>(bonPlan1s, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BonPlan1> getBonPlanById(@PathVariable Integer id) {
        Optional<BonPlan1> bonPlan = bonPlanService1.findById(id);
        return bonPlan.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BonPlan1> createBonPlan(@RequestBody BonPlan1 bonPlan1) {
        BonPlan1 savedBonPlan1 = bonPlanService1.save(bonPlan1);
        return new ResponseEntity<>(savedBonPlan1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BonPlan1> updateBonPlan(@PathVariable Integer id, @RequestBody BonPlan1 bonPlan1) {
        Optional<BonPlan1> existingBonPlan = bonPlanService1.findById(id);
        if (existingBonPlan.isPresent()) {
            bonPlan1.setIdpb(id);
            BonPlan1 updatedBonPlan1 = bonPlanService1.save(bonPlan1);
            return new ResponseEntity<>(updatedBonPlan1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBonPlan(@PathVariable Integer id) {
        Optional<BonPlan1> existingBonPlan = bonPlanService1.findById(id);
        if (existingBonPlan.isPresent()) {
            bonPlanService1.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
