package com.accenture.testeaccenturefullstackbackend.controller;

import com.accenture.testeaccenturefullstackbackend.service.EmpresaService;
import com.accenture.testeaccenturefullstackbackend.model.Empresa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private final EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Empresa> getAllEmpresa(){
        return this.service.getAllEmpresa();
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Object> getEmpresa(@PathVariable("cnpj") String cnpj){
        Optional<Empresa> empresaOptional = this.service.getEmpresa(cnpj);
        if(!empresaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(empresaOptional.get());
    }

    @PutMapping
    public ResponseEntity<Object> putEmpresa(@Valid @RequestBody Empresa empresa){
        Optional<Empresa> empresaOptional = this.service.getEmpresa(empresa.getCnpj());
        if(!empresaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(this.service.putOrSaveEmpresa(empresa));
    }

    @PostMapping
    public Empresa saveEmpresa(@Valid @RequestBody Empresa empresa) {
        return this.service.putOrSaveEmpresa(empresa);
    }

    @DeleteMapping("/{cnpj}")
    public void deleteEmpresa(@PathVariable("cnpj") String cnpj){
        this.service.deleteEmpresa(cnpj);
    }

    
}
