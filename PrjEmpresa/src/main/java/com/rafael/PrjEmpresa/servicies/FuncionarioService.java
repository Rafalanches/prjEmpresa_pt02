package com.rafael.PrjEmpresa.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.PrjEmpresa.entities.Funcionarios;
import com.rafael.PrjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public List<Funcionarios> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	public Funcionarios getFuncionarioById(long funcodigo) {
		return funcionarioRepository.findById(funcodigo).orElse(null);
	}

	public Funcionarios saveFuncionario(Funcionarios funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public List<Funcionarios> getFuncionariosByFunnomeAproximado(String funnome) {
        return funcionarioRepository.findByNomeContaining(funnome);
    }

	public boolean deleteFuncionario(Long id) {
		Optional<Funcionarios> funcionarioExistente = funcionarioRepository.findById(id);
		if (funcionarioExistente.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Funcionarios updateFuncionario(Long funcodigo, Funcionarios novoFuncionario) {
		Optional<Funcionarios> funcionarioOptional = funcionarioRepository.findById(funcodigo);
		if (funcionarioOptional.isPresent()) {
			Funcionarios funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
			funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
			funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());

			// Atualize o departamento
			if (novoFuncionario.getDepartamentos() != null) {
				funcionarioExistente.setDepartamentos(novoFuncionario.getDepartamentos());
			}		
			return funcionarioRepository.save(funcionarioExistente);
		} else {
			return null; // Ou lançar uma exceção indicando que o funcionário não foi encontrado
		}
	}


}