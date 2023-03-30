package com.accenture.testeaccenturefullstackbackend.service;

import com.accenture.testeaccenturefullstackbackend.model.Empresa;
import com.accenture.testeaccenturefullstackbackend.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public List<Empresa> getAllEmpresa() {
        return this.repository.findAll();
    }

    public Optional<Empresa> getEmpresa(String id) {
        return this.repository.findById(id);
    }

    public Empresa putOrSaveEmpresa(Empresa empresa) {
        return this.repository.save(empresa);
    }

    public void deleteEmpresa(String id) {
        this.repository.deleteById(id);
    }
}
