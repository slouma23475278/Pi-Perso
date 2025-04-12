package Controller;

import Model.ChiffreAffaireSociete2;
import Services.ChiffreAffaireSocieteService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chiffreaffairesociete")
public class ChiffreAffaireSocieteController2 {

    private final ChiffreAffaireSocieteService2 chiffreAffaireSocieteService2;

    @Autowired
    public ChiffreAffaireSocieteController2(ChiffreAffaireSocieteService2 chiffreAffaireSocieteService2) {
        this.chiffreAffaireSocieteService2 = chiffreAffaireSocieteService2;
    }

    @GetMapping
    public ResponseEntity<List<ChiffreAffaireSociete2>> getAllChiffreAffaireSocietes() {
        List<ChiffreAffaireSociete2> chiffreAffaireSociete2s = chiffreAffaireSocieteService2.findAll();
        return new ResponseEntity<>(chiffreAffaireSociete2s, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChiffreAffaireSociete2> getChiffreAffaireSocieteById(@PathVariable Integer id) {
        Optional<ChiffreAffaireSociete2> chiffreAffaireSociete = chiffreAffaireSocieteService2.findById(id);
        return chiffreAffaireSociete.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ChiffreAffaireSociete2> createChiffreAffaireSociete(@RequestBody ChiffreAffaireSociete2 chiffreAffaireSociete2) {
        ChiffreAffaireSociete2 savedChiffreAffaireSociete2 = chiffreAffaireSocieteService2.save(chiffreAffaireSociete2);
        return new ResponseEntity<>(savedChiffreAffaireSociete2, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChiffreAffaireSociete2> updateChiffreAffaireSociete(@PathVariable Integer id, @RequestBody ChiffreAffaireSociete2 chiffreAffaireSociete2) {
        Optional<ChiffreAffaireSociete2> existingChiffreAffaireSociete = chiffreAffaireSocieteService2.findById(id);
        if (existingChiffreAffaireSociete.isPresent()) {
            chiffreAffaireSociete2.setIdcas(id);
            ChiffreAffaireSociete2 updatedChiffreAffaireSociete2 = chiffreAffaireSocieteService2.save(chiffreAffaireSociete2);
            return new ResponseEntity<>(updatedChiffreAffaireSociete2, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChiffreAffaireSociete(@PathVariable Integer id) {
        Optional<ChiffreAffaireSociete2> existingChiffreAffaireSociete = chiffreAffaireSocieteService2.findById(id);
        if (existingChiffreAffaireSociete.isPresent()) {
            chiffreAffaireSocieteService2.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
