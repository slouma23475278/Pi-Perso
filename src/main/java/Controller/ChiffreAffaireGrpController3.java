package Controller;

import Model.ChiffreAffaireGrp2;
import Services.ChiffreAffaireGrpService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chiffreaffairegrp")
public class ChiffreAffaireGrpController2 {

    private final ChiffreAffaireGrpService2 chiffreAffaireGrpService2;

    @Autowired
    public ChiffreAffaireGrpController2(ChiffreAffaireGrpService2 chiffreAffaireGrpService2) {
        this.chiffreAffaireGrpService2 = chiffreAffaireGrpService2;
    }

    @GetMapping
    public ResponseEntity<List<ChiffreAffaireGrp2>> getAllChiffreAffaireGrps() {
        List<ChiffreAffaireGrp2> chiffreAffaireGrp2s = chiffreAffaireGrpService2.findAll();
        return new ResponseEntity<>(chiffreAffaireGrp2s, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChiffreAffaireGrp2> getChiffreAffaireGrpById(@PathVariable Integer id) {
        Optional<ChiffreAffaireGrp2> chiffreAffaireGrp = chiffreAffaireGrpService2.findById(id);
        return chiffreAffaireGrp.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ChiffreAffaireGrp2> createChiffreAffaireGrp(@RequestBody ChiffreAffaireGrp2 chiffreAffaireGrp2) {
        ChiffreAffaireGrp2 savedChiffreAffaireGrp2 = chiffreAffaireGrpService2.save(chiffreAffaireGrp2);
        return new ResponseEntity<>(savedChiffreAffaireGrp2, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChiffreAffaireGrp2> updateChiffreAffaireGrp(@PathVariable Integer id, @RequestBody ChiffreAffaireGrp2 chiffreAffaireGrp2) {
        Optional<ChiffreAffaireGrp2> existingChiffreAffaireGrp = chiffreAffaireGrpService2.findById(id);
        if (existingChiffreAffaireGrp.isPresent()) {
            chiffreAffaireGrp2.setIdgrp(id);
            ChiffreAffaireGrp2 updatedChiffreAffaireGrp2 = chiffreAffaireGrpService2.save(chiffreAffaireGrp2);
            return new ResponseEntity<>(updatedChiffreAffaireGrp2, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChiffreAffaireGrp(@PathVariable Integer id) {
        Optional<ChiffreAffaireGrp2> existingChiffreAffaireGrp = chiffreAffaireGrpService2.findById(id);
        if (existingChiffreAffaireGrp.isPresent()) {
            chiffreAffaireGrpService2.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
