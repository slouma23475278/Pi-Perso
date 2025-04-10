package Controller;

import Model.BilanFinancier2;
import Services.BilanFinancierService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bilanfinancier")
public class BilanFinancierController2 {

    private final BilanFinancierService2 bilanFinancierService2;

    @Autowired
    public BilanFinancierController2(BilanFinancierService2 bilanFinancierService2) {
        this.bilanFinancierService2 = bilanFinancierService2;
    }

    @GetMapping
    public ResponseEntity<List<BilanFinancier2>> getAllBilanFinanciers() {
        List<BilanFinancier2> bilanFinancier2s = bilanFinancierService2.findAll();
        return new ResponseEntity<>(bilanFinancier2s, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BilanFinancier2> getBilanFinancierById(@PathVariable Integer id) {
        Optional<BilanFinancier2> bilanFinancier = bilanFinancierService2.findById(id);
        return bilanFinancier.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BilanFinancier2> createBilanFinancier(@RequestBody BilanFinancier2 bilanFinancier2) {
        BilanFinancier2 savedBilanFinancier2 = bilanFinancierService2.save(bilanFinancier2);
        return new ResponseEntity<>(savedBilanFinancier2, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BilanFinancier2> updateBilanFinancier(@PathVariable Integer id, @RequestBody BilanFinancier2 bilanFinancier2) {
        Optional<BilanFinancier2> existingBilanFinancier = bilanFinancierService2.findById(id);
        if (existingBilanFinancier.isPresent()) {
            bilanFinancier2.setIdbf(id);
            BilanFinancier2 updatedBilanFinancier2 = bilanFinancierService2.save(bilanFinancier2);
            return new ResponseEntity<>(updatedBilanFinancier2, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilanFinancier(@PathVariable Integer id) {
        Optional<BilanFinancier2> existingBilanFinancier = bilanFinancierService2.findById(id);
        if (existingBilanFinancier.isPresent()) {
            bilanFinancierService2.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}