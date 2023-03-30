package com.accenture.testeaccenturefullstackbackend.repository;

import com.accenture.testeaccenturefullstackbackend.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String> {
}
