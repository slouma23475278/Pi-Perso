package Controller;

import Model.BilanFinancier;
import Services.BilanFinancierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bilanfinancier")
public class BilanFinancierController {

    private final BilanFinancierService bilanFinancierService;

    @Autowired
    public BilanFinancierController(BilanFinancierService bilanFinancierService) {
        this.bilanFinancierService = bilanFinancierService;
    }

    @GetMapping
    public ResponseEntity<List<BilanFinancier>> getAllBilanFinanciers() {
        List<BilanFinancier> bilanFinanciers = bilanFinancierService.findAll();
        return new ResponseEntity<>(bilanFinanciers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BilanFinancier> getBilanFinancierById(@PathVariable Integer id) {
        Optional<BilanFinancier> bilanFinancier = bilanFinancierService.findById(id);
        return bilanFinancier.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BilanFinancier> createBilanFinancier(@RequestBody BilanFinancier bilanFinancier) {
        BilanFinancier savedBilanFinancier = bilanFinancierService.save(bilanFinancier);
        return new ResponseEntity<>(savedBilanFinancier, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BilanFinancier> updateBilanFinancier(@PathVariable Integer id, @RequestBody BilanFinancier bilanFinancier) {
        Optional<BilanFinancier> existingBilanFinancier = bilanFinancierService.findById(id);
        if (existingBilanFinancier.isPresent()) {
            bilanFinancier.setIdbf(id);
            BilanFinancier updatedBilanFinancier = bilanFinancierService.save(bilanFinancier);
            return new ResponseEntity<>(updatedBilanFinancier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilanFinancier(@PathVariable Integer id) {
        Optional<BilanFinancier> existingBilanFinancier = bilanFinancierService.findById(id);
        if (existingBilanFinancier.isPresent()) {
            bilanFinancierService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}