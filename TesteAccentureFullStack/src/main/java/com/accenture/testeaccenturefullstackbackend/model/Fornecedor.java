package com.accenture.testeaccenturefullstackbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Fornecedor {

    @Id
    @NotNull
    @NotEmpty
    @Size(min = 11, max = 14)
    private String cnpjOrCpf;

    @NotNull
    @NotEmpty
    private String nome;

    @Email
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 8)
    private String cep;

    @Size(min = 9, max = 9)
    private String rg;

    private LocalDate dataNascimento;
    
    @JsonBackReference
    @ManyToMany(mappedBy = "fornecedorList")
    private List<Empresa> empresasList;
}
