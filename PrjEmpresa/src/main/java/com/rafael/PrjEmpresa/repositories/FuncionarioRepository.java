package com.rafael.PrjEmpresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rafael.PrjEmpresa.entities.Funcionarios;

public interface FuncionarioRepository extends JpaRepository<Funcionarios, Long> {

	@Query("SELECT f FROM Funcionarios f WHERE LOWER(f.funnome) LIKE LOWER(CONCAT('%', :funnome, '%'))")
	List<Funcionarios> findByNomeContaining(@Param("funnome") String funnome);
}
