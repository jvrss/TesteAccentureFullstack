package com.accenture.testeaccenturefullstackbackend.service;

import com.accenture.testeaccenturefullstackbackend.model.Fornecedor;
import com.accenture.testeaccenturefullstackbackend.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private final FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public List<Fornecedor> getAllFornecedor() {
        return this.repository.findAll();
    }

    public Optional<Fornecedor> getFornecedor(String id) {
        return this.repository.findById(id);
    }

    public Fornecedor putOrSaveFornecedor(Fornecedor fornecedor) {
        return this.repository.save(fornecedor);
    }

    public void deleteFornecedor(String cnpjOrCpf) {
        this.repository.deleteById(cnpjOrCpf);
    }
}
