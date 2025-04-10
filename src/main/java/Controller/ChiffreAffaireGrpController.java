package Controller;

import Model.ChiffreAffaireGrp;
import Services.ChiffreAffaireGrpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chiffreaffairegrp")
public class ChiffreAffaireGrpController {

    private final ChiffreAffaireGrpService chiffreAffaireGrpService;

    @Autowired
    public ChiffreAffaireGrpController(ChiffreAffaireGrpService chiffreAffaireGrpService) {
        this.chiffreAffaireGrpService = chiffreAffaireGrpService;
    }

    @GetMapping
    public ResponseEntity<List<ChiffreAffaireGrp>> getAllChiffreAffaireGrps() {
        List<ChiffreAffaireGrp> chiffreAffaireGrps = chiffreAffaireGrpService.findAll();
        return new ResponseEntity<>(chiffreAffaireGrps, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChiffreAffaireGrp> getChiffreAffaireGrpById(@PathVariable Integer id) {
        Optional<ChiffreAffaireGrp> chiffreAffaireGrp = chiffreAffaireGrpService.findById(id);
        return chiffreAffaireGrp.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ChiffreAffaireGrp> createChiffreAffaireGrp(@RequestBody ChiffreAffaireGrp chiffreAffaireGrp) {
        ChiffreAffaireGrp savedChiffreAffaireGrp = chiffreAffaireGrpService.save(chiffreAffaireGrp);
        return new ResponseEntity<>(savedChiffreAffaireGrp, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChiffreAffaireGrp> updateChiffreAffaireGrp(@PathVariable Integer id, @RequestBody ChiffreAffaireGrp chiffreAffaireGrp) {
        Optional<ChiffreAffaireGrp> existingChiffreAffaireGrp = chiffreAffaireGrpService.findById(id);
        if (existingChiffreAffaireGrp.isPresent()) {
            chiffreAffaireGrp.setIdgrp(id);
            ChiffreAffaireGrp updatedChiffreAffaireGrp = chiffreAffaireGrpService.save(chiffreAffaireGrp);
            return new ResponseEntity<>(updatedChiffreAffaireGrp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChiffreAffaireGrp(@PathVariable Integer id) {
        Optional<ChiffreAffaireGrp> existingChiffreAffaireGrp = chiffreAffaireGrpService.findById(id);
        if (existingChiffreAffaireGrp.isPresent()) {
            chiffreAffaireGrpService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
