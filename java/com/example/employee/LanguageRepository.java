package com.example.employee;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface LanguageRepository extends CrudRepository<Language, String>{
	public List<Language>  findByEmployeeId(String employeeId);

}
