package com.rafael.PrjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.PrjEmpresa.entities.Departamentos;

public interface DepartamentoRepository extends JpaRepository<Departamentos, Long> {

}