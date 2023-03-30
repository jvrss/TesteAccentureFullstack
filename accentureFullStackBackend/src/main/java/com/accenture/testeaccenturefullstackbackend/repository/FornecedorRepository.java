package com.accenture.testeaccenturefullstackbackend.repository;

import com.accenture.testeaccenturefullstackbackend.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {
}
