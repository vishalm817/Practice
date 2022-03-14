package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.Employee;
import com.example.employee.Language;
import com.example.employee.service.LanguageService;


@RestController
public class LanguageController {
	@Autowired
	LanguageService languageService;
	
	@RequestMapping("/employee/{id}/languages")
	public List<Language> getAllLanguages(@PathVariable String id) {
		return languageService.getAllLanguage(id);
	}
	@RequestMapping("/employee/{id}/languages/{languageId}")
	public Language getLanguage(@PathVariable String languageId) {
		return languageService.getLanguage(languageId);
	}

	
	
	@RequestMapping(method = RequestMethod.POST, value = "/employee/{employeeId}/languages")
	public void addLanguage(@RequestBody Language language, @PathVariable String  employeeId) {//pick instance from req body 
		language.setEmployee(new Employee(employeeId,"",""));
		languageService.addLanguage(language);   // calling service method for business logic 
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/employee/{employeeId}/languages/{languageId}")
	public void updateLanguage(@RequestBody Language language,@PathVariable String employeeId, @PathVariable String languageId) {
		language.setEmployee(new Employee(employeeId,"",""));
		languageService.updateLanguage(language);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/{employeeId}/languages/{languageId}")
	public void deleteLanguage(@PathVariable String languageId) {
		languageService.deleteLanguage(languageId);
	}
	
	
	
}
}
