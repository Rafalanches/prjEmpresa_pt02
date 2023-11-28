package com.rafael.PrjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.PrjEmpresa.entities.Departamentos;
import com.rafael.PrjEmpresa.servicies.DepartamentoService;


@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

	@GetMapping("/home")
    public String paginaInicial() {
        return "index";
    }
	private final DepartamentoService departamentoService;
	
	@Autowired
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;		
	}
	@GetMapping("/{depcodigo}")	
    public ResponseEntity<Departamentos> getJogo(@PathVariable Long depcodigo) {
		Departamentos departamentos = departamentoService.getDepartamentosById(depcodigo);
        if (departamentos != null) {
            return ResponseEntity.ok(departamentos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }	
	@PostMapping
	public Departamentos createDepartamentos(@RequestBody Departamentos departamentos) {
		return departamentoService.saveDepartamentos(departamentos);
	}
	
	@DeleteMapping("/{depcodigo}")
	public void deleteDepartamentos(@PathVariable Long depcodigo) {
		departamentoService.deleteDepartamentos(depcodigo);
	}
	
		@GetMapping
		public ResponseEntity<List<Departamentos>> getAllDepartamentos(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Departamentos> departamentos = departamentoService.getAllDepartamentos();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(departamentos);
		}
		
		@PutMapping("/{id}")
		public Departamentos updateDepartamentos(@PathVariable Long id, @RequestBody Departamentos departamentos) {
		    return departamentoService.updateDepartamentos(id, departamentos);
		}
	
}
