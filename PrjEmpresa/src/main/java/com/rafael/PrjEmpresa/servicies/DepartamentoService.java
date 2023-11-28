package com.rafael.PrjEmpresa.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.PrjEmpresa.entities.Departamentos;
import com.rafael.PrjEmpresa.repositories.DepartamentoRepository;


@Service
public class DepartamentoService {
private final DepartamentoRepository departamentoRepository;
	
	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository =departamentoRepository;
	}
	
		public Departamentos getDepartamentosById(Long Depcodigo) {
			return departamentoRepository.findById(Depcodigo).orElse(null);
		}
		
		public  List<Departamentos> getAllDepartamentos(){
			return departamentoRepository.findAll();
		}
			
		public Departamentos saveDepartamentos(Departamentos departamentos) {
			return departamentoRepository.save(departamentos);		
		}
		
		public void deleteDepartamentos(Long Depcodigo){
			departamentoRepository.deleteById(Depcodigo);	
		}	


	public Departamentos updateDepartamentos(Long Depcodigo, Departamentos novoDepartamentos) {
		Optional<Departamentos> departamentoOptional = departamentoRepository.findById(Depcodigo);
			if (departamentoOptional.isPresent()) {
				Departamentos funcionarioExistente = departamentoOptional.get();
				funcionarioExistente.setDepnome(novoDepartamentos.getDepnome());
			return departamentoRepository.save(funcionarioExistente); 
			} else {
				return null; 
			}
		    
	}
}

