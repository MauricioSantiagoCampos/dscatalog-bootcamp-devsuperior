package com.devsuperior.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
				
		// Cria uma lista de Category
				List<Category> list = repository.findAll();
				
		// Converter a lista de Category para CategoryDTO
		/* 
		 * - list - List em Category
		 * - .stream() - transforma de List para stream 
		 * - .map(x -> new CategoryDTO(x)) - Aplica a função map, para transformar cada componente Category, para CategoryDTO
		 * - collect(Collectors.toList()) - Transforma de stream para List * 
		 */
				return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
}
