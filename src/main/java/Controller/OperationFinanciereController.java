package Controller;

import Model.OperationFinanciere;
import Services.OperationFinanciereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/operationsfinanciere")
public class OperationFinanciereController {

    private final OperationFinanciereService operationFinanciereService;

    @Autowired
    public OperationFinanciereController(OperationFinanciereService operationFinanciereService) {
        this.operationFinanciereService = operationFinanciereService;
    }

    @GetMapping
    public ResponseEntity<List<OperationFinanciere>> getAllOperationsFinancieres() {
        List<OperationFinanciere> operationsFinancieres = operationFinanciereService.findAll();
        return new ResponseEntity<>(operationsFinancieres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationFinanciere> getOperationFinanciereById(@PathVariable Integer id) {
        Optional<OperationFinanciere> operationFinanciere = operationFinanciereService.findById(id);
        return operationFinanciere.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<OperationFinanciere> createOperationFinanciere(@RequestBody OperationFinanciere operationFinanciere) {
        OperationFinanciere savedOperationFinanciere = operationFinanciereService.save(operationFinanciere);
        return new ResponseEntity<>(savedOperationFinanciere, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperationFinanciere> updateOperationFinanciere(@PathVariable Integer id, @RequestBody OperationFinanciere operationFinanciere) {
        Optional<OperationFinanciere> existingOperationFinanciere = operationFinanciereService.findById(id);
        if (existingOperationFinanciere.isPresent()) {
            operationFinanciere.setIdoperation(id);
            OperationFinanciere updatedOperationFinanciere = operationFinanciereService.save(operationFinanciere);
            return new ResponseEntity<>(updatedOperationFinanciere, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperationFinanciere(@PathVariable Integer id) {
        Optional<OperationFinanciere> existingOperationFinanciere = operationFinanciereService.findById(id);
        if (existingOperationFinanciere.isPresent()) {
            operationFinanciereService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}