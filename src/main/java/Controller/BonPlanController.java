package Controller;

import Model.BonPlan;
import Services.BonPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bonplan")
public class BonPlanController {

    private final BonPlanService bonPlanService;

    @Autowired
    public BonPlanController(BonPlanService bonPlanService) {
        this.bonPlanService = bonPlanService;
    }

    @GetMapping
    public ResponseEntity<List<BonPlan>> getAllBonPlans() {
        List<BonPlan> bonPlans = bonPlanService.findAll();
        return new ResponseEntity<>(bonPlans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BonPlan> getBonPlanById(@PathVariable Integer id) {
        Optional<BonPlan> bonPlan = bonPlanService.findById(id);
        return bonPlan.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BonPlan> createBonPlan(@RequestBody BonPlan bonPlan) {
        BonPlan savedBonPlan = bonPlanService.save(bonPlan);
        return new ResponseEntity<>(savedBonPlan, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BonPlan> updateBonPlan(@PathVariable Integer id, @RequestBody BonPlan bonPlan) {
        Optional<BonPlan> existingBonPlan = bonPlanService.findById(id);
        if (existingBonPlan.isPresent()) {
            bonPlan.setIdpb(id);
            BonPlan updatedBonPlan = bonPlanService.save(bonPlan);
            return new ResponseEntity<>(updatedBonPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBonPlan(@PathVariable Integer id) {
        Optional<BonPlan> existingBonPlan = bonPlanService.findById(id);
        if (existingBonPlan.isPresent()) {
            bonPlanService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
