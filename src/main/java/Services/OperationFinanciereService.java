package Services;

import Model.OperationFinanciere;
import repository.OperationFinanciereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationFinanciereService {

    private final OperationFinanciereRepository operationFinanciereRepository;

    @Autowired
    public OperationFinanciereService(OperationFinanciereRepository operationFinanciereRepository) {
        this.operationFinanciereRepository = operationFinanciereRepository;
    }

    public List<OperationFinanciere> findAll() {
        return operationFinanciereRepository.findAll();
    }

    public Optional<OperationFinanciere> findById(Integer id) {
        return operationFinanciereRepository.findById(id);
    }

    public OperationFinanciere save(OperationFinanciere operationFinanciere) {
        return operationFinanciereRepository.save(operationFinanciere);
    }

    public void deleteById(Integer id) {
        operationFinanciereRepository.deleteById(id);
    }
}