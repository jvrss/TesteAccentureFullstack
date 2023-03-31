package com.accenture.testeaccenturefullstackbackend.controller;

import com.accenture.testeaccenturefullstackbackend.model.Cep;
import com.accenture.testeaccenturefullstackbackend.service.CepService;
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

        Cep cep = CepService.getCepInfo(empresa.getCep());
        if(cep == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cep inválido!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(this.service.putOrSaveEmpresa(empresa));
    }

    @PostMapping
    public ResponseEntity<Object> saveEmpresa(@Valid @RequestBody Empresa empresa) {
        Cep cep = CepService.getCepInfo(empresa.getCep());
        if(cep == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cep inválido!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(this.service.putOrSaveEmpresa(empresa));
    }

    @DeleteMapping("/{cnpj}")
    public void deleteEmpresa(@PathVariable("cnpj") String cnpj){
        this.service.deleteEmpresa(cnpj);
    }

    
}
