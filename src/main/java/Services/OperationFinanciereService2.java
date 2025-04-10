package Services;

import Model.OperationFinanciere2;
import repository.OperationFinanciere2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationFinanciereService2 {

    private final OperationFinanciere2Repository operationFinanciere2Repository;

    @Autowired
    public OperationFinanciereService2(OperationFinanciere2Repository operationFinanciere2Repository) {
        this.operationFinanciere2Repository = operationFinanciere2Repository;
    }

    public List<OperationFinanciere2> findAll() {
        return operationFinanciere2Repository.findAll();
    }

    public Optional<OperationFinanciere2> findById(Integer id) {
        return operationFinanciere2Repository.findById(id);
    }

    public OperationFinanciere2 save(OperationFinanciere2 operationFinanciere2) {
        return operationFinanciere2Repository.save(operationFinanciere2);
    }

    public void deleteById(Integer id) {
        operationFinanciere2Repository.deleteById(id);
    }
}