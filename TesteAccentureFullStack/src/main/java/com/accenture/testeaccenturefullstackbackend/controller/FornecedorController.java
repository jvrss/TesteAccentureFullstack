package com.accenture.testeaccenturefullstackbackend.controller;

import com.accenture.testeaccenturefullstackbackend.model.Fornecedor;
import com.accenture.testeaccenturefullstackbackend.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private final FornecedorService service;


    public FornecedorController(FornecedorService service) {
        this.service = service;
    }


    @GetMapping
    public List<Fornecedor> getAllFornecedor() {
        return this.service.getAllFornecedor();
    }

    @GetMapping("/{cnpjOrCpf}")
    public ResponseEntity<Object> getFornecedor(@PathVariable("cnpjOrCpf") String cnpjOrCpf){
        Optional<Fornecedor> optionalFornecedor = this.service.getFornecedor(cnpjOrCpf);
        if(!optionalFornecedor.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalFornecedor.get());
    }

    @PutMapping
    public ResponseEntity<Object> putFornecedor(@Valid @RequestBody Fornecedor fornecedor){
        Optional<Fornecedor> optionalFornecedor = this.service.getFornecedor(fornecedor.getCnpjOrCpf());
        if(!optionalFornecedor.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrada.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(this.service.putOrSaveFornecedor(fornecedor));
    }

    @PostMapping
    public Fornecedor saveFornecedor(@Valid @RequestBody Fornecedor fornecedor){
        return this.service.putOrSaveFornecedor(fornecedor);
    }

    @DeleteMapping("/{cnpjOrCpf}")
    public void deleteFornecedor(@PathVariable("cnpjOrCpf") String cnpjOrCpf) {
        this.service.deleteFornecedor(cnpjOrCpf);
    }

}
