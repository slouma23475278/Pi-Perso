package Controller;

import Model.OperationFinanciere2;
import Services.OperationFinanciereService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/operationsfinanciere")
public class OperationFinanciereController2 {

    private final OperationFinanciereService2 operationFinanciereService2;

    @Autowired
    public OperationFinanciereController2(OperationFinanciereService2 operationFinanciereService2) {
        this.operationFinanciereService2 = operationFinanciereService2;
    }

    @GetMapping
    public ResponseEntity<List<OperationFinanciere2>> getAllOperationsFinancieres() {
        List<OperationFinanciere2> operationsFinancieres = operationFinanciereService2.findAll();
        return new ResponseEntity<>(operationsFinancieres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationFinanciere2> getOperationFinanciereById(@PathVariable Integer id) {
        Optional<OperationFinanciere2> operationFinanciere = operationFinanciereService2.findById(id);
        return operationFinanciere.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<OperationFinanciere2> createOperationFinanciere(@RequestBody OperationFinanciere2 operationFinanciere2) {
        OperationFinanciere2 savedOperationFinanciere2 = operationFinanciereService2.save(operationFinanciere2);
        return new ResponseEntity<>(savedOperationFinanciere2, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperationFinanciere2> updateOperationFinanciere(@PathVariable Integer id, @RequestBody OperationFinanciere2 operationFinanciere2) {
        Optional<OperationFinanciere2> existingOperationFinanciere = operationFinanciereService2.findById(id);
        if (existingOperationFinanciere.isPresent()) {
            operationFinanciere2.setIdoperation(id);
            OperationFinanciere2 updatedOperationFinanciere2 = operationFinanciereService2.save(operationFinanciere2);
            return new ResponseEntity<>(updatedOperationFinanciere2, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperationFinanciere(@PathVariable Integer id) {
        Optional<OperationFinanciere2> existingOperationFinanciere = operationFinanciereService2.findById(id);
        if (existingOperationFinanciere.isPresent()) {
            operationFinanciereService2.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}