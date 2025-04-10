package Controller;

import Model.ChiffreAffaireSociete;
import Services.ChiffreAffaireSocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chiffreaffairesociete")
public class ChiffreAffaireSocieteController {

    private final ChiffreAffaireSocieteService chiffreAffaireSocieteService;

    @Autowired
    public ChiffreAffaireSocieteController(ChiffreAffaireSocieteService chiffreAffaireSocieteService) {
        this.chiffreAffaireSocieteService = chiffreAffaireSocieteService;
    }

    @GetMapping
    public ResponseEntity<List<ChiffreAffaireSociete>> getAllChiffreAffaireSocietes() {
        List<ChiffreAffaireSociete> chiffreAffaireSocietes = chiffreAffaireSocieteService.findAll();
        return new ResponseEntity<>(chiffreAffaireSocietes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChiffreAffaireSociete> getChiffreAffaireSocieteById(@PathVariable Integer id) {
        Optional<ChiffreAffaireSociete> chiffreAffaireSociete = chiffreAffaireSocieteService.findById(id);
        return chiffreAffaireSociete.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ChiffreAffaireSociete> createChiffreAffaireSociete(@RequestBody ChiffreAffaireSociete chiffreAffaireSociete) {
        ChiffreAffaireSociete savedChiffreAffaireSociete = chiffreAffaireSocieteService.save(chiffreAffaireSociete);
        return new ResponseEntity<>(savedChiffreAffaireSociete, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChiffreAffaireSociete> updateChiffreAffaireSociete(@PathVariable Integer id, @RequestBody ChiffreAffaireSociete chiffreAffaireSociete) {
        Optional<ChiffreAffaireSociete> existingChiffreAffaireSociete = chiffreAffaireSocieteService.findById(id);
        if (existingChiffreAffaireSociete.isPresent()) {
            chiffreAffaireSociete.setIdcas(id);
            ChiffreAffaireSociete updatedChiffreAffaireSociete = chiffreAffaireSocieteService.save(chiffreAffaireSociete);
            return new ResponseEntity<>(updatedChiffreAffaireSociete, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChiffreAffaireSociete(@PathVariable Integer id) {
        Optional<ChiffreAffaireSociete> existingChiffreAffaireSociete = chiffreAffaireSocieteService.findById(id);
        if (existingChiffreAffaireSociete.isPresent()) {
            chiffreAffaireSocieteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
