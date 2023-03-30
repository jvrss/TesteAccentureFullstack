package com.accenture.testeaccenturefullstackbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Empresa {

    @Id
    @Size(min = 14, max = 14)
    private String cnpj;

    @NotNull
    @NotEmpty
    private String nomeFantasia;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 8)
    private String cep;

    @ManyToMany
    @JoinTable(name = "empresa_fornecedor",
            joinColumns = { @JoinColumn(name = "id_empresa") },
            inverseJoinColumns = { @JoinColumn(name = "id_fornecedor  ") })
    private List<Fornecedor> fornecedorList;

}
